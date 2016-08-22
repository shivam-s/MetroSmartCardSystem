package delhi.metro.system.service.impl;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

import delhi.metro.system.beans.CardTransaction;
import delhi.metro.system.beans.MetroCard;
import delhi.metro.system.beans.Station;
import delhi.metro.system.calculator.FareCalculator;
import delhi.metro.system.dao.impl.DataProviderImpl;
import delhi.metro.system.db.DataBaseCollection;
import delhi.metro.system.exceptions.InsufficientFundsException;
import delhi.metro.system.factory.DataBaseCollectionFactory;
import delhi.metro.system.factory.FareStrategiesFactory;
import delhi.metro.system.service.MetroService;

public class MetroServiceImpl implements MetroService {

	private DataBaseCollection dbCollection = DataBaseCollectionFactory
			.getInstance();
	private DataProviderImpl trxRepository = new DataProviderImpl();
	private FareCalculator fareCalculator = new FareCalculator();

	private ConcurrentMap<Station, Integer> stationFootFall = dbCollection
			.getStationFootFall();

	public void swipeIn(MetroCard card, Station source, Calendar dateTime)
			throws InsufficientFundsException {
		if (card.getBalance() < 5.5) {
			throw new InsufficientFundsException(
					"Minimumum Balance required to swipe-in is :", 5.5);
		}
		if (stationFootFall.putIfAbsent(source, 1) != null) {
			stationFootFall.put(source,
					stationFootFall.get(source).intValue() + 1);
		}
		CardTransaction trx = new CardTransaction();
		trx.setSourceStation(source);
		trx.setCard(card);
		trx.setStartTime(dateTime);
		trxRepository.addTransientTrx(card, trx);
	}

	public void swipeOut(MetroCard card, Station destination, Calendar dateTime)
			throws InsufficientFundsException {
		if (stationFootFall.putIfAbsent(destination, 1) != null) {
			stationFootFall.put(destination, stationFootFall.get(destination)
					.intValue() + 1);
		}
		CardTransaction trx = trxRepository.getTransientTrx(card);
		if (!trx.getSourceStation().equals(destination)) {
			trx.setDestinationStation(destination);
			trx.setEndTime(dateTime);
			trx.setFare(fareCalculator.getFare(trx.getSourceStation(),
					trx.getDestinationStation(), dateTime));
			if (trx.getFare() > card.getBalance()) {
				throw new InsufficientFundsException(
						"Please recharge card by atleast ", trx.getFare()
								- card.getBalance());
			}
			trx.setFairStrategyUsed(FareStrategiesFactory
					.getFareStrategy(dateTime));
			trx.setBalance(card.getBalance() - trx.getFare());
			card.setBalance(card.getBalance() - trx.getFare());
			trxRepository.addCompletedTrx(card, trx);
		}
	}

	public int calculateFootFall(Station station) {
		if (stationFootFall.containsKey(station)) {
			return stationFootFall.get(station);
		}
		return 0;
	}

	public List<CardTransaction> cardReport(MetroCard card) {
		List<CardTransaction> trxs = trxRepository.getCompletedTrxs(card);
		for (CardTransaction t : trxs) {
			System.out.println("Card Id = " + t.getCard().getCardId()
					+ " Source Station = "
					+ t.getSourceStation().getStationName()
					+ " Destination Station = "
					+ t.getDestinationStation().getStationName() + " Fare= "
					+ t.getFare() + " Balance = " + t.getBalance());
		}
		return trxs;
	}
}

package delhi.metro.system.test;

import java.util.Calendar;
import java.util.List;

import delhi.metro.system.beans.CardTransaction;
import delhi.metro.system.beans.MetroCard;
import delhi.metro.system.beans.Station;
import delhi.metro.system.beans.Traveller;
import delhi.metro.system.exceptions.InsufficientFundsException;
import delhi.metro.system.service.MetroService;
import delhi.metro.system.service.impl.MetroServiceImpl;

public class TestSuit {
	private MetroService metroService = new MetroServiceImpl();
	private MetroCard card;
	Station A1 = new Station(1, "A1", 1);
	Station A2 = new Station(2, "A2", 2);
	Station A3 = new Station(3, "A3", 3);
	Station A4 = new Station(4, "A4", 4);
	Station A5 = new Station(5, "A5", 5);
	Station A6 = new Station(6, "A6", 6);
	Station A7 = new Station(7, "A7", 7);
	Station A8 = new Station(8, "A8", 8);
	Station A9 = new Station(9, "A9", 9);
	Station A10 = new Station(10, "A10", 10);
	Calendar cd = Calendar.getInstance();

	public static void main(String[] args) {
		TestSuit ts = new TestSuit();
		ts.init();
		try {
			ts.allTransactionsCases();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ts.testCalculateFootFallForStation();
			ts.testCardReport();
		}
	}

	public void allTransactionsCases() throws InsufficientFundsException {
		cd.set(2016, 3, 2, 18, 25);
		metroService.swipeIn(card, A1, cd);
		cd.set(2016, 3, 2, 27, 35);
		metroService.swipeOut(card, A2, cd);
		cd.set(2016, 3, 6, 18, 25);
		metroService.swipeIn(card, A3, cd);
		cd.set(2016, 3, 6, 18, 35);
		metroService.swipeOut(card, A7, cd);
		cd.set(2016, 3, 7, 19, 05);
		metroService.swipeIn(card, A4, cd);
		cd.set(2016, 3, 7, 19, 15);
		metroService.swipeOut(card, A6, cd);
		cd.set(2016, 3, 8, 28, 40);
		metroService.swipeIn(card, A7, cd);
		cd.set(2016, 3, 8, 50, 11);
		metroService.swipeOut(card, A10, cd);
	}

	public void init() {
		card = new MetroCard();
		card.setCardId(1);
		card.setBalance(100);
		card.setTraveller(new Traveller(1L, "Shivam"));
	}

	public void testCalculateFootFallForStation() {
		System.out.println("Footfall for station A1 : "
				+ metroService.calculateFootFall(A7));
	}

	public void testCardReport() {
		List<CardTransaction> trxs = metroService.cardReport(card);
		System.out.println("total number of travels : " + trxs.size());
	}
}

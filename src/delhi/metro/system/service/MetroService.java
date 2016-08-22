package delhi.metro.system.service;

import java.util.Calendar;
import java.util.List;

import delhi.metro.system.beans.CardTransaction;
import delhi.metro.system.beans.MetroCard;
import delhi.metro.system.beans.Station;
import delhi.metro.system.exceptions.InsufficientFundsException;

public interface MetroService {

	public void swipeIn(MetroCard card, Station source, Calendar dateTime) throws InsufficientFundsException;

	public void swipeOut(MetroCard card, Station destination, Calendar dateTime) throws InsufficientFundsException;

	public int calculateFootFall(Station station);

	public List<CardTransaction> cardReport(MetroCard card);


}

package delhi.metro.system.dao;

import java.util.List;
import delhi.metro.system.beans.CardTransaction;
import delhi.metro.system.beans.MetroCard;

public interface DataProvider {

	public void addCompletedTrx(MetroCard card, CardTransaction trx);

	public void addTransientTrx(MetroCard card, CardTransaction trx);

	public CardTransaction getTransientTrx(MetroCard card);

	public List<CardTransaction> getCompletedTrxs(MetroCard card);
}

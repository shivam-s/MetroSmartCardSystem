package delhi.metro.system.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import delhi.metro.system.beans.CardTransaction;
import delhi.metro.system.beans.MetroCard;
import delhi.metro.system.dao.DataProvider;
import delhi.metro.system.db.DataBaseCollection;
import delhi.metro.system.factory.DataBaseCollectionFactory;

public class DataProviderImpl implements DataProvider {

	private DataBaseCollection dbCollection = DataBaseCollectionFactory
			.getInstance();

	public void addCompletedTrx(MetroCard card, CardTransaction trx) {
		dbCollection.getCompletedTrxStore().putIfAbsent(card,
				new ArrayList<CardTransaction>());
		dbCollection.getCompletedTrxStore().get(card).add(trx);
	}

	public List<CardTransaction> getCompletedTrxs(MetroCard card) {
		if (dbCollection.getCompletedTrxStore().containsKey(card)) {
			return dbCollection.getCompletedTrxStore().get(card);
		}
		return Collections.emptyList();
	}

	public void addTransientTrx(MetroCard card, CardTransaction trx) {
		dbCollection.getTransientTrxStore().put(card, trx);
	}

	public CardTransaction getTransientTrx(MetroCard card) {
		return dbCollection.getTransientTrxStore().remove(card);
	}
}

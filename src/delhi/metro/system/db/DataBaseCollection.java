package delhi.metro.system.db;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import delhi.metro.system.beans.CardTransaction;
import delhi.metro.system.beans.MetroCard;
import delhi.metro.system.beans.Station;



/**
 * @author Shivam
 * Data Structure class will have the data of all the transactions / just like db
 *
 */
public class DataBaseCollection {
	private ConcurrentMap<MetroCard, CardTransaction> transientTrxStore = new ConcurrentHashMap<>();
	private ConcurrentMap<MetroCard, List<CardTransaction>> completedTrxStore = new ConcurrentHashMap<>();
	private ConcurrentMap<Station, Integer> stationFootFall = new ConcurrentHashMap<Station, Integer>();

	public ConcurrentMap<MetroCard, CardTransaction> getTransientTrxStore() {
		return transientTrxStore;
	}

	public void setTransientTrxStore(
			ConcurrentMap<MetroCard, CardTransaction> transientTrxStore) {
		this.transientTrxStore = transientTrxStore;
	}

	public ConcurrentMap<MetroCard, List<CardTransaction>> getCompletedTrxStore() {
		return completedTrxStore;
	}

	public void setCompletedTrxStore(
			ConcurrentMap<MetroCard, List<CardTransaction>> completedTrxStore) {
		this.completedTrxStore = completedTrxStore;
	}

	public ConcurrentMap<Station, Integer> getStationFootFall() {
		return stationFootFall;
	}

	public void setStationFootFall(
			ConcurrentMap<Station, Integer> stationFootFall) {
		this.stationFootFall = stationFootFall;
	}
}

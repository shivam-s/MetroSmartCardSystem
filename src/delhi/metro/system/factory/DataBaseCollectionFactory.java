package delhi.metro.system.factory;

import delhi.metro.system.db.DataBaseCollection;



/**
 * @author Shivam
 * Class to ensure that there will be only one dbCollection object at a time
 */
public class DataBaseCollectionFactory {

	private static volatile DataBaseCollection dbCollection;

	public static DataBaseCollection getInstance() {
		if (dbCollection == null) {
			synchronized (DataBaseCollection.class) {
				if (dbCollection == null) {
					dbCollection = new DataBaseCollection();
				}
			}
		}
		return dbCollection;
	}
}

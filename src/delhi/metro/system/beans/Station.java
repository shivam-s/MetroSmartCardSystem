package delhi.metro.system.beans;



/**
 * @author Shivam
 * This is pojo of Station
 *
 */
public class Station {

	private int stationNumber;
	private String stationName;
	// distance from first starting station
	private int distance;

	public Station(int stationNumber, String stationName, int distance) {
		super();
		this.stationNumber = stationNumber;
		this.stationName = stationName;
		this.distance = distance;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public int getStationNumber() {
		return stationNumber;
	}

	public void setStationNumber(int stationNumber) {
		this.stationNumber = stationNumber;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public boolean equals(Object obj) {
		Station st = (Station) obj;
		if (obj == null) {
			return false;
		}
		if (this.stationNumber == st.getStationNumber()) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return stationNumber + super.hashCode();
	}

	@Override
	public String toString() {
		return "Station [stationNumber=" + stationNumber + ", stationName="
				+ stationName + ", distance=" + distance + "]";
	}
}

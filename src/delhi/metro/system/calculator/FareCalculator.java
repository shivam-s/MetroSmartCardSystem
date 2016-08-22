package delhi.metro.system.calculator;

import java.util.Calendar;

import delhi.metro.system.beans.Station;
import delhi.metro.system.factory.FareStrategiesFactory;
import delhi.metro.system.fare.strategies.FareStrategy;


/**
 * @author shivam
 * Class is for calculating the distance between two stations
 * distance of any station we will measure based on the first station
 *
 */
public class FareCalculator {
	public double getFare(Station source, Station destination, Calendar cal) {
		FareStrategy fareStrategy = FareStrategiesFactory.getFareStrategy(cal);
		int distance = Math.abs(source.getDistance()
				- destination.getDistance());
		double fare = distance * fareStrategy.getFarePerStation();
		return fare;
	}

}

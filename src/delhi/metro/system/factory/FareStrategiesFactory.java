package delhi.metro.system.factory;

import java.util.Calendar;

import delhi.metro.system.fare.strategies.FareStrategy;
import delhi.metro.system.fare.strategies.WeekdayFareStrategy;
import delhi.metro.system.fare.strategies.WeekendFareStrategy;

public class FareStrategiesFactory {

	private static final FareStrategy weekendStrategy = new WeekendFareStrategy();
	private static final FareStrategy weekdayStrategy = new WeekdayFareStrategy();

	@SuppressWarnings("deprecation")
	public static FareStrategy getFareStrategy(Calendar cal) {
		if (cal.getTime().getDay() == (Calendar.SATURDAY - 1)
				|| cal.getTime().getDay() == Calendar.SUNDAY - 1) {
			return weekendStrategy;
		} else {
			return weekdayStrategy;
		}
	}
}

package delhi.metro.system.fare.strategies;

public class WeekdayFareStrategy implements FareStrategy {

	@Override
	public String getName() {
		return WeekdayFareStrategy.class.toString();
	}

	@Override
	public double getFarePerStation() {
		return 7;
	}
}

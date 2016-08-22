package delhi.metro.system.fare.strategies;

public class WeekendFareStrategy implements FareStrategy {

	@Override
	public String getName() {
		return WeekendFareStrategy.class.toString();
	}

	@Override
	public double getFarePerStation() {
		return 5.5;
	}

}

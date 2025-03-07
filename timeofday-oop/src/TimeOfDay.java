/**
 * Each instance of this class stores a time of day
 * given by a number of hours and a number of minutes.
 * 
 * @invar | 0 <= getHours() && getHours() < 24
 * @invar | 0 <= getMinutes() && getMinutes() < 60
 * @invar | getMinutesSinceMidnight() == getHours() * 60 + getMinutes()
 */
public class TimeOfDay {
	
	/**
	 * @invar | 0 <= minutesSinceMidnight && minutesSinceMidnight < 24*60
	 */
	private int minutesSinceMidnight;
	
	public int getHours() { return minutesSinceMidnight / 60; }
	public int getMinutes() { return minutesSinceMidnight % 60; }
	public int getMinutesSinceMidnight() { return minutesSinceMidnight; }
	
	/**
	 * @throws IllegalArgumentException | hours < 0 || 23 < hours
	 * @throws IllegalArgumentException | minutes < 0 || 59 < minutes
	 * @post | getHours() == hours
	 * @post | getMinutes() == minutes
	 */
	public TimeOfDay(int hours, int minutes) {
		if (hours < 0)
			throw new IllegalArgumentException("`hours` is less than zero");
		if (23 < hours)
			throw new IllegalArgumentException("`hours` is greater than 23");
		if (minutes < 0 || 59 < minutes)
			throw new IllegalArgumentException("`minutes` is out of bounds");
		
		minutesSinceMidnight = hours * 60 + minutes;
	}

	/**
	 * @pre | 0 <= hours && hours < 24
	 * @mutates | this
	 * @post | getHours() == hours
	 * @post | getMinutes() == old(getMinutes())
	 */
	public void setHours(int hours) {
		minutesSinceMidnight = hours * 60 + minutesSinceMidnight % 60;
	}
	
	/**
	 * @pre | 0 <= minutes && minutes < 60
	 * @mutates | this
	 * @post | getHours() == old(getHours())
	 * @post | getMinutes() == minutes
	 */
	public void setMinutes(int minutes) {
		minutesSinceMidnight = minutesSinceMidnight / 60 * 60 + minutes;
	}
	
	/**
	 * @pre | 0 <= minutesSinceMidnight && minutesSinceMidnight < 24 * 60
	 * @mutates | this
	 * @post | getMinutesSinceMidnight() == minutesSinceMidnight
	 */
	public void setMinutesSinceMidnight(int minutesSinceMidnight) {
		this.minutesSinceMidnight = minutesSinceMidnight;
	}
}

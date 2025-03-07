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
	 * @invar | 0 <= hours && hours <= 23
	 * @invar | 0 <= minutes && minutes <= 59
	 */
	private int hours;
	private int minutes;
	
	public int getHours() { return hours; }
	public int getMinutes() { return minutes; }
	public int getMinutesSinceMidnight() {
		return hours * 60 + minutes;
	}
	
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
		
		this.hours = hours;
		this.minutes = minutes;
	}

	/**
	 * @pre | 0 <= hours && hours < 24
	 * @mutates | this
	 * @post | getHours() == hours
	 * @post | getMinutes() == old(getMinutes())
	 */
	public void setHours(int hours) {
		this.hours = hours;
	}
	
	/**
	 * @pre | 0 <= minutes && minutes < 60
	 * @mutates | this
	 * @post | getHours() == old(getHours())
	 * @post | getMinutes() == minutes
	 */
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	
	/**
	 * @pre | 0 <= minutesSinceMidnight && minutesSinceMidnight < 24 * 60
	 * @mutates | this
	 * @post | getMinutesSinceMidnight() == minutesSinceMidnight
	 */
	public void setMinutesSinceMidnight(int minutesSinceMidnight) {
		this.hours = minutesSinceMidnight / 60;
		this.minutes = minutesSinceMidnight % 60;
	}
}

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TimeOfDayTest {

	@Test
	void test() {
		TimeOfDay myTimeOfDay = new TimeOfDay(10, 30);
		assertEquals(10, myTimeOfDay.getHours());
		assertEquals(30, myTimeOfDay.getMinutes());
		assertEquals(630, myTimeOfDay.getMinutesSinceMidnight());
		
		myTimeOfDay.setHours(13);
		assertEquals(13, myTimeOfDay.getHours());
		assertEquals(30, myTimeOfDay.getMinutes());
		assertEquals(13*60 + 30, myTimeOfDay.getMinutesSinceMidnight());
		
		myTimeOfDay.setMinutes(0);
		assertEquals(13, myTimeOfDay.getHours());
		assertEquals(0, myTimeOfDay.getMinutes());
		assertEquals(13*60, myTimeOfDay.getMinutesSinceMidnight());
		
		myTimeOfDay.setMinutesSinceMidnight(661);
		assertEquals(11, myTimeOfDay.getHours());
		assertEquals(1, myTimeOfDay.getMinutes());
		assertEquals(661, myTimeOfDay.getMinutesSinceMidnight());
	}

}

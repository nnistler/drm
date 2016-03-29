package sp.drm;

import java.util.Calendar;
import java.util.Locale;

import sp.drm.interfaces.CalendarService;

public class ClockService implements CalendarService {
	public Calendar getCalendar() {
		return Calendar.getInstance(Locale.US);
	}
}
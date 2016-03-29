package sp.drm;

import sp.drm.interfaces.CalendarService;

public class DateService {
	private CalendarService service;

	public DateService(CalendarService service) {
		this.service = service;
	}

	public String getDateString() {
		return service.getCalendar().toString();
	}
}
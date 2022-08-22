package entities;

import java.util.Date;
import java.util.List;

public interface AdministerEvent {
	void addEvent(Event event);
	List<Event> getListEvents();
	void editEvent(Event event, String name, Date date);
	void deleteEvent(Event event);
	Event getEventByNumber(int numberEvent);
}

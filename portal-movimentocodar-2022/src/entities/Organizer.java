package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import controller.EventController;

public class Organizer extends People implements AdministerEvent{

	private List<Event> listEvents = new ArrayList<>();
	
	public Organizer(String name, String email, String phone, String password) {
		super(name, email, phone, password);
	}

	public List<Event> getListEvents() {
		return listEvents;
	}

	public void addEvent(Event event) {
		listEvents.add(event);
	}
	
	public void editEvent(Event event, String name, Date date) {
		EventController.editEvent(listEvents, event, name, date);
	}
	
	public void deleteEvent(Event event) {
		EventController.deleteEvent(listEvents, event);
	}

	public Event getEventByNumber(int numberEvent) {
		Event findByNumber = EventController.getEventByNumber(listEvents, numberEvent);
		return findByNumber;
	}

	@Override
	public String toString() {
		return "\nNome: " + getName() +
				"\nEmail: " + getEmail() +
				"\nTelefone: " + getPhone();
	}
}

package controller;

import java.util.Date;
import java.util.List;

import entities.Event;

public class EventController {
	
	public static void editEvent(List<Event> listEvents, Event event, String name, Date date) {
		Event selectedEvent = null;

		for (int i = 0; i < listEvents.size(); i++) {
			if (listEvents.get(i) == event) {
				selectedEvent = event;
			}
		}

		selectedEvent.setName(name);
		selectedEvent.setDate(date);
	}

	public static void deleteEvent(List<Event> listEvents, Event event) {
		listEvents.removeIf(x -> x.getName() == event.getName());
		System.out.println("Evento " + event.getName() + " foi removido");
	}

	public static Event getEventByNumber(List<Event> listEvents, int numberEvent) {

		Event findByNumber = listEvents.stream()
				.filter(ev -> ev.getNumberEvent() == numberEvent)
				.findFirst()
				.orElse(null);
		return findByNumber;

	}

}

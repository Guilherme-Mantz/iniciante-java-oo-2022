package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Event {
	
	private static SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
	private static int counterNumberEvent = 1;
	
	private int numberEvent;
	private String name;
	private Date date;
	
	public Event(String name, Date date) {
		this.numberEvent = Event.counterNumberEvent;
		this.name = name;
		this.date = date;
		Event.counterNumberEvent += 1;
	}
	
	public int getNumberEvent() {
		return numberEvent;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "\n" + "\nNumero do evento: " + getNumberEvent() +
				"\nNome do Evento: " + getName() +
				"\nData do Evento: " + formatDate.format(getDate());
	}
	
}

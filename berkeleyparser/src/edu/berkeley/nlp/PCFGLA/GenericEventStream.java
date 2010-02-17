package edu.berkeley.nlp.PCFGLA;

import java.util.ArrayList;

import opennlp.maxent.Event;
import opennlp.maxent.EventStream;

public class GenericEventStream implements EventStream {

	ArrayList<Event> events;
	int currentIndex;
	
	public GenericEventStream() {
		events = new ArrayList<Event>();
		currentIndex = -1;
	}
	
	@Override
	public boolean hasNext() {
		return !(currentIndex == events.size()-1);
	}

	@Override
	public Event nextEvent() {
		return events.get(++currentIndex);
	}
		
	public void addEvent(String outcome, String[] context) {
		events.add(new Event(outcome, context));
	}	
}

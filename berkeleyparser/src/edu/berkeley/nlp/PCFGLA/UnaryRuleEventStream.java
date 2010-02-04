package edu.berkeley.nlp.PCFGLA;

import java.util.ArrayList;

import opennlp.maxent.Event;
import opennlp.maxent.EventStream;

public class UnaryRuleEventStream implements EventStream {
	
	ArrayList<Event> events;
	int currentIndex;
	
	public UnaryRuleEventStream() {
		this.events = new ArrayList<Event>();
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
	
	public void addUnaryRule(UnaryRule unaryRule) {
		events.add(unaryRuleToEvent(unaryRule));
	}
	
	public static Event unaryRuleToEvent(UnaryRule unaryRule) {
		Event event = new Event(unaryRule.toStringSEIE(), getContext(unaryRule));
		
		return event;
	}
	
	public static String[] getContext(UnaryRule unaryRule) {
		return new String[] {unaryRule.toStringSEIE().split("->")[0]};
	}
	
	public static String[] getContext(String binaryRule) {
		return new String[] {binaryRule.split("->")[0]};
	}


}

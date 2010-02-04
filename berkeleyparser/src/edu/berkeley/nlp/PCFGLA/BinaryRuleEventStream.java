package edu.berkeley.nlp.PCFGLA;

import java.util.ArrayList;

import opennlp.maxent.Event;
import opennlp.maxent.EventStream;

public class BinaryRuleEventStream implements EventStream {

	ArrayList<Event> events;
	int currentIndex;
	
	public BinaryRuleEventStream() {
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
	
	public void addBinaryRule(BinaryRule binaryRule) {
		events.add(binaryRuleToEvent(binaryRule));
	}
	
	public void addEvent(String outcome, String[] context) {
		events.add(new Event(outcome, context));
	}
	
	public static String[] getContext(String binaryRule) {
		return new String[] {binaryRule.split("->")[0]};
	}
	
	public static Event binaryRuleToEvent(BinaryRule binaryRule) {
		Event event = new Event(binaryRule.toStringSEIE(), getContext(binaryRule));
		
		return event;
	}
	
	public static String[] getContext(BinaryRule binaryRule) {
		return new String[] {binaryRule.toStringSEIE().split("->")[0]};
	}
}

package hw7;
/***************************************************************
 * Builds an event for probability analysis. 
 ***************************************************************/
import java.text.DecimalFormat;

public class Event {
	String event;
	float probability;
	
	public Event(float probability) {
		this.probability = probability;
	}
	
	public Event(String event, float probability) {
		this.event = event;
		this.probability = probability;
	}
	
	//The complement of a probability 
	public float negate() {
		return 1 - probability;
	}

	public String getEvent() {
		return event;
	}

	public float getProbability() {
		return probability;
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.##");
		return event + ": " + df.format(probability*100) + "%";
	}
	

	
}

package se.erikalexandersson.adventofcode.helpers;

@SuppressWarnings("serial")
public class DuplicateFrequencyFoundException extends Exception {

	private int frequency;

	public DuplicateFrequencyFoundException(int frequency) {
		super();
		this.frequency = frequency;
	}

	public Object getFrequency() {
		return frequency;
	}

}

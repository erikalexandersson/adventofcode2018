package se.erikalexandersson.adventofcode.helpers;

public enum Race {
	ELF('E'), GOBLIN('G');

	char marker;

	private Race(char marker) {
		this.marker = marker;
	}

	public char getMarker() {
		return marker;
	}

}

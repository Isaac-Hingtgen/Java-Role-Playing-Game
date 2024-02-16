package main.java.ser316.rpg.consumables;

public abstract class DurationBasedConsumable extends Consumables {
	protected int duration = 3;

	public void decrementDuration() {
		this.duration--;
	}

	public boolean isExpired() {
		return duration <= 0;
	}
}

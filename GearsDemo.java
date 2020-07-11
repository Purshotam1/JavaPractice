package assignment;

import java.util.Objects;

class Wheel {
	final private double rim, tire;

	public Wheel(double rim, double tire) {
		this.rim = rim;
		this.tire = tire;
	}

	public double getDiameter() {
		return rim + (tire * 2);
	}

	public double getRim() {
		return rim;
	}

	public double getTire() {
		return tire;
	}
}

class Gear {
	final private double chainring, cog;
	final private Wheel wheel;

	public Gear(double chainring, double cog) {
		this.chainring = chainring;
		this.cog = cog;
	}

	public Gear(double chainring, double cog, Wheel wheel) {
		this.chainring = chainring;
		this.cog = cog;
		this.wheel = new Wheel(wheel.getRim(), wheel.getTire());
	}

	public double getChainring() {
		return chainring;
	}

	public double getCog() {
		return cog;
	}

	public Wheel getWheel() {
		return wheel;
	}

	public double getRatio() {
		if (cog == 0) {
			System.out.println("Cog cannot be zero");
			return -1;
		} else {
			return chainring/cog;
		}
	}

	public double getGearInches() {
		return getRatio() * wheel.getDiameter();
	}
}

public class GearsDemo {
	public static void playWithGears() {
		Wheel wheel1 = new Wheel(26, 1.5);
		Gear gear1 = new Gear(52, 11);
		System.out.println(gear1.getRatio());

		Gear gear2 = new Gear(52, 11, wheel1);
		System.out.println(gear2.getGearInches());
	}

	public static void main(String[] args) {
		playWithGears();
	}
}
package assignment;

import java.util.Objects;

interface RoundObject {
	public double getDiameter(); 
}

class Wheel implements RoundObject {
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
	private RoundObject wheel = null;

	public Gear(double chainring, double cog) {
		this.chainring = chainring;
		this.cog = cog;
	}

	public Gear(double chainring, double cog, RoundObject wheel) {
		this.chainring = chainring;
		this.cog = cog;
		this.wheel = wheel;
	}

	public double getChainring() {
		return chainring;
	}

	public double getCog() {
		return cog;
	}

	public RoundObject getWheel() {
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
		if (wheel != null) {
			return getRatio() * wheel.getDiameter();
		} else {
			System.out.println("Wheel variable is null");
			return -1;
		}
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
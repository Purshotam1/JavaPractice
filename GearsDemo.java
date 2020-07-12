package assignment;

import java.util.Objects;

class Gear {
	final private double chainring, cog;

	public Gear() {
		this(0, 0);
	}

	public Gear(double chainring, double cog) {
		this.chainring = chainring;
		this.cog = cog;
	}

	public double getChainring() {
		return chainring;
	}

	public double getCog() {
		return cog;
	}

	public double getRatio() {
		if (cog == 0) {
			System.out.println("Cog cannot be zero");
			return -1;
		} else {
			return chainring/cog;
		}
	}

	public double getGearInches(double diameter) {
		return getRatio() * diameter;
	}
}


class Wheel {
	final private double rim, tire;
	final private Gear gear;

	public Wheel() {
		this(0, 0);
	}

	public Wheel(double rim, double tire) {
		this.rim = rim;
		this.tire = tire;
		this.gear = null;
	}

	public Wheel(double rim, double tire, double chainring, double cog) {
		this.rim = rim;
		this.tire = tire;
		this.gear = getGear(chainring, cog);
	}

	public double getRim() {
		return rim;
	}

	public double getTire() {
		return tire;
	}

	private Gear getGear(double chainring, double cog) {
		return new Gear(chainring, cog);
	}

	public double getDiameter() {
		return rim + (tire * 2);
	}

	public double getGearInches() {
		if (gear != null) {
			return gear.getGearInches(getDiameter());
		} else {
			System.out.println("Gear is null");
			return -1;
		}
	} 

}


public class GearsDemo {
	public static void playWithGears() {

		Gear gear = new Gear(52, 11);
		System.out.println(gear.getRatio());

		Wheel wheel1 = new Wheel(26, 1.5);
		System.out.println(wheel1.getDiameter());

		Wheel wheel2 = new Wheel(26, 1.5, gear.getChainring(), gear.getCog());
		System.out.println(wheel2.getGearInches());
	}

	public static void main(String[] args) {
		playWithGears();
	}
}
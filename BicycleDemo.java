package assignment;

import java.util.*;

class Bicycle {
	private String size, chain;
	private double tireSize;

	public Bicycle() {
		size = "";
		chain = "";
		tireSize = 0;
	} 

	public Bicycle(HashMap<String, String> args) {
		size = args.get("size");
		chain = args.containsKey("chain") ? args.get("chain") : defaultChain();
		tireSize = args.containsKey("tireSize") ? Double.parseDouble(args.get("tireSize")) : defaultTireSize();
	}

	public String getSize() {
		return size;
	}

	public String getChain() {
		return chain;
	}

	public double getTireSize() {
		return tireSize;
	}

	public HashMap<String, String> getSpares() {
		HashMap<String, String> spares = new HashMap<>();
		spares.put("tireSize", Double.toString(tireSize));
		spares.put("chain", chain);
		
		HashMap<String, String> localSpares = getLocalSpares();
		
		localSpares.forEach( 
            (key, value) 
                -> spares.merge( 
                    key, 
                    value, 
                    (v1, v2) 
                        -> v1.equalsIgnoreCase(v2) 
                               ? v1 
                               : v1 + ", " + v2));

        return spares; 
	}

	public double defaultTireSize() {
		return 0;
	}

	public String defaultChain() {
		return "10-speed";
	}

	public HashMap<String, String> getLocalSpares() {
		return new HashMap<String, String>();
	}
}

class RoadBike extends Bicycle {
	private String tapeColor;

	public RoadBike() {
		super();
		tapeColor = "";
	}

	public RoadBike(HashMap<String,String> args) {
		super(args);
		tapeColor = args.get("tapeColor");
	}

	public String getTapeColor() {
		return tapeColor;
	}

	public HashMap<String, String> getLocalSpares() {
		HashMap<String, String> spares = new HashMap<>();
		spares.put("tapeColor", tapeColor);

		return spares;
	}

	public double defaultTireSize() {
		return 23;
	}
}

class MountainBike extends Bicycle {
	private String frontShock, rearShock;

	public MountainBike() {
		super();
		frontShock = "";
		rearShock = "";
	}

	public MountainBike(HashMap<String, String> args) {
		super(args);
		frontShock = args.get("frontShock");
		rearShock = args.get("rearShock");
	}

	public String getFrontShock() {
		return frontShock;
	}
	public String getRearShock() {
		return rearShock;
	}

	public HashMap<String, String> getLocalSpares() {
		HashMap<String, String> spares = new HashMap<>();
		spares.put("frontShock", frontShock);
		spares.put("rearShock", rearShock);

		return spares;
	}

	public double defaultTireSize() {
		return 2.1;
	}
}

public class BicycleDemo {

	public static void playWithBicycle() {
		Bicycle bike1 = new MountainBike(new HashMap<String, String>() {{
			put("size", "M");
			put("frontShock", "Mautio");
			put("rearShock", "Fox");
		}});

		System.out.println(bike1.getSpares());

		Bicycle bike2 = new RoadBike(new HashMap<String, String>() {{
			put("size", "S");
			put("tapeColor", "Red");
		}});

		System.out.println(bike2.getSpares());
	}

	public static void main(String[] args) {
		playWithBicycle();
	}
} 
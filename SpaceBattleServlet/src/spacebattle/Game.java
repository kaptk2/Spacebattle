package spacebattle;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private static List<Ship> ships = new ArrayList<Ship>();
	public static List<Ship> getShips() { return ships; }
	
	public static void updateState() {
		for (Ship ship: ships) {
			ship.update();
		}
	}
	
	static {
		new Thread(new UpdateRunnable()).start();
	}
}

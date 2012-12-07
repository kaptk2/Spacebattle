package spacebattle;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private static List<Bullet> bullets = new ArrayList<Bullet>();
 	private static List<Collidable> collidables = new ArrayList<Collidable>();

	private static List<Ship> ships = new ArrayList<Ship>();
	public static List<Ship> getShips() { return ships; }
	
	
	public static void updateState() {
		for (Ship ship: ships) {
			ship.update();
		}
		
		collidables = new ArrayList<Collidable>(ships.addAll(bullets));
		ArrayList<Collidable> toRemove = new ArrayList<Collidable>();
		
		for(i = 0; i < collidables.size(); i++){
			for(j = 0; j < collidables.size(); j++){
				if(i != j){
					double x1 = collidables.get(i).getX();
					double y1 = collidables.get(i).getY();
					double x2 = collidables.get(j).getX();
					double y2 = collidables.get(j).getY();
					double cx1 = x1 + (collidables.get(i).getSize() / 2);
					double cy1 = y1 + (collidables.get(i).getSize() / 2);
					double cx2 = x2 + (collidables.get(j).getSize() / 2);
					double cy2 = y2 + (collidables.get(j).getSize() / 2);
					double dx = cx1 - cx2;
					double dy = cy1 - cy2;
					double distance = sqrt((dx*dx)+(dy*dy));
					double maxDistance = (collidable.get(i).getSize / 2) + (collidable.get(i).getSize() / 2);
					if(distance < maxDistance){
						toRemove.add(collidables.get(i));
						toRemove.add(collidables.get(j));
					}
					
				}
			}
		}
		collidables.removeAll(toRemove);
	}
	
	static {
		new Thread(new UpdateRunnable()).start();
	}
}

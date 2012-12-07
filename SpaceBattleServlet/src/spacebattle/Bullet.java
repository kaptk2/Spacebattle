package spacebattle;

import java.util.Date;

public class Bullet extends Collidable {

    private double dx;
    private double dy;
    private double heading;
    private lastTimeUpdated;

    public Bullet(){
  size = 2.0;
	x = 10.0;
	y = 10.0;
	heading = 0.0;
	lastTimeUpdated = 0;
    }

    public Bullet(double x, double y, double heading){
	size = 2.0;
	this.x = x;
	this.y = y;
	this.heading = heading;
	lastTimeUpdated = Date().getTime();
    }

    public void update(){
	long now = System.currentTimeMillis();
	double dT = (now - lastTimeUpdated)*0.0001; // in seconds
	dx = cos(heading);
	dy = sin(heading);
	x = x + dx*dT;
	y = y + dy*dT;
	lastTimeUpdated = now;
    }
}
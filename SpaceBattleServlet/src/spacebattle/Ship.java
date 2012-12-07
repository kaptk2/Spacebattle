<<<<<<< HEAD:SpaceBattleServlet/src/spacebattle/Ship.java.head
package spacebattle;

import java.util.Date;

public class Ship {
	private String id;
	private double x;
	private double y;
	private double dx;
	private double dy;
	private double ax;
	private double ay;
	private double heading;
	private long lastTimeUpdated;
	
	public Ship(String id, double x, double y) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.dx = 0;
		this.dy = 0;
		this.ax = 0;
		this.ay = 0;
		this.heading = 0;
		this.lastTimeUpdated = new Date().getTime();
	}
	public String getID() {return id;}
	public double getX() { return x; }
	public double getY() { return y; }
	public double getDX() { return dx; }
	public double getDY() { return dy; }
	public double getAX() { return ax; }
	public double getAY() { return ay; }
	public double getHeading() { return heading; }
	
	public void setAcceleration(double ax, double ay) {
		this.update();
		this.ax = ax;
		this.ay = ay;
	}
	
	public void setHeading( double newHeading ){
		this.update();
		long now = System.currentTimeMillis();
		double dT = (now - lastTimeUpdated)*0.0001; // in seconds
		this.heading = (newHeading + dT*100) % 360.0;
	}
	
	public void update() {
		long now = System.currentTimeMillis();
		double dT = (now - lastTimeUpdated)*0.0001; // in seconds
		this.dx = this.dx + dT * this.ax;
		this.dy = this.dy + dT * this.ay;
		this.x = this.x + dT * this.dx;
		this.y = this.y + dT * this.dy;
		lastTimeUpdated = now;

		int mapsize = 600;
		if(this.x > mapsize) {
			this.x = this.x - mapsize;
		}

		if(this.x < 0) {
			this.x = this.x + mapsize;
		}

		if(this.y > mapsize) {
			this.y = this.y - mapsize;
		}

		if(this.y < 0) {
			this.y = this.y + mapsize;
		}
	}
}
=======
package spacebattle;

import java.util.Date;

public class Ship extends Collidable {
    private String id;
    private double dx;
    private double dy;
    private double ax;
    private double ay;
    private double heading;
    private long lastTimeUpdated;
    
    public Ship(String id, double x, double y) {
	this.id = id;
	this.x = x;
	this.y = y;
	this.dx = 0;
	this.dy = 0;
	this.ax = 0;
	this.ay = 0;
	this.heading = 0;
	this.lastTimeUpdated = new Date().getTime();
    }
    public double getDX() { return dx; }
    public double getDY() { return dy; }
    public double getAX() { return ax; }
    public double getAY() { return ay; }
    public double getHeading() { return heading; }
    
    public void setAcceleration(double ax, double ay) {
	this.update();
	this.ax = ax;
	this.ay = ay;
    }
    
    public void setHeading( double newHeading ){
	this.update();
	this.heading = newHeading;
    }
    
    public void update() {
	long now = System.currentTimeMillis();
	double dT = (now - lastTimeUpdated)*0.0001; // in seconds
	this.dx = this.dx + dT * this.ax;
	this.dy = this.dy + dT * this.ay;
	this.x = this.x + dT * this.dx;
	this.y = this.y + dT * this.dy;
	lastTimeUpdated = now;
	this.heading = (this.heading + dT*100) % 360.0;
	
	int mapsize = 600;
	if(this.x > mapsize) {
	    this.x = this.x - mapsize;
	}
	
	if(this.x < 0) {
	    this.x = this.x + mapsize;
	}
	
	if(this.y > mapsize) {
	    this.y = this.y - mapsize;
	}
	
	if(this.y < 0) {
	    this.y = this.y + mapsize;
	}
    }
}
>>>>>>> 9b78c47b12cd71bf250c8915aa4160e9970b5c26:SpaceBattleServlet/src/spacebattle/Ship.java

package spacebattle;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Action extends HttpServlet {
	private final int HEADING_CHANGE = 3;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		String id = req.getParameter("id");
		String action = req.getParameter("action");
		
		List<Ship> ships = Game.getShips();
		
		Ship userShip = null;
		
		for( Ship ship : ships ){
			if( ship.getID().equals(id) ){
				userShip = ship;
			}
		}
		
		double currHeading = userShip.getHeading();
		
		switch( action ){
			case "forward":
				userShip.setAcceleration( userShip.getAX() + Math.sin(currHeading), userShip.getAY() -Math.cos(currHeading) );
				break;
			case "left":
				if( ( currHeading - HEADING_CHANGE ) < 0 ){
					userShip.setHeading( 360 + (currHeading - HEADING_CHANGE) );
				}
				else{
					userShip.setHeading( currHeading - HEADING_CHANGE );
				}
				
				break;
				
			case "right":
				if( ( currHeading + HEADING_CHANGE ) > 359 ){
					userShip.setHeading( HEADING_CHANGE - 1 );
				}
				else{
					userShip.setHeading( currHeading + HEADING_CHANGE );
				}
				break;
				
			case "shoot":
				//TODO Add implementation for when a user presses the fire button
				break;
		}
	}
}

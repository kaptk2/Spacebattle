package spacebattle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@SuppressWarnings("serial")
public class NewPlayer extends HttpServlet implements HttpSessionListener {
	
	private int rx = (int)(Math.random()*200);
	private int ry = (int)(Math.random()*200);

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getSession(true);
		PrintWriter writer = resp.getWriter();
		writer.println("[{" +
				"'shipId': '" + req.getSession().getId() + "'}];");
	}

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		String id = event.getSession().getId();
		Ship ship = new Ship(id, rx, ry);
		Game.getShips().add(ship);
		event.getSession().setMaxInactiveInterval(15);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		List<Ship> ships = Game.getShips();
		String id = event.getSession().getId();
		for( Ship ship : ships ){
			if( ship.getID().equals(id ) ){
				ships.remove(ship);
			}
		}
	}
}

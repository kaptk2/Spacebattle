package spacebattle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Status extends HttpServlet {
	@SuppressWarnings("unused")
	private int count=0;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.print("[");
		boolean firstTime = true;
		for (Ship ship: Game.getShips()) {
			if (firstTime) {
				firstTime = false; 
			} else {
				writer.print(",");
			}
			writer.print("{\"x\":\""+ship.getX()+"\", \"y\":\""+ship.getY()+
					"\", \"dx\":\""+ship.getDX()+"\", \"dy\":\""+ship.getDY()+
					"\", \"ax\":\""+ship.getAX()+"\", \"ay\":\""+ship.getAY()+
					"\", \"h\":\""+ship.getHeading()+"\", \"id\":\""+ship.getID()+"\"}");
		}
		writer.println("]");
	}

}

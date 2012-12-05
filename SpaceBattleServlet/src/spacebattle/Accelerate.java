package spacebattle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Accelerate extends HttpServlet {
	private int count=0;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		String axs = req.getParameter("ax");
		String ays = req.getParameter("ay");
		double ax = Double.parseDouble(axs);
		double ay = Double.parseDouble(ays);
		
		PrintWriter writer = resp.getWriter();

		for (Ship ship:Game.getShips()) {
			if (ship.getID().equals(id)) {
				ship.setAcceleration(ax, ay);
				writer.println("OK, id="+id);
				return;
			}
		}
		writer.println("FAIL, unknown ship id="+id);
	}

}

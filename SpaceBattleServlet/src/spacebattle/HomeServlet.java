package spacebattle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet {
	private int count=0;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.println("<html>");
		writer.println("<h1>Space Battle!</h1><br/>And this is to prove it's working...");
		writer.println("<br/>count="+count);
		count++;
		writer.println("and i'm trying a live update now");
		writer.println("</html>");
	}

}

package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowAllCarsServlet
 */
@WebServlet("/ShowAllCarsServlet")
public class ShowAllCarsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ShowAllCarsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserInfoHelper allCars = new UserInfoHelper();
		
		request.setAttribute("allCars", allCars.showAllCars());
		
		String path = "/viewAllCars.jsp";
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

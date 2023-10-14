package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CarDealership;


/**
 * Servlet implementation class userEntryServlet
 */
@WebServlet("/userEntryServlet")
public class UserEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserEntryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userEntryOne = request.getParameter("userModle");
		String userEntryTwo = request.getParameter("userDescription");
		String userEntryThree = request.getParameter("userPrice");
		String status = "available";
		double userEntryThreeAsDouble;

		try 
		{
		    userEntryThreeAsDouble = Double.parseDouble(userEntryThree);
		} 
		catch (NumberFormatException e) 
		{
		    userEntryThreeAsDouble = 0.0; 
		}
		
		if (userEntryOne.isEmpty() || userEntryTwo.isEmpty() || userEntryThree.isEmpty() || userEntryOne == null || userEntryTwo == null || userEntryThree == null) 
		{
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		} 
		else 
		{
			CarDealership car = new CarDealership(userEntryOne, userEntryTwo, userEntryThreeAsDouble, status);
			UserInfoHelper getInfoObj = new UserInfoHelper();
			getInfoObj.insertItem(car);
			getServletContext().getRequestDispatcher("/Index.jsp").forward(request, response);
		}
	}
}
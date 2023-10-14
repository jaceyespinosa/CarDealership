package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CarDealership;

/**
 * Servlet implementation class navServlet
 */
@WebServlet("/navServlet")
public class NavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    UserInfoHelper uih = new UserInfoHelper();
	    String act = request.getParameter("doThisToItem");
	    String path = "/Index.jsp";

	    if (act != null) {
	        switch (act) {
	            case "delete":
	                try {
	                    Integer tempId = Integer.parseInt(request.getParameter("id"));
	                    CarDealership itemToDelete = uih.searchForItemById(tempId);
	                    uih.deleteItem(itemToDelete);
	                } catch (NumberFormatException e) {
	                    System.out.println("Forgot to select an item");
	                }
	                break;
	            case "edit":
	                try {
	                    Integer tempId = Integer.parseInt(request.getParameter("id"));
	                    CarDealership itemToEdit = uih.searchForItemById(tempId);
	                    request.setAttribute("itemToEdit", itemToEdit);
	                    path = "/editCar.jsp";
	                } catch (NumberFormatException e) {
	                    System.out.println("Forgot to select an item");
	                }
	                break;
	            case "add":
	                path = "/Index.jsp";
	                break;
	            case "purchase":
	                try {
	                    Integer tempId = Integer.parseInt(request.getParameter("id"));
	                    CarDealership carToPurchase = uih.searchForItemById(tempId);
	                    if (carToPurchase != null) {
	                        carToPurchase.setStatus("bought");
	                        uih.updateItem(carToPurchase);
	                        path = "/Index.jsp";  
	                    } else {
	                        System.out.println("Car not found");
	                    }
	                } catch (NumberFormatException e) {
	                    System.out.println("Forgot to select a car");
	                }
	                break;
	        }
	    } else {
	        System.out.println("No action provided.");
	    }

	    getServletContext().getRequestDispatcher(path).forward(request, response);
	}
}
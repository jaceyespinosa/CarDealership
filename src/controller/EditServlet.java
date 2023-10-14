package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CarDealership;


/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
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
		UserInfoHelper dao = new UserInfoHelper();
		
		String model = request.getParameter("model");
		String Description = request.getParameter("Description");
		String Price = request.getParameter("Price");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		double tempPrice = Double.parseDouble(Price);	
		
		CarDealership itemToUpdate = dao.searchForItemById(tempId);
		itemToUpdate.setModel(model);
		itemToUpdate.setDescription(Description);
		itemToUpdate.setPrice(tempPrice);
				
		dao.updateItem(itemToUpdate);

		getServletContext().getRequestDispatcher("/Index.jsp").forward(request, response);
	}

}
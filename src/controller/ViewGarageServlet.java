package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Garage;

@WebServlet("/ViewGarageServlet")
public class ViewGarageServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = "currentUser";

        GarageHelper garageHelper = new GarageHelper();
        List<Garage> userCars = garageHelper.getCarsForUser(username);

        request.setAttribute("userCars", userCars);

        request.getRequestDispatcher("/viewGarage.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
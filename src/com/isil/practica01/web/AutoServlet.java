package com.isil.practica01.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isil.practica01.model.Auto;
import com.isil.practica01.service.AutoService;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the auto.
 * @color Bruno Varillas
 */

@WebServlet("/")
public class AutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AutoService autoService;
	
	public void init() {
		autoService = new AutoService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertAuto(request, response);
				break;
			case "/delete":
				deleteAuto(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateAuto(request, response);
				break;
			default:
				listAuto(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listAuto(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Auto> listAuto = autoService.selectAllAutos();
		request.setAttribute("listAuto", listAuto);
		RequestDispatcher dispatcher = request.getRequestDispatcher("auto-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("auto-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Auto existingAuto = autoService.selectAuto(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("auto-form.jsp");
		request.setAttribute("auto", existingAuto);
		dispatcher.forward(request, response);

	}

	private void insertAuto(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String modelo = request.getParameter("modelo");
		String color = request.getParameter("color");
		String marca = request.getParameter("marca");
		Auto newAuto = new Auto(modelo, color, marca);
		autoService.insertAuto(newAuto);
		response.sendRedirect("list");
	}

	private void updateAuto(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String modelo = request.getParameter("modelo");
		String color = request.getParameter("color");
		String marca = request.getParameter("marca");

		Auto book = new Auto(id, modelo, color, marca);
		autoService.updateAuto(book);
		response.sendRedirect("list");
	}

	private void deleteAuto(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		autoService.deleteAuto(id);
		response.sendRedirect("list");

	}

}

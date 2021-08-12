package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;

import model.User;
import service.UserService;
import service.UserServiceInterface;

public class UserController {

	/*
	 * This method allows a user to login to an existing account
	 */
	public static void login(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, JsonProcessingException, IOException {

		String myPath = null;

		
		if (!req.getMethod().equals("POST")) {
			myPath = "/index.html";
			req.getRequestDispatcher(myPath).forward(req, res);
			return;
		}

		// extracting the form data
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		UserServiceInterface user = new UserService();
		if (user.login(new User(username, password)) == true) {
			System.out.println(username);
			System.out.println(password);
			System.out.println("It worked");
				req.getSession().setAttribute("loggedInUsername", username);

			System.out.println("Getting session name " + req.getSession().getAttribute(username));

			int role = user.employeeType(username);
			System.out.println(role);

			if (role == 2) {
				myPath = "/app/all";
				req.getRequestDispatcher(myPath).forward(req, res);
				return;
			}

			myPath = "/app/userReim";
			req.getRequestDispatcher(myPath).forward(req, res);
			return;
		} else {

			myPath = "/forwarding/incorrectcredentials";
			req.getRequestDispatcher(myPath).forward(req, res);
			return;
		}

	}


	/*
	 * This method views logouts a user from an account
	 */
	public static void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HELPERSESSION SERVLET: In the doPost method!!!");

		HttpSession session = req.getSession();

		String name = (String) (session.getAttribute("loggedInUsername"));
		
		session.removeAttribute(name);
		session.invalidate();
		String myPath = "/index.html";
		req.getRequestDispatcher(myPath).forward(req, resp);
	}

}

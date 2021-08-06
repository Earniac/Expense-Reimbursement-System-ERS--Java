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

	public static void login(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, JsonProcessingException, IOException {

		String myPath = null;

		/*
		 * rout guarding:
		 * 
		 * you may do stuff like:
		 * "check if the user has an admin token in their session" OR
		 * "check if they are using the correct http method" OR something to that
		 * effect.
		 */
		if (!req.getMethod().equals("POST")) {
			myPath = "/index.html";
			req.getRequestDispatcher(myPath).forward(req, res);
			return;
		}

		// extracting the form data
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		UserServiceInterface user = new UserService();

		// boolean login = user.login(new User(username,password));

		// check to see if the user has the correct username & password
		// you'll actually go to th database to get the user's username and password
//		if ((username.equals("mac") & password.equals("cheese"))) {
		if (user.login(new User(username, password)) == true) {
			System.out.println(username);
			System.out.println(password);
			System.out.println("It worked");
				req.getSession().setAttribute("loggedInUsername", username);
//				req.getSession().setAttribute("loggedInPassword", password);

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

			/*
			 * you probably will have a user object that you put into the session that
			 * contains ther username & password and some other information....THIS is just
			 * an example
			 */
//				System.out.println(username);
//				System.out.println(password);

			myPath = "/forwarding/incorrectcredentials";
			req.getRequestDispatcher(myPath).forward(req, res);
			return;
		}

	}

//	public static void createAccount(HttpServletRequest req, HttpServletResponse res)
//			throws ServletException, JsonProcessingException, IOException {
//		
//		
//	}

	public static void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HELPERSESSION SERVLET: In the doPost method!!!");

		// SESSION CODE
		HttpSession session = req.getSession();

		String name = (String) (session.getAttribute("loggedInUsername"));
		// THIS METHOD WILL DESTROY THE SESSION FOR THIS USER
		// you'll more than likely use this for yoru logout button
		session.removeAttribute(name);
		session.invalidate();
		String myPath = "/index.html";
		req.getRequestDispatcher(myPath).forward(req, resp);
	}

}

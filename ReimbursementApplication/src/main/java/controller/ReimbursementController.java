package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Reimbursement;
import service.ReimbursementService;
import service.ReimbursementServiceInterface;

public class ReimbursementController {

//	public static void userhome(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//
//		String myPath = "/resources/html/employee.html";
//		req.getRequestDispatcher(myPath).forward(req, res);
//	}
//
//	public static void financehome(HttpServletRequest req, HttpServletResponse res)
//			throws ServletException, IOException {
//
//		String myPath = "/resources/html/financemanager.html";
//		req.getRequestDispatcher(myPath).forward(req, res);
//	}

	public static void addReimbursement(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, JsonProcessingException, IOException {

		String myPath = null;

		HttpSession session = req.getSession();

		ReimbursementServiceInterface reim = new ReimbursementService();
		/*
		 * rout guarding:
		 * 
		 * you may do stuff like:
		 * "check if the user has an admin token in their session" OR
		 * "check if they are using the correct http method" OR something to that
		 * effect.
		 */
		if (!req.getMethod().equals("POST")) {
			myPath = "/resources/html/add.html";
			req.getRequestDispatcher(myPath).forward(req, res);
			return;
		}

		String name = (String) (session.getAttribute("loggedInUsername"));

		System.out.println(name);

		// extracting the form data
		int amount = Integer.parseInt(req.getParameter("amount"));
		String description = req.getParameter("description");
		int option = Integer.parseInt(req.getParameter("type"));
		System.out.println(amount);
		System.out.println(description);
		System.out.println(option);

		boolean myRequest = reim.createReim(new Reimbursement(amount, description, name, option));

		System.out.println(myRequest);
		
		myPath = "/resources/html/employee.html";
		req.getRequestDispatcher(myPath).forward(req, res);
		return;
	}

	
	
	public static void allReimbursement(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, JsonProcessingException, IOException {

		String myPath = null;

		HttpSession session = req.getSession();

		ReimbursementServiceInterface reim = new ReimbursementService();
		/*
		 * rout guarding:
		 * 
		 * you may do stuff like:
		 * "check if the user has an admin token in their session" OR
		 * "check if they are using the correct http method" OR something to that
		 * effect.
		 */
		if (req.getMethod().equals("POST")) {
			myPath = "/resources/html/financemanager.html";
			req.getRequestDispatcher(myPath).forward(req, res);
			return;
		}

		String name = (String) (session.getAttribute("loggedInUsername"));

		System.out.println(name);

		// extracting the form data
//		int amount = Integer.parseInt(req.getParameter("amount"));
//		String description = req.getParameter("description");
//		int option = Integer.parseInt(req.getParameter("type"));
//		System.out.println(amount);
//		System.out.println(description);
//		System.out.println(option);

		List<Reimbursement> list = reim.allReimbursement();

		System.out.println(list);

		PrintWriter printer = res.getWriter();
		printer.write(new ObjectMapper().writeValueAsString(list));
	}

	
	
	public static void userReimbursement(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, JsonProcessingException, IOException {

		String myPath = null;

		HttpSession session = req.getSession();

		ReimbursementServiceInterface reim = new ReimbursementService();
		/*
		 * rout guarding:
		 * 
		 * you may do stuff like:
		 * "check if the user has an admin token in their session" OR
		 * "check if they are using the correct http method" OR something to that
		 * effect.
		 */
		if (req.getMethod().equals("POST")) {
			myPath = "/resources/html/employee.html";
			req.getRequestDispatcher(myPath).forward(req, res);
			return;
		}

		String name = (String) (session.getAttribute("loggedInUsername"));

		System.out.println(name);

		// extracting the form data
//		int amount = Integer.parseInt(req.getParameter("amount"));
//		String description = req.getParameter("description");
//		int option = Integer.parseInt(req.getParameter("type"));
//		System.out.println(amount);
//		System.out.println(description);
//		System.out.println(option);

		List<Reimbursement> list = reim.userReimbursement(name);

		System.out.println(list);

		PrintWriter printer = res.getWriter();
		printer.write(new ObjectMapper().writeValueAsString(list));
	}

	
	
	public static void pendingReimbursement(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, JsonProcessingException, IOException {

		String myPath = null;

		HttpSession session = req.getSession();

		ReimbursementServiceInterface reim = new ReimbursementService();
		/*
		 * rout guarding:
		 * 
		 * you may do stuff like:
		 * "check if the user has an admin token in their session" OR
		 * "check if they are using the correct http method" OR something to that
		 * effect.
		 */
		if (req.getMethod().equals("POST")) {
			myPath = "/resources/html/financemanagerpending.html";
			req.getRequestDispatcher(myPath).forward(req, res);
			return;
		}

		String name = (String) (session.getAttribute("loggedInUsername"));

		System.out.println(name);

		// extracting the form data
//		int amount = Integer.parseInt(req.getParameter("amount"));
//		String description = req.getParameter("description");
//		int option = Integer.parseInt(req.getParameter("type"));
//		System.out.println(amount);
//		System.out.println(description);
//		System.out.println(option);

		List<Reimbursement> list = reim.allPending();

		System.out.println(list);

		PrintWriter printer = res.getWriter();
		printer.write(new ObjectMapper().writeValueAsString(list));
	}
	
	

	public static void acceptedReimbursement(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, JsonProcessingException, IOException {

		String myPath = null;

		HttpSession session = req.getSession();

		ReimbursementServiceInterface reim = new ReimbursementService();
		/*
		 * rout guarding:
		 * 
		 * you may do stuff like:
		 * "check if the user has an admin token in their session" OR
		 * "check if they are using the correct http method" OR something to that
		 * effect.
		 */
		if (req.getMethod().equals("POST")) {
			myPath = "/resources/html/financemanageraccepted.html";
			req.getRequestDispatcher(myPath).forward(req, res);
			return;
		}

		String name = (String) (session.getAttribute("loggedInUsername"));

		System.out.println(name);

		// extracting the form data
//		int amount = Integer.parseInt(req.getParameter("amount"));
//		String description = req.getParameter("description");
//		int option = Integer.parseInt(req.getParameter("type"));
//		System.out.println(amount);
//		System.out.println(description);
//		System.out.println(option);

		List<Reimbursement> list = reim.allAccepted();

		System.out.println(list);

		PrintWriter printer = res.getWriter();
		printer.write(new ObjectMapper().writeValueAsString(list));
	}

	
	
	public static void declinedReimbursement(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, JsonProcessingException, IOException {

		String myPath = null;

		HttpSession session = req.getSession();

		ReimbursementServiceInterface reim = new ReimbursementService();
		/*
		 * rout guarding:
		 * 
		 * you may do stuff like:
		 * "check if the user has an admin token in their session" OR
		 * "check if they are using the correct http method" OR something to that
		 * effect.
		 */
		if (req.getMethod().equals("POST")) {
			myPath = "/resources/html/financemanagerdeclined.html";
			req.getRequestDispatcher(myPath).forward(req, res);
			return;
		}

		String name = (String) (session.getAttribute("loggedInUsername"));

		System.out.println(name);

		// extracting the form data
//		int amount = Integer.parseInt(req.getParameter("amount"));
//		String description = req.getParameter("description");
//		int option = Integer.parseInt(req.getParameter("type"));
//		System.out.println(amount);
//		System.out.println(description);
//		System.out.println(option);

		List<Reimbursement> list = reim.allDeclined();

		System.out.println(list);

		PrintWriter printer = res.getWriter();
		printer.write(new ObjectMapper().writeValueAsString(list));
	}

	
	public static void updateReimbursement(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, JsonProcessingException, IOException {

		String myPath = null;

		HttpSession session = req.getSession();

		ReimbursementServiceInterface reim = new ReimbursementService();
		/*
		 * rout guarding:
		 * 
		 * you may do stuff like:
		 * "check if the user has an admin token in their session" OR
		 * "check if they are using the correct http method" OR something to that
		 * effect.
		 */
		if (!req.getMethod().equals("POST")) {
			myPath = "/resources/html/updated.html";
			req.getRequestDispatcher(myPath).forward(req, res);
			return;
		}

		String name = (String) (session.getAttribute("loggedInUsername"));

		System.out.println(name);

		// extracting the form data
		int id = Integer.parseInt(req.getParameter("id"));
//		String description = req.getParameter("description");
		int status = Integer.parseInt(req.getParameter("status"));
		System.out.println(id);
//		System.out.println(description);
		System.out.println(status);

		boolean update = reim.updateReim(new Reimbursement(name, status, id));

		System.out.println(update);
		
		myPath = "/resources/html/updated.html";
		req.getRequestDispatcher(myPath).forward(req, res);
		return;

	}

	public static void userDeclinedReimbursement(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, JsonProcessingException, IOException {

		String myPath = null;

		HttpSession session = req.getSession();

		ReimbursementServiceInterface reim = new ReimbursementService();
		/*
		 * rout guarding:
		 * 
		 * you may do stuff like:
		 * "check if the user has an admin token in their session" OR
		 * "check if they are using the correct http method" OR something to that
		 * effect.
		 */
		if (req.getMethod().equals("POST")) {
			myPath = "/resources/html/userdeclined.html";
			req.getRequestDispatcher(myPath).forward(req, res);
			return;
		}

		String name = (String) (session.getAttribute("loggedInUsername"));

		System.out.println(name);

		// extracting the form data
//		int amount = Integer.parseInt(req.getParameter("amount"));
//		String description = req.getParameter("description");
//		int option = Integer.parseInt(req.getParameter("type"));
//		System.out.println(amount);
//		System.out.println(description);
//		System.out.println(option);

		List<Reimbursement> list = reim.userDeclined(name);

		System.out.println(list);

		PrintWriter printer = res.getWriter();
		printer.write(new ObjectMapper().writeValueAsString(list));
	}

	
	
	public static void userPendingReimbursement(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, JsonProcessingException, IOException {

		String myPath = null;

		HttpSession session = req.getSession();

		ReimbursementServiceInterface reim = new ReimbursementService();
		/*
		 * rout guarding:
		 * 
		 * you may do stuff like:
		 * "check if the user has an admin token in their session" OR
		 * "check if they are using the correct http method" OR something to that
		 * effect.
		 */
		if (req.getMethod().equals("POST")) {
			myPath = "/resources/html/userpending.html";
			req.getRequestDispatcher(myPath).forward(req, res);
			return;
		}

		String name = (String) (session.getAttribute("loggedInUsername"));

		System.out.println(name);

		// extracting the form data
//		int amount = Integer.parseInt(req.getParameter("amount"));
//		String description = req.getParameter("description");
//		int option = Integer.parseInt(req.getParameter("type"));
//		System.out.println(amount);
//		System.out.println(description);
//		System.out.println(option);

		List<Reimbursement> list = reim.userPending(name);

		System.out.println(list);

		PrintWriter printer = res.getWriter();
		printer.write(new ObjectMapper().writeValueAsString(list));
	}

	
	
	public static void userAcceptedReimbursement(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, JsonProcessingException, IOException {

		String myPath = null;

		HttpSession session = req.getSession();

		ReimbursementServiceInterface reim = new ReimbursementService();
		/*
		 * rout guarding:
		 * 
		 * you may do stuff like:
		 * "check if the user has an admin token in their session" OR
		 * "check if they are using the correct http method" OR something to that
		 * effect.
		 */
		if (req.getMethod().equals("POST")) {
			myPath = "/resources/html/useraccepted.html";
			req.getRequestDispatcher(myPath).forward(req, res);
			return;
		}

		String name = (String) (session.getAttribute("loggedInUsername"));

		System.out.println(name);

		// extracting the form data
//		int amount = Integer.parseInt(req.getParameter("amount"));
//		String description = req.getParameter("description");
//		int option = Integer.parseInt(req.getParameter("type"));
//		System.out.println(amount);
//		System.out.println(description);
//		System.out.println(option);

		List<Reimbursement> list = reim.userAccepted(name);

		System.out.println(list);

		PrintWriter printer = res.getWriter();
		printer.write(new ObjectMapper().writeValueAsString(list));
	}
}

package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;

import controller.ReimbursementController;
import controller.UserController;

public class Dispatcher {

	public static void myVirtualRouter(HttpServletRequest req, HttpServletResponse res)
			throws JsonProcessingException, IOException, ServletException {

		System.out.println("\n\n\t\tIn MyDispatcher (myVirtualRouter())");
		System.out.println("Current URL: " + req.getRequestURL());
		System.out.println("Current URI: " + req.getRequestURI());

		switch (req.getRequestURI()) {
		case "/ReimbursementApplication/app/all":
			System.out.println("case 1");
			ReimbursementController.allReimbursement(req, res);
			break;
		case "/ReimbursementApplication/app/pending":
			System.out.println("case 2");
			ReimbursementController.pendingReimbursement(req, res);
			;
			break;
		case "/ReimbursementApplication/app/accepted":
			System.out.println("case 3");
			ReimbursementController.acceptedReimbursement(req, res);
			break;
		case "/ReimbursementApplication/app/declined":
			System.out.println("case 4");
			ReimbursementController.declinedReimbursement(req, res);
			break;
		case "/ReimbursementApplication/app/add":
			System.out.println("case 5");
			ReimbursementController.addReimbursement(req, res);
			;
			break;
		case "/ReimbursementApplication/app/update":
			System.out.println("case 6");
			ReimbursementController.updateReimbursement(req, res);
			break;
		case "/ReimbursementApplication/app/userReim":
			System.out.println("case 7");
			ReimbursementController.userReimbursement(req, res);
			break;
		case "/ReimbursementApplication/app/userpending":
			System.out.println("case 8");
			ReimbursementController.userPendingReimbursement(req, res);
			break;
		case "/ReimbursementApplication/app/useraccepted":
			System.out.println("case 9");
			ReimbursementController.userAcceptedReimbursement(req, res);
			break;
		case "/ReimbursementApplication/app/userdeclined":
			System.out.println("case 10");
			ReimbursementController.userDeclinedReimbursement(req, res);
			break;
//		case "/ReimbursementApplication/app/userhome":
//			System.out.println("case 10");
//			ReimbursementController.userhome(req, res);
//			break;
//		case "/ReimbursementApplication/app/financehome":
//			System.out.println("case 10");
//			ReimbursementController.financehome(req, res);
//			break;
		case "/ReimbursementApplication/app/login":
			System.out.println("case 11");
			UserController.login(req, res);
			break;
		case "/ReimbursementApplication/app/logout":
			System.out.println("case 12");
			UserController.logout(req, res);
			break;
//		case "/GroceryProject/forwarding/filter":
//			System.out.println("case 2");
//			FilterListController.request(req, res);
//			break;
//		case "/GroceryProject/forwarding/sortdesc":
//			System.out.println("case 2");
//			SortListDescController.home(req, res);
//			break;
//		case "/GroceryProject/forwarding/logout":
//			System.out.println("case 2.5");
//			LogoutController.logout(req,res);
//			break;
//		case "/GroceryProject/json/Reimburse":
//			System.out.println("case 3");
////			DirectServlet.doTest(req, res);
//			break;
//		case "/GroceryProject/forwarding/addlist":
//			System.out.println("case 4");
//			AddListController.request(req, res);
//			break;
//		case "/GroceryProject/forwarding/listsession":
//			System.out.println("case 4");
//			ListSessionController.request(req, res);
//			break;
//		case "/GroceryProject/forwarding/updatelist":
//			System.out.println("case 5");
//			UpdateListController.request(req, res);
//			break;
//		case "/GroceryProject/forwarding/deletelist":
//			System.out.println("case 6");
//			DeleteListController.request(req, res);
//			break;
//		case "/GroceryProject/forwarding/additem":
//			System.out.println("case 7");
//			AddListItemController.request(req, res);
//			break;
//		case "/GroceryProject/forwarding/deleteitem":
//			System.out.println("case 7");
//			DeleteItemController.request(req, res);
//			break;
//		case "/GroceryProject/forwarding/updateitemname":
//			System.out.println("case 7");
//			UpdateItemNameController.request(req, res);
//			break;
//		case "/GroceryProject/forwarding/updateitemtype":
//			System.out.println("case 7");
//			UpdateItemTypeController.request(req, res);
//			break;
//		case "/GroceryProject/json/statusPending":
//			System.out.println("case 8");
//			JSonByPendingController.doTest(req, res);
//			break;
		case "/GroceryProject/forwarding/Pending":
			System.out.println("case 9");
//			PendingHomeController.home(req, res);
			break;
		case "/GroceryProject/forwarding/Accepted":
			System.out.println("case 10");
//			AcceptedHomeController.home(req, res);
			break;
		case "/GroceryProject/forwarding/Declined":
			System.out.println("case 11");
//			DeclinedHomeController.home(req, res);
			break;
		case "/GroceryProject/json/statusAccepted":
			System.out.println("case 12");
//			JSonByAcceptedController.doTest(req, res);
			break;
		case "/GroceryProject/json/statusDeclined":
			System.out.println("case 13");
//			JSonByDeclinedController.doTest(req, res);
			break;
		case "/GroceryProject/json/getCurrentUserObject":
			// for project 1 you'll need an endpoint that will simply fetch the user's
			// information from their session
			/*
			 * NOW....after you login the servlet will respond with the html page that you
			 * need.... THEN....that html page will IMMEDIATELY FIRE ANOTHER AJAX REQUEST to
			 * retrieve that user's session data so that you can dom manipulation it into
			 * the html home page so you can say "hello [username]". The page is now
			 * modularized.
			 */
			break;
		default:
			System.out.println("Dude, you gave me a bad URI.");
			req.getRequestDispatcher("/resources/html/incorrectlogin.html").forward(req, res);
			return;

		}
	}
}

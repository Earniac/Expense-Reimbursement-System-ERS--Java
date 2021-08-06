package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DirectServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("In the doGet method!!!!");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("In the doPost method!!!!");
//		ReimbursementDaoServiceInterface acc = new ReimbursementDaoService();
//		List<Reimbursement> myReim = acc.selectReimbursement("earniac");
//		
//		AccountDaoServiceInterface acc = new AccountDaoService();
//		Account myAcc = acc.selectAccount(new Account("Earniac","Passme"));
		
//		ListServiceInterface list = new ListService();
//		List<GroceryList> myList = list.findList();
//		
		PrintWriter printer = resp.getWriter();
//		printer.write(new ObjectMapper().writeValueAsString(myList));
	}
	
	public static void doTest(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException, JsonProcessingException {
		
//		HttpSession session = req.getSession();
		
//		String name = (String)(session.getAttribute("loggedInUsername"));
		
//		System.out.println(name);
		
//		ReimbursementDaoServiceInterface acc = new ReimbursementDaoService();
//		List<Reimbursement> myReim = acc.selectAllReimbursement();
//		List<Reimbursement> myReim = acc.selectReimbursement(name);

//		SuperVillainService myServ = new SuperVillainServiceImpl();
//		List<SuperVillain> myVillList = myServ.getAllVillains();
		
//		SuperVillainService myServ = new SuperVillainServiceImpl();
//		SuperVillain myVill = myServ.getVillainByName(new SuperVillain("Danny Boy"));
		
//		AccountDaoServiceInterface acc = new AccountDaoService();
//		Account myAcc = acc.selectAccount(new Account("Earniac","Passme"));
		
//		
//		ListServiceInterface list = new ListService();
//		List<GroceryList> myList = list.findList();
//		
		
		PrintWriter printer = resp.getWriter();
//		printer.write(new ObjectMapper().writeValueAsString(myList));
		
	}
}
 
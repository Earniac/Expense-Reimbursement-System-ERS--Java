package dao;


import java.util.List;

import model.Reimbursement;

public interface ReimbursementDaoInterface {

	//create a reimbursement request
	public boolean createReim(Reimbursement reim);

	//updates a reimbursement request
	public boolean updateReim(Reimbursement reim);

	//shows all pending reimbursement request
	public List<Reimbursement> allPending();

	//shows all accepted reimbursement request
	public List<Reimbursement> allAccepted();

	//shows all declined reimbursement request
	public List<Reimbursement> allDeclined();

	//shows all reimbursement request
	public List<Reimbursement> allReimbursement();

	//shows a user's reimbursement requests
	public List<Reimbursement> userReimbursement(String name);
	
	//shows a user's declined reimbursement requests
	public List<Reimbursement> userDeclined(String name);
	
	//shows a user's accepted reimbursement requests
	public List<Reimbursement> userAccepted(String name);
	
	//shows a user's pending reimbursement requests
	public List<Reimbursement> userPending(String name);
}

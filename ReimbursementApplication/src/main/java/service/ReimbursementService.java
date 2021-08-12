package service;

import java.util.List;

import dao.ReimbursementDao;
import dao.ReimbursementDaoInterface;
import model.Reimbursement;

public class ReimbursementService implements ReimbursementServiceInterface{

	ReimbursementDaoInterface dao = new ReimbursementDao();

	//creates an reimbursement request
	@Override
	public boolean createReim(Reimbursement reim) {
		return dao.createReim(reim);
	}

	//updates a reimbursement request
	@Override
	public boolean updateReim(Reimbursement reim) {
		return dao.updateReim(reim);
	}

	//lists all pending reimbursement requests
	@Override
	public List<Reimbursement> allPending() {
		return dao.allPending();
	}

	//lists all accepted reimbursement requests
	@Override
	public List<Reimbursement> allAccepted() {
		return dao.allAccepted();
	}

	//lists all declined reimbursement requests
	@Override
	public List<Reimbursement> allDeclined() {
		return dao.allDeclined();
	}

	//lists all reimbursement requests
	@Override
	public List<Reimbursement> allReimbursement() {
		return dao.allReimbursement();
	}

	//lists a user's reimbursement requests
	@Override
	public List<Reimbursement> userReimbursement(String name) {
		return dao.userReimbursement(name);
	}

	//lists a user's declined reimbursement requests
	@Override
	public List<Reimbursement> userDeclined(String name) {
		return dao.userDeclined(name);
	}

	//lists a user's pending reimbursement requests
	@Override
	public List<Reimbursement> userPending(String name) {
		return dao.userPending(name);
	}

	//lists a user's accepted reimbursement requests
	@Override
	public List<Reimbursement> userAccepted(String name) {
		return dao.userAccepted(name);
	}

}

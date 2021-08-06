package service;

import java.util.List;

import dao.ReimbursementDao;
import dao.ReimbursementDaoInterface;
import model.Reimbursement;

public class ReimbursementService implements ReimbursementServiceInterface{

	ReimbursementDaoInterface dao = new ReimbursementDao();

	@Override
	public boolean createReim(Reimbursement reim) {
		return dao.createReim(reim);
	}

	@Override
	public boolean updateReim(Reimbursement reim) {
		return dao.updateReim(reim);
	}

	@Override
	public List<Reimbursement> allPending() {
		return dao.allPending();
	}

	@Override
	public List<Reimbursement> allAccepted() {
		return dao.allAccepted();
	}

	@Override
	public List<Reimbursement> allDeclined() {
		return dao.allDeclined();
	}

	@Override
	public List<Reimbursement> allReimbursement() {
		return dao.allReimbursement();
	}

	@Override
	public List<Reimbursement> userReimbursement(String name) {
		return dao.userReimbursement(name);
	}

}

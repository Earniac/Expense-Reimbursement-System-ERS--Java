package dao;


import java.util.List;

import model.Reimbursement;

public interface ReimbursementDaoInterface {

	public boolean createReim(Reimbursement reim);

	public boolean updateReim(Reimbursement reim);

	public List<Reimbursement> allPending();

	public List<Reimbursement> allAccepted();

	public List<Reimbursement> allDeclined();

	public List<Reimbursement> allReimbursement();

	public List<Reimbursement> userReimbursement(String name);
}

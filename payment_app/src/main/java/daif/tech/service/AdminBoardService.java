package daif.tech.service;

import daif.tech.repo.TransactionDB;
import daif.tech.repo.UserDB;

public class AdminBoardService {

    TransactionDB transactionDB = new TransactionDB();

    public void showAllAccounts() {
        UserDB.getInstance().showAllUsers();
    }

    public void removeAnAccount(String username) {
        UserDB.getInstance().removeAccount(username);
    }

    public void showAllTransactions() {
        transactionDB.showAllTransaction();
    }

}

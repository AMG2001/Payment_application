package daif.tech.service;

import daif.tech.repo.TransactionDB;

public class MainBoardService {

    private TransactionDB transactionDB = new TransactionDB();

    public void logAllTransactions() {
        transactionDB.showAllTransaction();
    }
}

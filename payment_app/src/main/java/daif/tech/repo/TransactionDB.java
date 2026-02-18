package daif.tech.repo;

import daif.tech.model.Transaction;

import java.util.ArrayList;

public class TransactionDB {

    ArrayList<Transaction> transactionsDB = new ArrayList<>();

    public void logNewTransaction(Transaction transaction){
        transactionsDB.add(transaction);
    }

    public void showAllTransaction(){
        transactionsDB.forEach(System.out::println);
    }
}

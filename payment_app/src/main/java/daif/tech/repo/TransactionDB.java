package daif.tech.repo;

import daif.tech.model.Transaction;

import java.util.ArrayList;

public class TransactionDB {

    private static volatile ArrayList<Transaction> transactionsDB = new ArrayList<>();

    public synchronized void logNewTransaction(Transaction transaction){
        transactionsDB.add(transaction);
    }

    public synchronized void showAllTransaction(){
        transactionsDB.forEach(System.out::println);
    }
}

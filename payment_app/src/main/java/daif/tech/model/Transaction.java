package daif.tech.model;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class Transaction {

    private static BigInteger index = BigInteger.ZERO;

    private String transactionId;
    private String transactionDescription;
    private LocalDateTime dateAndTime;

    public Transaction(String transactionDescription){

        this.transactionDescription = transactionDescription;
        dateAndTime = LocalDateTime.now();

        // Act as auto-increment in MySql DB.
        index = index.add(BigInteger.ONE);
        transactionId = index.toString();
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public String getTransactionId() {
        return transactionId;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", transactionDescription='" + transactionDescription + '\'' +
                ", dateAndTime=" + dateAndTime +
                '}';
    }
}

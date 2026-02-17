package daif.tech.ui;

import java.util.Scanner;

public class HomeBoard {

    public int showHomeBoard(){
        System.out.println("""
                Enter the number of the action that you want to perform : 
                1. Deposit.
                2. Withdraw.
                3. Transfer.
                4. logout.
                """);
        return new Scanner(System.in).nextInt();
    }
}

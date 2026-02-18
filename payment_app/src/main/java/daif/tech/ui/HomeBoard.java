package daif.tech.ui;

import daif.tech.model.User;
import daif.tech.service.HomeBoardService;

import java.math.BigDecimal;
import java.util.Scanner;

public class HomeBoard {

    private static HomeBoard homeBoard;

    private HomeBoard(){

    }

    public static HomeBoard getInstance(){
        if(homeBoard == null){
            homeBoard = new HomeBoard();
        }
        return homeBoard;
    }

    HomeBoardService homeBoardService = new HomeBoardService();

    public void showHomeBoard(User user){

        // the all operations which are listed within home page are related to this passed user.
        homeBoardService.setUser(user);

        System.out.println("""
                Enter the number of the action that you want to perform : 
                1. Deposit.
                2. Withdraw.
                3. Transfer.
                4. logout.
                """);
        int choice = new Scanner(System.in).nextInt();
        switch (choice){
            case 1 -> showDepositBoard();
            case 2 -> showWithdrawBoard();
            case 3 -> showTransferBoard();
            case 4 -> logoutAndBackToMainBoard();
        }
    }

    private void logoutAndBackToMainBoard() {
        homeBoardService.logout();
        PagesContext.MAIN_BOARD.showMainBoard();
    }

    private void showTransferBoard() {
        System.out.println("Enter the phone number that you want to transfer to : ");
        String phoneNumber = new Scanner(System.in).nextLine();
        // TODO continue the implementation of this method.
    }

    private void showWithdrawBoard() {
        System.out.println("Enter the amount that you want to withdraw : ");
        BigDecimal amount = new Scanner(System.in).nextBigDecimal();
        homeBoardService.withdraw(amount);
    }

    private void showDepositBoard() {
        System.out.println("Enter the amount that you want to deposit : ");
        BigDecimal amount = new Scanner(System.in).nextBigDecimal();
        homeBoardService.deposit(amount);
    }


}

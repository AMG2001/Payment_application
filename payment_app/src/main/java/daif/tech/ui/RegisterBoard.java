package daif.tech.ui;

import daif.tech.service.RegisterBoardService;

import java.math.BigDecimal;
import java.util.Scanner;

public class RegisterBoard {

    private static RegisterBoard registerBoard;

    private RegisterBoard(){

    }

    public static RegisterBoard getInstance(){
        if(registerBoard == null){
            registerBoard = new RegisterBoard();
        }
        return registerBoard;
    }

    RegisterBoardService registerBoardService = new RegisterBoardService();

    public void showRegisterBoard() throws InterruptedException {

        Scanner get = new Scanner(System.in);

        boolean isNotValidUserName = true,
                isNotValidPhoneNumber = true,
                isNotValidBalanceOptionChoice = true;

        String username = "";
        while (isNotValidUserName) {
            System.out.println("Enter your preferred username : ");
            username = get.nextLine();
            isNotValidUserName = registerBoardService.validateEnteredUserName(username);
            if (isNotValidUserName) System.out.println("Username can't contain spaces");
        }

        String phoneNumber = "";
        while (isNotValidPhoneNumber) {
            System.out.println("Enter your phone number : ");
            phoneNumber = get.nextLine();
            isNotValidPhoneNumber = registerBoardService.validatePhoneNumber(phoneNumber);
            if (isNotValidPhoneNumber)
                System.out.println("phone number can't contain spaces and the length must be 11");
        }


        System.out.println("Enter your password : ");
        String password = get.nextLine();

        BigDecimal initialBalance = new BigDecimal(0);
        while (isNotValidBalanceOptionChoice) {
            System.out.println("Do you want to initialize your account with balance ? Y/N");
            String choice = get.nextLine();
            choice = choice.trim();
            if (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n"))
                System.out.println("Kindly enter either Y or N");
            else if (choice.equalsIgnoreCase("y")) {
                System.out.println("Enter amount : ");
                initialBalance = get.nextBigDecimal();
                isNotValidBalanceOptionChoice = false;
            } else if (choice.equalsIgnoreCase("n")) {
                initialBalance = new BigDecimal(0);
                isNotValidBalanceOptionChoice = false;
            }
        }

        registerBoardService.registerUser(username,password,phoneNumber,initialBalance);

    }


}

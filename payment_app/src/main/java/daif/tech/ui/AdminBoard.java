package daif.tech.ui;

import daif.tech.repo.UserDB;
import daif.tech.service.AdminBoardService;
import daif.tech.util.Validator;

import java.util.List;
import java.util.Scanner;

public class AdminBoard {

    private static AdminBoard adminBoard;
    private AdminBoardService adminBoardService = new AdminBoardService();

    public static AdminBoard getInstance() {
        if (adminBoard == null) {
            adminBoard = new AdminBoard();
        }
        return adminBoard;
    }

    private AdminBoard() {

    }

    public void showAdminBoard() {
        boolean isValidOption = false, isDone = false;
        int option = 0;
        List<Integer> availableOptions = List.of(1, 2, 3, 4);

        while (!isDone) {
            System.out.println("""
                    Enter number of option that you want to perform :
                    1. show all accounts.
                    2. remove an account.
                    3. show all transactions which are done on system.
                    4. back to main menu.
                    """);

            String enteredOption = new Scanner(System.in).nextLine();
            if (Validator.isValidNumericOption(enteredOption) && availableOptions.contains(Integer.parseInt(enteredOption))) {
                option = Integer.parseInt(enteredOption);
                switch (option) {
                    case 1 -> adminBoardService.showAllAccounts();
                    case 2 -> removeAnAccount();
                    case 3 -> adminBoardService.showAllTransactions();
                    case 4 -> isDone = true;

                }
            } else {
                System.out.println("Kindly enter a valid option");
            }

        }
    }

    private void removeAnAccount() {
        System.out.println("Enter the username that you want to remove : ");
        String username = new Scanner(System.in).nextLine();
        UserDB.getInstance().removeAccount(username);
    }

}

package daif.tech.ui;

import java.util.Scanner;

public class MainBoard {

    private static MainBoard mainBoard;

    private MainBoard() {

    }

    public static MainBoard getInstance() {
        if (mainBoard == null) {
            mainBoard = new MainBoard();
        }
        return mainBoard;
    }

    public void showLoginBoard() {
        PagesContext.LOGIN_BOARD.showLoginBoard();
    }

    public void showRegisterPage() {
        PagesContext.REGISTER_BOARD.showRegisterBoard();
    }

    public void showMainBoard() {

        Scanner get = new Scanner(System.in);
        boolean isNotValidInput = true;

        while (isNotValidInput) {
            System.out.println("""
                    Choose what you want to do :
                    1. Login.
                    2. Register.""");
            System.out.print("-> ");
            try {
                int choice = Integer.parseInt(get.nextLine());
                isNotValidInput = false;
                switch (choice) {
                    case 1 -> mainBoard.showLoginBoard();
                    case 2 -> mainBoard.showRegisterPage();
                }
            } catch (NumberFormatException e) {
                System.out.println("Kindly enter valid option number.");
            }
        }


    }
}

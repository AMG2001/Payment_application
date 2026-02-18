package daif.tech;

import daif.tech.ui.MainBoard;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MainBoard mainBoard = MainBoard.getInstance();
        System.out.println("Welcome to E-Wallet application");

        boolean isRunning = true;
        while (isRunning) {
           int choice = mainBoard.showMainBoard();
           switch (choice){
               case 1 -> mainBoard.showLoginBoard();
               case 2 -> mainBoard.showRegisterPage();
           }
        }
    }
}

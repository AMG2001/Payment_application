package daif.tech;

import daif.tech.repo.UserDB;
import daif.tech.ui.MainBoard;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MainBoard mainBoard = MainBoard.getInstance();
        UserDB.getInstance().initialize();
        System.out.println("Welcome to E-Wallet application");

        boolean isRunning = true;
        while (isRunning) {
            mainBoard.showMainBoard();
        }
    }
}

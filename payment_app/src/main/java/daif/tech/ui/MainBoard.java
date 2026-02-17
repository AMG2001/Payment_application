package daif.tech.ui;

import java.util.Scanner;

public class MainBoard {

    private LoginBoard loginBoard = new LoginBoard();
    private RegisterBoard registerBoard = new RegisterBoard();
    private LoggedUserOptionsBoard loggedUserOptionsBoard = new LoggedUserOptionsBoard();

    public void showLoginBoard() {
        loginBoard.showLoginBoard();
    }

    public void showRegisterPage() throws InterruptedException {
        registerBoard.showRegisterBoard();
    }

    public int showMainBoard() {
        Scanner get = new Scanner(System.in);
        System.out.println("""
                Choose what you want to do :
                1. Login.
                2. Register.""");
        System.out.print("-> ");
        return get.nextInt();
    }
}

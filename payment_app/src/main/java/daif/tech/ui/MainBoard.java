package daif.tech.ui;

import java.util.Scanner;

public class MainBoard {

    private static MainBoard mainBoard;

    private MainBoard(){

    }

    public static MainBoard getInstance(){
        if(mainBoard == null){
            mainBoard = new MainBoard();
        }
        return mainBoard;
    }
    public void showLoginBoard() {
        PagesContext.LOGIN_BOARD.showLoginBoard();
    }

    public void showRegisterPage() throws InterruptedException {
        PagesContext.REGISTER_BOARD.showRegisterBoard();
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

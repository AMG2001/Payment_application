package daif.tech.ui;

import daif.tech.model.User;
import daif.tech.service.LoginBoardService;

import java.util.Optional;
import java.util.Scanner;

public class LoginBoard {

    private static LoginBoard loginBoard;

    private LoginBoard(){

    }

    public static LoginBoard getInstance(){
        if (loginBoard == null){
            loginBoard = new LoginBoard();
        }
        return loginBoard;
    }

    LoginBoardService loginBoardService = new LoginBoardService();

    public void showLoginBoard(){
        Scanner get = new Scanner(System.in);

        System.out.print("Enter your phone number : ");
        String phoneNumber = get.nextLine();

        System.out.print("Enter your password : ");
        String password = get.nextLine();

        Optional<User> user = loginBoardService.login(phoneNumber,password);
        user.ifPresent(value -> PagesContext.HOME_BOARD.showHomeBoard(value));
    }
}

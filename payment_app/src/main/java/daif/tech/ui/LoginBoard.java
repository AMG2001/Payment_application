package daif.tech.ui;

import daif.tech.model.User;
import daif.tech.service.LoginBoardService;
import daif.tech.util.UserInfoValidator;

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

        boolean isValidPhoneNumber = false,isValidPassword = false;
        String phoneNumber = "",password = "";

        while(!isValidPhoneNumber){
            System.out.print("Enter your phone number : ");
            phoneNumber = get.nextLine();
            isValidPhoneNumber = UserInfoValidator.validatePhoneNumber(phoneNumber);
        }


        while (!isValidPassword){
            System.out.print("Enter your password : ");
            password = get.nextLine();
            isValidPassword = UserInfoValidator.validatePasswordLength(password);
        }

        Optional<User> user = loginBoardService.login(phoneNumber,password);
        user.ifPresent(value -> PagesContext.HOME_BOARD.showHomeBoard(value));
    }
}

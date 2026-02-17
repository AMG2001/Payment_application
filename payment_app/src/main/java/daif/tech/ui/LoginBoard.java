package daif.tech.ui;

import daif.tech.service.LoginBoardService;

import java.util.Scanner;

public class LoginBoard {

    LoginBoardService loginBoardService = new LoginBoardService();
    HomeBoard homeBoard = new HomeBoard();

    public void showLoginBoard(){
        Scanner get = new Scanner(System.in);

        System.out.print("Enter your phone number : ");
        String phoneNumber = get.nextLine();

        System.out.print("Enter your password : ");
        String password = get.nextLine();

        if(loginBoardService.login(phoneNumber,password).isPresent()){
            homeBoard.showHomeBoard()
        }
    }
}

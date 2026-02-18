package daif.tech.util;

public class UserInfoValidator {

    public static boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber.contains(" ") || phoneNumber.length() != 11) {
            System.out.println("Phone number can't contain spaces and it's length must be 11");
            return false;
        }
        return true;
    }

    public static boolean validateEnteredUserName(String username) {
        if(username.contains(" ")){
            System.out.println("user name can't contain spaces");
            return false;
        }
        return true;
    }

    public static boolean validatePasswordLength(String password) {
        if(password.length() != 8){
            System.out.println("Password length should be 8");
            return false;
        }
        return true;
    }
}

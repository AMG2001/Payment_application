package daif.tech.exception;

public class AvailableBalanceNotEnoughException extends RuntimeException {

    private String message = "The available balance is not enough to proceed";

    @Override
    public String getMessage() {
        return message;
    }
}

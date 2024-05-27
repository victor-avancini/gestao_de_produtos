package exceptions;

public class NotFoundException extends Exception {
    public NotFoundException() {
        super("Not Found");
    }

    public NotFoundException(String msg) {
        super(msg);
    }
}

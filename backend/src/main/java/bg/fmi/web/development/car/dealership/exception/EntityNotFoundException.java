package bg.fmi.web.development.car.dealership.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable e) {
        super(message, e);
    }
}

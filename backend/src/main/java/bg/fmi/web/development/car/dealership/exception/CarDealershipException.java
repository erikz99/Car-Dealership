package bg.fmi.web.development.car.dealership.exception;

public class CarDealershipException extends RuntimeException {

    public CarDealershipException(String message) {
        super(message);
    }

    public CarDealershipException(String message, Throwable e) {
        super(message, e);
    }
}

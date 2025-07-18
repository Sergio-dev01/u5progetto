package sergiomaselli.u5progetto.exceptions;

public class ReservationNotAvailable extends RuntimeException {
    public ReservationNotAvailable(String message) {
        super(message);
    }
}

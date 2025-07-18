package sergiomaselli.u5progetto.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long userId) {
        super("La risorsa con id " + userId + " non è stata trovata");
    }

    public NotFoundException(String id) {
        super("Elemento con ID " + id + " non trovato.");
    }
}

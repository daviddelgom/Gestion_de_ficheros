package exceptions;

public class InvalidEmailException extends Exception {
    public InvalidEmailException() {
        super("El correo electrónico tiene un formato inválido.");
    }
}
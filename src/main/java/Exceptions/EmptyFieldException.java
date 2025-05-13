package exceptions;

public class EmptyFieldException extends Exception {
    public EmptyFieldException(String campo) {
        super("El campo '" + campo + "' no puede estar vacío.");
    }
}
package model;


import exceptions.EmptyFieldException;
import exceptions.InvalidEmailException;

public class UserDataValidations {

    public static void validarNombre(String nombre) throws EmptyFieldException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new EmptyFieldException("Nombre");
        }
    }

    public static void validarEmail(String email) throws EmptyFieldException, InvalidEmailException {
        if (email == null || email.trim().isEmpty()) {
            throw new EmptyFieldException("Email");
        }
        if (!email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new InvalidEmailException();
        }
    }
}
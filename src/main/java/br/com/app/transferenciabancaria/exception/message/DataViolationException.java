package br.com.app.transferenciabancaria.exception.message;

public class DataViolationException extends RuntimeException{
    public DataViolationException(String message) {
        super(message);
    }
}

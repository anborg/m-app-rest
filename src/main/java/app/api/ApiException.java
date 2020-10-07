package app.api;

public class ApiException extends RuntimeException {
    public ApiException(String msg, Throwable e){
        super(msg, e);
    }
}


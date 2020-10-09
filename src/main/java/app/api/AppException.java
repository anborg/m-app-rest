package app.api;

public class AppException extends RuntimeException {
    public AppException(String msg, Throwable e){
        super(msg, e);
    }
}


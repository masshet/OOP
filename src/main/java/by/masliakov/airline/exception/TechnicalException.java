package by.masliakov.airline.exception;

import by.masliakov.airline.message.TypeExceptionMessage;

/**
 * Created by mrstark on 9.6.15.
 */
public class TechnicalException extends Exception {
    private static final long serialVersionUID = 1L;

    public TechnicalException() {
    }

    public TechnicalException(String arg0) {
        super(arg0);
    }

    public TechnicalException(Throwable arg0) {
        super(arg0);
    }

    public TechnicalException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public TechnicalException(String arg0, Throwable arg1, boolean arg2,
                              boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }

    public TechnicalException(TypeExceptionMessage type) {
        super(type.toString());
    }
}

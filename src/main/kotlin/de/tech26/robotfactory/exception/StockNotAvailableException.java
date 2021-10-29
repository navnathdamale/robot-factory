package de.tech26.robotfactory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class StockNotAvailableException extends RobotFactoryException {
    static final long serialVersionUID = 947545993224222948L;

    public StockNotAvailableException(final String message) {
        super(message);
    }
}

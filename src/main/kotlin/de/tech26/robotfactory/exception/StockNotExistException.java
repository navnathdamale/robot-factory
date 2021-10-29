package de.tech26.robotfactory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class StockNotExistException extends RobotFactoryException {
    static final long serialVersionUID = 997545993224222948L;

    public StockNotExistException(final String message) {
        super(message);
    }
}

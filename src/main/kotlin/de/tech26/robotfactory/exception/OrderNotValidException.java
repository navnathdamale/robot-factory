package de.tech26.robotfactory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class OrderNotValidException extends RobotFactoryException {
    static final long serialVersionUID = 997545993224222948L;

    public OrderNotValidException(final String message) {
        super(message);
    }
}

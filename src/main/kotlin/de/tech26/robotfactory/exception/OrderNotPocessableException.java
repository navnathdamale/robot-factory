package de.tech26.robotfactory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class OrderNotPocessableException extends RobotFactoryException {
    static final long serialVersionUID = 997545993224222948L;

    public OrderNotPocessableException(final String message) {
        super(message);
    }
}

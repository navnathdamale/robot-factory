package de.tech26.robotfactory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public abstract class RobotFactoryException extends Exception {
    static final long serialVersionUID = 927545993224222948L;

    public RobotFactoryException(final String message) {
        super(message);
    }
}

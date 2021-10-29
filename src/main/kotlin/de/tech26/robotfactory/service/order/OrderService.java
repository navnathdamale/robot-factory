package de.tech26.robotfactory.service.order;

import de.tech26.robotfactory.dto.OrderRequestDTO;
import de.tech26.robotfactory.dto.OrderResponseDTO;
import de.tech26.robotfactory.exception.RobotFactoryException;

import java.util.UUID;

public interface OrderService {
     OrderResponseDTO handleRobotCreationOrder(final OrderRequestDTO orderRequestDTO) throws RobotFactoryException;
}

package de.tech26.robotfactory.controller;

import de.tech26.robotfactory.dto.OrderRequestDTO;
import de.tech26.robotfactory.dto.OrderResponseDTO;
import de.tech26.robotfactory.exception.RobotFactoryException;
import de.tech26.robotfactory.service.order.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * controller dedicated for handling orders
 */
@RestController
@RequestMapping("/orders")
public class OrderController {
    private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);

    private OrderService orderService;

    public OrderController(@Autowired OrderService orderService) {
        this.orderService = orderService;
    }

    @ResponseBody
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderRequestDTO order) throws RobotFactoryException {
        LOG.info("createOrder {}", order);
        return new ResponseEntity<>(orderService.handleRobotCreationOrder(order), HttpStatus.CREATED);
    }
}

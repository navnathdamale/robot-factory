package de.tech26.robotfactory.service.order;

import de.tech26.robotfactory.dto.OrderRequestDTO;
import de.tech26.robotfactory.dto.OrderResponseDTO;
import de.tech26.robotfactory.entity.Stock;
import de.tech26.robotfactory.exception.*;
import de.tech26.robotfactory.service.stock.StockService;
import de.tech26.robotfactory.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    private StockService stockService;

    public OrderServiceImpl(@Autowired StockService stockService) {
        this.stockService = stockService;
    }

    @Override
    public OrderResponseDTO handleRobotCreationOrder(final OrderRequestDTO orderRequestDTO) throws RobotFactoryException {
        return validateAndBuildOrder(orderRequestDTO);
    }

    private OrderResponseDTO validateAndBuildOrder(final OrderRequestDTO orderRequestDTO) throws RobotFactoryException {
        if (CollectionUtils.isEmpty(orderRequestDTO.getComponents())) {
            throw new OrderNotValidException(Constants.ORDER_NOT_VALID);
        }
        double totalPrice = 0;
        Map<String, Stock> tempStockMap = new HashMap<>();
        Set<String> visitedGroup = new HashSet<>();
        for (String component : orderRequestDTO.getComponents()) {
            final String code = component.toUpperCase(Locale.ROOT);
            final Stock repoStock = stockService.getStockByCode(code);

            //Do pre-validation on order
            validateOrder(repoStock, code, visitedGroup);

            //start calculating totalPrice
            totalPrice += repoStock.getPrice();

            //Add component into visited group
            visitedGroup.add(repoStock.getGroup());

            //temp adjust stock availability
            repoStock.setCount(repoStock.getCount() - 1);
            tempStockMap.put(code, repoStock);
        }

        //final adjust central stock repository
        stockService.updateStock(tempStockMap);
        return new OrderResponseDTO(totalPrice);
    }

    private void validateOrder(final Stock repoStock, final String code, final Set<String> visitedGroup) throws RobotFactoryException {
        //validate if stock is exists for code
        if (repoStock.getGroup() == null) {
            throw new StockNotExistException(String.format(Constants.STOCK_NOT_FOUND, code));
        }

        //validate if robot assembly should contain one, and only one part
        if (visitedGroup.contains(repoStock.getGroup())) {
            throw new OrderNotPocessableException(String.format(Constants.COMPONENT_NOT_VALID, code, repoStock.getGroup()));
        }

        //validate if enough stock available
        if (repoStock.getCount() < 1) {
            throw new StockNotAvailableException(String.format(Constants.STOCK_NOT_AVAILABLE, code));
        }
    }
}

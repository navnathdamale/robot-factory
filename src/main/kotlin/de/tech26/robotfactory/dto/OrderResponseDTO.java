package de.tech26.robotfactory.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class OrderResponseDTO {
    @JsonProperty("order_id")
    private String orderId;
    private double total;

    public OrderResponseDTO() {
    }

    public OrderResponseDTO(double total) {
        this.orderId = UUID.randomUUID().toString();
        this.total = total;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "OrderResponseDTO{" +
                "orderId='" + orderId + '\'' +
                ", total=" + total +
                '}';
    }
}

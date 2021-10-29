package de.tech26.robotfactory.dto;

import java.util.List;

public class OrderRequestDTO {

    private List<String> components;

    public OrderRequestDTO() {
    }

    public OrderRequestDTO(List<String> components) {
        this.components = components;
    }

    public List<String> getComponents() {
        return components;
    }

    public void setComponents(List<String> components) {
        this.components = components;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "components=" + components +
                '}';
    }
}

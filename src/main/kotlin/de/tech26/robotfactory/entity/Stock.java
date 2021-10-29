package de.tech26.robotfactory.entity;

/**
 * Stock entity: Persistable into central repository
 */
public class Stock {
    private int count;
    private String part;
    private double price;
    private String group;

    public Stock() {
    }

    public Stock(double price, int count, String part, String group) {
        this.price = price;
        this.count = count;
        this.part = part;
        this.group = group;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "price=" + price +
                ", count=" + count +
                ", part='" + part + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
package com.coffeeshop.menu.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Product {
    @NotNull(message = "Product ID is required")
    @Min(value=1, message = "Product ID must be greater than 0")
    private int id;

    @NotNull(message = "Product Name is required")
    @Size(min=2, max = 255, message = "Product Name must be between 2 and 255")
    private String name;

    @NotNull(message = "Product Price is required")
    @Min(value = 0, message = "Product Price must be a positive value")
    private double price;

    public Product(int id, String name, double price) {

        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

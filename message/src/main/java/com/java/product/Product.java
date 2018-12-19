package com.java.product;

import com.java.Type.Type;
import com.java.adjustments.Adjustment;
import com.java.sale.Sale;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Product {

    private String name;
    private double price;
    private Type adjustment;

    private Map<Product, List<Adjustment>>  productlistadjmap = new HashMap<>();

    public Product() {

    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;

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

    public Map<Product, List<Adjustment>> getProductlistadjmap() {
        return productlistadjmap;
    }



    public void setProductlistadjmap(Map<Product, List<Adjustment>> productlistadjmap) {
        this.productlistadjmap = productlistadjmap;
    }

    public Type getAdjustment() {
        return adjustment;
    }

    public void setAdjustment(Type adjustment) {
        this.adjustment = adjustment;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }


}
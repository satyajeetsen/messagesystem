package com.java.sale;

import com.java.product.Product;

import java.util.*;

public class Sale {

    private Product product;
    private int total;
    private Map<String, Integer> itemoccurancemap;
    private Map<String, Double> itempricemap;
    private Map<String, Integer> itemnoofsales;

    public Sale() {
        itemoccurancemap = new HashMap<String, Integer>();
        itempricemap = new HashMap<>();
        itemnoofsales = new HashMap<String, Integer>();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    public Map<String, Integer> getItemoccurancemap() {
        return itemoccurancemap;
    }

    public void setItemoccurancemap(Map<String, Integer> itemoccurancemap) {
        this.itemoccurancemap = itemoccurancemap;
    }

    //calculate sales calculation for each product
    public void product_salescalculation(int count) {


        System.out.println("\nReport of total sales per product type at sale count : " + count);
        //
        for (Map.Entry<String, Integer> entry : itemnoofsales.entrySet()) {

            System.out.println("Product " + entry.getKey() + " has a total " + entry.getValue() + " sales ");
            System.out.println("Total value of sale : " + (entry.getValue() * itempricemap.get(entry.getKey()) * itemoccurancemap.get(entry.getKey())));


        }
    }

    public Map<String, Double> getItempricemap() {
        return itempricemap;
    }

    public void setItempricemap(Map<String, Double> itempricemap) {
        this.itempricemap = itempricemap;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Map<String, Integer> getItemnoofsales() {
        return itemnoofsales;
    }

    public void setItemnoofsales(Map<String, Integer> itemnoofsales) {
        this.itemnoofsales = itemnoofsales;
    }


}
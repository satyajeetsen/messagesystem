package com.message.adjustments;

import com.message.Type.Type;
import com.message.message.Message;
import com.message.product.Product;

import java.util.*;


public class Adjustment {
    private String name;
    private Type adjustmentType;
    private Double adjustmentAmount;
    private Product prod;

    private Map<Adjustment, Double> adjustmentAmountMap = new HashMap<Adjustment, Double>();

    private Map<String, Integer> productnoofadj = new HashMap<String, Integer>();
    private Map<String, List<Adjustment>> itemadjmap = new HashMap<>();


    public Adjustment() {

    }

    public Adjustment(Type adjustmentType) {
        this.adjustmentType = adjustmentType;
    }


    public Adjustment(Type adjustmentType, Double adjustmentAmount, String name) {
        this.adjustmentType = adjustmentType;
        this.adjustmentAmount = adjustmentAmount;
        this.name = name;

    }

    public Product getProd() {
        return prod;
    }

    public void setProd(Product prod) {
        this.prod = prod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getProductnoofadj() {
        return productnoofadj;
    }

    public void setProductnoofadj(Map<String, Integer> productnoofadj) {
        this.productnoofadj = productnoofadj;
    }

    public Type getAdjustmentType() {
        return adjustmentType;
    }

    public void setAdjustmentType(Type adjustmentType) {
        this.adjustmentType = adjustmentType;
    }

    public Double getAdjustmentAmount() {
        return adjustmentAmount;
    }

    public void setAdjustmentAmount(Double adjustmentAmount) {
        this.adjustmentAmount = adjustmentAmount;
    }

    public Map<Adjustment, Double> getAdjustmentAmountMap() {
        return adjustmentAmountMap;
    }

    public void setAdjustmentAmountMap(Map<Adjustment, Double> adjustmentAmountMap) {
        this.adjustmentAmountMap = adjustmentAmountMap;
    }

    @Override
    public String toString() {
        return "Adjustment{" +
                "adjustmentType=" + adjustmentType +
                ", productName=" + name + ", Adjustment Amount=" + adjustmentAmount +
                '}';
    }

    public Map<String, List<Adjustment>> getItemadjmap() {
        return itemadjmap;
    }

    public void setItemadjmap(Map<String, List<Adjustment>> itemadjmap) {
        this.itemadjmap = itemadjmap;
    }

    public void product_adjustmentcalculation(Map<String, Integer> mp, int count, Map<Adjustment, Double> map) {
        int i = 0;
        System.out.println("\n*******Application is pausing. A report of adjustments per sale will now be logged");
        Set<String> prod = mp.keySet();

        for (Map.Entry<String, Integer> entry1 : mp.entrySet()) {
            i++;

            System.out.println("\nProduct type " + ": " + entry1.getKey() + " has total " + entry1.getValue()
                    + " adjustments.");

        }


        for (Map.Entry<Adjustment, Double> entry2 : map.entrySet()) {

            //  if(obj.getAdjustment() !="")

            System.out.println(entry2.getKey().toString());


        }


    }


}






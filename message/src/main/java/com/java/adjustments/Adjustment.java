package com.java.adjustments;

import com.java.Type.Type;
import com.java.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Adjustment {
    private String name;
private Type adjustmentType;
private Double adjustmentAmount;
private Map<Type,Double> adjustmentAmountMap=adjustmentAmountMap=new HashMap<Type, Double>();
private Map<String,List<String>> itemadjustmentlistmap=new HashMap<String,List<String>>();
    private Map<String,Integer> productnoofadj=new HashMap<String,Integer>();

    public Adjustment(){

    }

    public Adjustment(Type adjustmentType, Double adjustmentAmount,String name) {
        this.adjustmentType = adjustmentType;
        this.adjustmentAmount = adjustmentAmount;
        this.name=name;

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

    public Map<String, List<String>> getItemadjustmentlistmap() {
        return itemadjustmentlistmap;
    }

    public void setItemadjustmentlistmap(Map<String, List<String>> itemadjustmentlistmap) {
        this.itemadjustmentlistmap = itemadjustmentlistmap;
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

    public Map<Type, Double> getAdjustmentAmountMap() {
        return adjustmentAmountMap;
    }

    public void setAdjustmentAmountMap(Map<Type, Double> adjustmentAmountMap) {
        this.adjustmentAmountMap = adjustmentAmountMap;
    }

    @Override
    public String toString() {
        return "Adjustment{" +
                "adjustmentType=" + adjustmentType +
                ", adjustmentAmount=" + adjustmentAmount +
                '}';
    }

    public void product_adjustmentcalculation(Map<String,Integer> mp, int count, Map<Type,Double> map) {
        int i=0;
        System.out.println("\n*******Application is pausing. A report of adjustments per sale will now be logged");

        for (Map.Entry<String,Integer> entry1 : mp.entrySet()) {

            System.out.println("\nProduct type " + ": " + entry1.getKey() + " has total " + entry1.getValue()
                    + " adjustments\n");
            for (Map.Entry<Type,Double> entry2 : map.entrySet()) {
                System.out.println(entry2.getKey());
                System.out.println("Adjustment{" +
                        "adjustmentType=" + entry2.getKey() +
                        ", adjustmentAmount=" + entry2.getValue() +
                        '}');

            }


            System.out.println();



        }

    }

}


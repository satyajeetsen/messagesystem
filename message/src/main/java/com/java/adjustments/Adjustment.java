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
private Map<String,List<Type>> itemadjustmentlistmap=new HashMap<String,List<Type>>();
List<Type> msglist = new ArrayList<Type>();
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

    public Map<String, List<Type>> getItemadjustmentlistmap() {
        return itemadjustmentlistmap;
    }

    public void setItemadjustmentlistmap(Map<String, List<Type>> itemadjustmentlistmap) {
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

    public void product_adjustmentcalculation(Map<String,List<Type>> mp,int count,Map<Type,Double> map) {
        int i=0;
        System.out.println("\n*******Application is pausing. A report of adjustments per sale will now be logged");

        for (Map.Entry<String,List<Type>> entry1 : mp.entrySet()) {
            i++;
            System.out.println("\nProduct type " + ": " + entry1.getKey() + " has total " + entry1.getValue().size()
                    + " adjustments\n"+entry1.getValue().get(i) );

            System.out.println(toString());

            System.out.println();



        }

    }

    @Override
    public String toString() {
        return "Adjustment{" +
                "name='" + name + '\'' +
                ", adjustmentType=" + adjustmentType +
                ", adjustmentAmount=" + adjustmentAmount +
                '}';
    }
}


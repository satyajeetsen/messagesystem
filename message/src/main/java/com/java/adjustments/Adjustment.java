package com.java.adjustments;

import com.java.Type.Type;
import com.java.product.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Adjustment {
    private String name;
private Type adjustmentType;
private Double adjustmentAmount;

    Map<Type,Double> adjustmentAmountMap=adjustmentAmountMap=new HashMap<Type, Double>();
    Map<String,List<Type>> itemadjustmentlistmap=new HashMap<String,List<Type>>();
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

    public Type getAdjustmentString() {
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
                "name='" + name + '\'' +
                ", adjustmentType=" + adjustmentType +
                ", adjustmentAmount=" + adjustmentAmount +
                '}';
    }
}


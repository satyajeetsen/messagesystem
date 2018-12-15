package com.java.adjustments;

import com.java.Type.Type;
import com.java.product.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Adjustment {
private Type adjustmentType;
private Integer adjustmentAmount;

    Map<Type,Integer> adjustmentAmountMap=new HashMap<Type, Integer>();

    public Type getAdjustmentType() {
        return adjustmentType;
    }

    public void setAdjustmentType(Type adjustmentType) {
        this.adjustmentType = adjustmentType;
    }

    public Integer getAdjustmentAmount() {
        return adjustmentAmount;
    }

    public void setAdjustmentAmount(Integer adjustmentAmount) {
        this.adjustmentAmount = adjustmentAmount;
    }

    public Map<Type, Integer> getAdjustmentAmountMap() {
        return adjustmentAmountMap;
    }

    public void setAdjustmentAmountMap(Map<Type, Integer> adjustmentAmountMap) {
        this.adjustmentAmountMap = adjustmentAmountMap;
    }

    @Override
    public String toString() {
        return "Adjustment{" +
                "adjustmentType=" + adjustmentType +
                ", adjustmentAmount=" + adjustmentAmount +
                '}';
    }
}


package com.java.adjustments;

import com.java.Type.Type;
import com.java.product.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Adjustment {
private Type[]adjustmentType = new Type[3];
private String item;
    Map<String,List<String>> itemAdjustmentMap=new HashMap<String, List<String>>();

    public Type[] getAdjustmentType() {
        return adjustmentType;
    }

    public void setAdjustmentType(Type[] adjustmentType) {
        this.adjustmentType = adjustmentType;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Map<String, List<String>> getItemAdjustmentMap() {
        return itemAdjustmentMap;
    }

    public void setItemAdjustmentMap(Map<String, List<String>> itemAdjustmentMap) {
        this.itemAdjustmentMap = itemAdjustmentMap;
    }
}

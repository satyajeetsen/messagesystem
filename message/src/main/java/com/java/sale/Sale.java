package com.java.sale;

import com.java.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sale {

    public Sale(){

    }
    int total;
    Map<String,Integer> itemoccurancemap=new HashMap<String, Integer>();

    public Map<String, Integer> getItemoccurancemap() {
        return itemoccurancemap;
    }

    public void setItemoccurancemap(Map<String, Integer> itemoccurancemap) {
        this.itemoccurancemap = itemoccurancemap;
    }


            public int countofSales(Map<String,Integer> hsm){

                for (Map.Entry<String, Integer> hsmapitr : hsm.entrySet()) {

                    int salescount=(int)hsmapitr.getValue();
                    total+=salescount;
                }
                return total;
            }
}




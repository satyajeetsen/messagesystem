package com.java.Main;



import com.java.adjustments.Adjustment;
import com.java.data.DataObjects;
import com.java.product.Product;
import com.java.sale.Sale;

import java.util.List;


public class Main {

    public static void main(String[] args) throws Exception {
   DataObjects dr = new DataObjects();
   Message msg = new Message();
   Sale sale= new Sale();
   Adjustment adj=new Adjustment();

   DataObjects data = new DataObjects();
   List<Data> csvobjects =data.ReadingDataObjects();


   Product product = new Product();

   }




  

}


package com.java.data;


import com.java.Type.Type;
import com.java.adjustments.Adjustment;
import com.java.message.Message;
import com.java.product.Product;
import com.java.sale.Sale;


import java.io.File;
import java.util.*;


public class DataObjects {
    Sale s = new Sale();
    Adjustment a = new Adjustment();
    Message m;

    List<Message> messageslist = new ArrayList<Message>();
    Map< String,Integer> hsmap = new HashMap< String,Integer>();
    Map<String, Double>  productpricemap = s.getItemoccurancemap();


    public DataObjects() {


    }

    public List<Message> ReadingDataObjects() throws Exception {
        File testFile = new File("C:\\Users\\Satyajeet Sen\\Desktop\\test.csv");
        List<Message> datalist = new DataReader().readFile(testFile);

        List<String> adjustmentvalue = new ArrayList<String>();
        List<Message> msglist = new ArrayList<Message>();


        int count = 0;
        int count1 = 0;

        List<String> products = new ArrayList<String>();



        for (Message ms : datalist) {
            m = new Message(ms.getItem(), ms.getOccurances(), ms.getPrice(), ms.getAdjustment());

            products.add(ms.getItem());
            productpricemap.put(ms.getItem(),ms.getPrice());

        }

        for(String s: products){
            hsmap.put(s,Collections.frequency(products, s));
        }
product_salescalculation();






        return datalist;
    }


    public void product_salescalculation(){

        for(Map.Entry<String,Integer> entry :hsmap.entrySet()){


            System.out.println("Product " +entry.getKey()+ " has a total "+entry.getValue()+ " sales ");
        }
    }
}







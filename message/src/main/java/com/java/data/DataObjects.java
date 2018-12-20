package com.java.data;


import com.java.Type.Type;
import com.java.adjustments.Adjustment;
import com.java.message.Message;
import com.java.product.Product;
import com.java.product.ProductType;
import com.java.sale.Sale;


import java.io.File;
import java.util.*;

public class DataObjects  {
    Sale s = new Sale();
    Adjustment a = new Adjustment();
    Message m;
    Product p = new Product();
    private Map<String, Double> productpricemap = s.getItempricemap();
    private Map<String, Integer> productoccurancemap = s.getItemoccurancemap();
    private Map<Adjustment, Double> adjustmentamtmap = a.getAdjustmentAmountMap();
    private Map<String, Integer> itemnoofadj = a.getProductnoofadj();
    private Map<String, Integer> productnoofsalesmap = s.getItemnoofsales();

    int message_counter = 0;
    Type type1 = null;
    List<String> products = new ArrayList<>();
    List<Type> adjlist = new ArrayList<>();
    int i=0;

    public DataObjects() {


    }

    public List<Message> readingDataObjects() throws Exception {
//reading from a file
        File messageFile = new File("src/resources/java/message.csv");
        List<Message> datalist = null;
        try {
            datalist = new DataReader().readFile(messageFile);
        } catch (Exception e) {
            e.printStackTrace();
        }


//iterating over datalist
        for (Message msg : datalist) {
            ++message_counter;


            p = new Product();
            p.setName(msg.getItem());
            p.setPrice(msg.getPrice());

//if adjustment not empty
            if (!msg.getAdjustment().isEmpty()) {
                type1 = Type.valueOf(msg.getAdjustment().toUpperCase());
                a = new Adjustment(type1, msg.getPrice(), msg.getItem());
                p = new Product(msg.getItem(), msg.getPrice());
//adding adjustment to list
                adjlist.add(type1);
                p.setAdjustment(type1);
                a.setName(msg.getItem());
                a.setProd(p);
            }
//adding item to product
            products.add(msg.getItem());


//putting items and price into map object
            productpricemap.put(msg.getItem(), msg.getPrice());
            //check if occurances not equal to zero
            if (msg.getOccurances() != 0)
                // adding item and occurances to productoccurance map
                productoccurancemap.put(msg.getItem(), msg.getOccurances());
            //calculating occurances of each item in product list
            productnoofsalesmap.put(msg.getItem(), Collections.frequency(products, msg.getItem()));


            //adjustmentamtmap.put(type1, m.getPrice());
//calculating occurancesof an item in adjustment list
            //checks if not blank//
            if (msg.getAdjustment() != "") {
                for(int j=0;j<adjlist.size();j++)
                itemnoofadj.put(msg.getItem(), Collections.frequency(adjlist,type1));

                adjustmentamtmap.put(a, msg.getPrice());

            }



            //for every 10processed list or message put a logger alert
            if (message_counter % 10 == 0) {
                s.product_salescalculation(message_counter);
            }
            //for every 50 processed list or message put logger alert to stop receiving messages
            if (message_counter % 50 == 0) {

                a.product_adjustmentcalculation(itemnoofadj, message_counter, adjustmentamtmap, m, p);

            }


        }


        return datalist;

    }
}
















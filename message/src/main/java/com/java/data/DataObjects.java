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
    Product p = new Product();
    Map<String, Double> productpricemap = s.getItempricemap();
    Map<String, Integer> productoccurancemap = s.getItemoccurancemap();
    Map<Type, Double> adjustmentamtmap = a.getAdjustmentAmountMap();
    Map<String, List<String>> productadjlist = a.getItemadjustmentlistmap();
    Map<String, Integer> productnoofsalesmap = s.getItemnoofsales();
    Map<String, Integer> itemnoofadj = a.getProductnoofadj();
    Map<String, List<Adjustment>> itemadjmap = a.getItemadjmap();
    double total;
    int message_counter = 0;

    private int counter;
    Type type1 = null;

    public DataObjects() {


    }

    public List<Message> readingDataObjects() throws Exception {
//reading from a file
        File testFile = new File("src/resources/java/test.csv");
        List<Message> datalist = null;
        try {
            datalist = new DataReader().readFile(testFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> products = new ArrayList<String>();
        List<String> adjlist = new ArrayList<>();

//iterating over datalist
        for (Message msg : datalist) {
            ++message_counter;
//instantiating message object
            m = new Message(msg.getItem(), msg.getOccurances(), msg.getPrice(),
                    msg.getAdjustment());
            p = new Product();
            p.setName(msg.getItem());
            p.setPrice(msg.getPrice());

//if adjustment not empty
            if (!msg.getAdjustment().isEmpty()) {
                type1 = Type.valueOf(msg.getAdjustment().toUpperCase());
                a = new Adjustment(type1, msg.getPrice(), msg.getItem());
//adding adjustment to list
                adjlist.add(msg.getAdjustment());
                p.setAdjustment(type1);
            }
//adding item to product
            products.add(msg.getItem());


//putting items and price into map object
            productpricemap.put(m.getItem(), m.getPrice());
            //check if occurances not equal to zero
            if (m.getOccurances() != 0)
                // adding item and occurances to productoccurance map
                productoccurancemap.put(m.getItem(), m.getOccurances());
            //calculating occurances of each item in product list
            productnoofsalesmap.put(m.getItem(), Collections.frequency(products, m.getItem()));





                //adjustmentamtmap.put(type1, m.getPrice());
//calculating occurancesof an item in adjustment list
            //checks if not blank//
               if(m.getAdjustment()!="") {
                   itemnoofadj.put(m.getItem(), Collections.frequency(adjlist, m.getAdjustment()));
                   productadjlist.put(m.getAdjustment(), adjlist);
               }
                //  itemadjmap.put(m.getItem(),adjlist);
                // productadjlist.put(m.getItem(), adjlist);


            //for every 10processed list or message put a logger alert
            if (message_counter % 10 == 0) {
                s.product_salescalculation(message_counter);
            }
            //for every 50 processed list or message put logger alert to stop receiving messages
            if (message_counter % 50 == 0) {
                a.product_adjustmentcalculation(itemnoofadj, message_counter, adjustmentamtmap, m, p);
                //   s.product_salescalculation(message_counter);
            }


        }


        return datalist;

    }


}













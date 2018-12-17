package com.java.data;


import com.java.Type.Type;
import com.java.adjustments.Adjustment;
import com.java.message.Message;
import com.java.product.Product;
import com.java.sale.Sale;


import java.io.File;
import java.util.*;


public class DataObjects  {
    Sale s = new Sale();
    Adjustment a=new Adjustment();
    Message m;


    List<Message> messageslist = new ArrayList<Message>();

    Product p = new Product();
    Map<String, Double> productpricemap = s.getItempricemap();
    Map<String, Integer> productoccurancemap = s.getItemoccurancemap();
    Map<Type, Double> adjustmentamtmap = a.getAdjustmentAmountMap();
    Map<String,List<Type>> productadjlist = a.getItemadjustmentlistmap();
    Map<String, Integer> productnoofsalesmap = s.getItemnoofsales();
    double total;
    int message_counter = 0;

    private int counter;
    Type type1=null;
    public DataObjects() {


    }

    public List<Message> readingDataObjects() {

        File testFile = new File("C:\\Users\\Satyajeet Sen\\Desktop\\test.csv");
        List<Message> datalist = null;
        try {
            datalist = new DataReader().readFile(testFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> products = new ArrayList<String>();
        List<Type> adjlist = new ArrayList<Type>();


        for (Message msg : datalist) {
            ++message_counter;

            m = new Message(msg.getItem(), msg.getOccurances(), msg.getPrice(),
                    msg.getAdjustment());

            if (!msg.getAdjustment().isEmpty()) {
                type1 = Type.valueOf(msg.getAdjustment().toUpperCase());
                a = new Adjustment(type1, msg.getPrice(), msg.getItem());
                adjlist.add(type1);
            }

            products.add(msg.getItem());


            productpricemap.put(m.getItem(), m.getPrice());
            if (m.getOccurances() != 0)
                productoccurancemap.put(m.getItem(), m.getOccurances());
            productnoofsalesmap.put(m.getItem(), Collections.frequency(products, m.getItem()));
            if (m.getAdjustment() != null && m.getOccurances() != 0)

                adjustmentamtmap.put(type1, m.getPrice());
            productadjlist.put(m.getItem(), adjlist);


            if (message_counter % 10 == 0) {
                s.product_salescalculation(message_counter);
            }
            if (message_counter % 50 == 0) {
                a.product_adjustmentcalculation(productadjlist, message_counter, adjustmentamtmap);
                s.product_salescalculation(message_counter);
            }


        }


        return datalist;

    }





}













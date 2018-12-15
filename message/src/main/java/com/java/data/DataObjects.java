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
    Map<String, Integer> itemnoofsales = new HashMap<String, Integer>();
    Product p = new Product();
    Map<String, Double> productpricemap = p.getItempricemap();
    Map<String, Integer> productoccurancemap = s.getItemoccurancemap();
    Map<Type, List<String>> productadjustmentmap = a.getItemAdjustmentMap();

    double total;
    int message_counter = 0;
    private int c;

    public DataObjects() {


    }

    public List<Message> ReadingDataObjects() throws Exception {
        File testFile = new File("C:\\Users\\Satyajeet Sen\\Desktop\\test.csv");
        List<Message> datalist = new DataReader().readFile(testFile);
        List<String> products = new ArrayList<String>();
        List<String> adjustments = new ArrayList<String>();


        adjustments.add("ADD");
        adjustments.add("SUBTRACT");
        adjustments.add("MULTIPLY");

        for (Message msg : datalist) {
            ++message_counter;
            m = new Message(msg.getItem(), msg.getOccurances(), msg.getPrice(), msg.getAdjustment());

            products.add(msg.getItem());


            productpricemap.put(m.getItem(), m.getPrice());
            if (m.getOccurances() != 0)
                productoccurancemap.put(m.getItem(), m.getOccurances());
            itemnoofsales.put(m.getItem(), Collections.frequency(products, m.getItem()));
            if (m.getAdjustment() != null)
                productadjustmentmap.put(m.getItem(), adjustments);

            total += Collections.frequency(products, m.getItem());
            if (message_counter % 10 == 0) {
                product_salescalculation(message_counter);
            }



        }


        return datalist;
    }


    public void product_salescalculation(int count) {


        System.out.println("\nReport of total sales per product type at sale count : " + count);
        for (Map.Entry<String, Integer> entry : itemnoofsales.entrySet()) {

            System.out.println("Product " + entry.getKey() + " has a total " + entry.getValue() + " sales ");
            System.out.println("Total value of sale : " + (entry.getValue() * productpricemap.get(entry.getKey()) * productoccurancemap.get(entry.getKey())));


        }


          /*  System.out.println("\n*******Application is pausing. A report of adjustments per sale will now be logged");

    Map.Entry<String, Integer> entry : itemnoofsales.entrySet())

    {


        System.out.println("Product " + entry.getKey() + " has a total " + entry.getValue() + " sales ");
        System.out.println("Total value of sale is" + (entry.getValue() * productpricemap.get(entry.getKey()) * productoccurancemap.get(entry.getKey())));


    }
*/
    }
}













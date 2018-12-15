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
    Adjustment a=new Adjustment();
    Message m;


    List<Message> messageslist = new ArrayList<Message>();
    Map<String, Integer> itemnoofsales = new HashMap<String, Integer>();
    Product p = new Product();
    Map<String, Double> productpricemap = p.getItempricemap();
    Map<String, Integer> productoccurancemap = s.getItemoccurancemap();
    Map<Type, Double> adjustmentamtmap = a.getAdjustmentAmountMap();
    Map<String,List<Type>> productadjlist = a.getItemadjustmentlistmap();

    double total;
    int message_counter = 0;

    private int counter;
    Type type1=null;
    public DataObjects() {


    }

    public List<Message> readingDataObjects() throws Exception,IllegalArgumentException {
        File testFile = new File("C:\\Users\\Satyajeet Sen\\Desktop\\test.csv");
        List<Message> datalist = new DataReader().readFile(testFile);
        List<String> products = new ArrayList<String>();
        List<Type> adjlist = new ArrayList<Type>();







        for (Message msg : datalist) {
            ++message_counter;

                m = new Message(msg.getItem(), msg.getOccurances(), msg.getPrice(),
                        msg.getAdjustment());

            if(!msg.getAdjustment().isEmpty()) {
                type1 = Type.valueOf(msg.getAdjustment().toUpperCase());
                a=new Adjustment(type1,msg.getPrice(),msg.getItem());
                adjlist.add(type1);
            }

            products.add(msg.getItem());


            productpricemap.put(m.getItem(), m.getPrice());
            if (m.getOccurances() != 0)
                productoccurancemap.put(m.getItem(), m.getOccurances());
            itemnoofsales.put(m.getItem(), Collections.frequency(products, m.getItem()));
            if (m.getAdjustment() != null && m.getOccurances()!=0)

                adjustmentamtmap.put(type1,m.getPrice());
                 productadjlist.put(m.getItem(),adjlist);


            if (message_counter % 10 == 0) {
                product_salescalculation(message_counter);
            }
            if(message_counter % 50 ==0){
                product_adjustmentcalculation(productadjlist,message_counter);
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

    }
    public void product_adjustmentcalculation(Map<String,List<Type>> mp,int count) {
         counter++;
        System.out.println("\n*******Application is pausing. A report of adjustments per sale will now be logged");

        for (Map.Entry<String,List<Type>> entry1 : mp.entrySet()) {
              int i=0;
            System.out.println("\nProduct type " + ": " + entry1.getKey() + " has total " + entry1.getValue().size()
                    + " adjustments\n" + entry1.getValue().get(i));
            System.out.println(a.toString());
            i++;
        System.out.println();


    }

    }
}













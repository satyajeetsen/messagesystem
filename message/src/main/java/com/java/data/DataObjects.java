package com.java.data;


import com.java.Type.Type;
import com.java.adjustments.Adjustment;
import com.java.message.Message;
import com.java.product.Product;
import com.java.sale.Sale;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DataObjects  {
    Sale s = new Sale();
    Adjustment a = new Adjustment();
    Message m;
    List<String> messagetype3 = new ArrayList<String>();
    List<String> messagetype2 = new ArrayList<String>();
    List<String> messagetype1 = new ArrayList<String>();


public DataObjects(){



    }
    public List<Message> ReadingDataObjects() throws Exception {
        File testFile = new File("C:\\Users\\Satyajeet Sen\\Desktop\\test.csv");
        List<Message> datalist = new DataReader().readFile(testFile);
        int counter = datalist.get(0).toString().split(" ").length;
        List<String> adjustmentvalue = new ArrayList<String>();


        Product p;


        for (Message message : datalist) {
            int count = 0;

            m = new Message(message.getItem(), message.getOccurances(), message.getPrice(), message.getAdjustment());


            if (s.getItemoccurancemap().containsKey(message.getItem())) {
                count = s.getItemoccurancemap().get(message.getItem());
                s.getItemoccurancemap().put(message.getItem(), count++);
            } else {
                s.getItemoccurancemap().put(message.getItem(), count++);
            }
            adjustmentvalue.add(message.getAdjustment());
            if (a.getItemAdjustmentMap().containsKey(message.getItem())) {
                adjustmentvalue = a.getItemAdjustmentMap().get(message.getItem());
                a.getItemAdjustmentMap().put(message.getItem(), adjustmentvalue);
            } else {
                a.getItemAdjustmentMap().put(message.getItem(), adjustmentvalue);
            }


            int i = 0;


            if (m.getOccurances() == 1) {

                messagetype1.add(m.getItem() + " at " + m.getPrice() + " GBP");

            } else if (m.getOccurances() > 1 && m.getAdjustment() != null && m.getAdjustment() != "") {


                messagetype3.add(m.getAdjustment() + " " + m.getPrice() + "GBP to each sale of" + m.getItem() + "you have recorded");
                messagetype2.add(m.getOccurances() + "sales of" + m.getItem() + " of " + m.getPrice() + "GBP each");

            } else {

            }

        }
        for (Map.Entry<String, Integer> hsmapitr : s.getItemoccurancemap().entrySet()){

            
               System.out.println(hsmapitr.getValue())

        }

        for (Map.Entry<String, List<String>> hsmapitr1 : a.getItemAdjustmentMap().entrySet()){



        }
            System.out.println("Type1 Message");
        for (String s1 : messagetype1) {

                System.out.println(s1);
            }


            System.out.println("Type2 Message");
            for (String s2 : messagetype2) {

                System.out.println(s2);
            }


            System.out.println("Type3 Message");
            for (String s3 : messagetype3) {

                System.out.println(s3);


        }
       // createMessage(messagetype1,messagetype2,messagetype3,datalist);


        return datalist;


    }

    public void createMessage(List<String> list0,List<String> list1,List<String> list2,List<Message> msglist) {

    }
}

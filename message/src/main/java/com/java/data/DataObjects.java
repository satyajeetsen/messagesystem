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


public class DataObjects {
    Sale s = new Sale();
    Adjustment a = new Adjustment();
    Message m;
    List<Message> messageslist = new ArrayList<Message>();
    int total_tv;


    public DataObjects() {


    }

    public List<Message> ReadingDataObjects() throws Exception {
        File testFile = new File("C:\\Users\\Satyajeet Sen\\Desktop\\test.csv");
        List<Message> datalist = new DataReader().readFile(testFile);

        List<String> adjustmentvalue = new ArrayList<String>();
        Map<String, Integer> hs = s.getItemoccurancemap();

        int messagecounter = 0;
        int total_laptop = 0;
        int total_ipod = 0;
        int total_ipad = 0;
        int total_mobile = 0;


        Product p;

        for (Message message : datalist) {
            int count = 0;


            m = new Message(message.getItem(), message.getOccurances(), message.getPrice(), message.getAdjustment());





           /* if(m.getItem().equalsIgnoreCase("LAPTOP")) {
                if (s.getItemoccurancemap().containsKey(message.getItem())) {
                    count = s.getItemoccurancemap().get(message.getItem());
                    s.getItemoccurancemap().put(message.getItem(), count++);
                } else {
                  //  s.getItemoccurancemap().put(message.getItem(), message.getOccurances());
                }
                System.out.println("LAPTOP count is "+count);
            }*/
            adjustmentvalue.add(message.getAdjustment());
            if (a.getItemAdjustmentMap().containsKey(message.getItem())) {
                adjustmentvalue = a.getItemAdjustmentMap().get(message.getItem());
                a.getItemAdjustmentMap().put(message.getItem(), adjustmentvalue);
            } else {
                a.getItemAdjustmentMap().put(message.getItem(), adjustmentvalue);
            }


            int i = 0;


            if (m.getOccurances() == 1) {

                messageslist.add(new Message(m.getItem() + " at " + m.getPrice() + " GBP"));

            } else if (m.getOccurances() > 1 && m.getAdjustment() != null && m.getAdjustment() != "") {


                messageslist.add(new Message(m.getAdjustment() + " " + m.getPrice() + "GBP to each sale of " + m.getItem() + " you have recorded"));
                messageslist.add(new Message(m.getOccurances() + "sales of " + m.getItem() + " of " + m.getPrice() + " GBP each"));

            } else {

            }



    }

        System.out.println("Number of messages is " + messageslist.size());


        for (Message messages : messageslist) {
            if(messageslist.size() % 10 == 0 && messages.getItem().equalsIgnoreCase("LAPTOP")){
                System.out.println("Number of sales of"+messages.getItem()+"is"+);
            }
            m = new Message(messages.getItem(), messages.getOccurances(), messages.getPrice(), messages.getAdjustment());
            hs.put(messages.getItem(), messages.getOccurances());
            System.out.println(messages.getMsg());
        }
        for (Map.Entry<String, Integer> k : hs.entrySet()) {
            String key = k.getKey();
            if (key != null) {
                if (k.getKey().equalsIgnoreCase("LAPTOP")) {

                    int salescountlaptop = hs.get(k.getKey());

                    total_laptop += salescountlaptop;
                } else if (key.equalsIgnoreCase("IPOD")) {

                    int salescountipod = hs.get(k.getKey());

                    total_ipod += salescountipod;
                } else if (key.equalsIgnoreCase("IPAD")) {

                    int salescountipad = hs.get(k.getKey());

                    total_ipad += salescountipad;
                } else if (key.equalsIgnoreCase("MOBILE")) {

                    int salescountmobile = hs.get(k.getKey());

                    total_mobile += salescountmobile;
                } else if (key.equalsIgnoreCase("TV")) {

                    int salescounttv = hs.get(k.getKey());

                    total_tv += salescounttv;
                } else {
                    System.out.println("Key is null");

                }
            }
        }


        System.out.println("Total laptop sales is" + total_laptop);
        System.out.println("Total ipod sales is" + total_ipod);
        System.out.println("Total ipad sales is" + total_ipad);
        System.out.println("Total mobile sales is" + total_mobile);
        System.out.println("Total tv sales is" + total_tv);


        for (Map.Entry<String, List<String>> hsmapitr1 : a.getItemAdjustmentMap().entrySet()) {


        }

        // createMessage(messagetype1,messagetype2,messagetype3,datalist);


        return datalist;


    }
}



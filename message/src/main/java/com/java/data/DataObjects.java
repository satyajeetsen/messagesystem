package com.java.data;


import com.java.message.Message;
import com.java.product.Product;
import com.java.sale.Sale;
import com.sun.codemodel.internal.JClassAlreadyExistsException;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DataObjects {
    Sale s = new Sale();


    public List<Message> ReadingDataObjects() throws Exception {
        File testFile = new File("C:\\Users\\Satyajeet Sen\\Desktop\\test.csv");
        List<Message> datalist = new DataReader().readFile(testFile);
        Product p;

        for (Message message : datalist) {
            int count = 0;
            p = new Product(message.getItem(), message.getPrice());
            if (s.getItemoccurancemap().containsKey(message.getItem())) {
                count = s.getItemoccurancemap().get(message.getItem());
                s.getItemoccurancemap().put(message.getItem(), count++);
            } else {
                s.getItemoccurancemap().put(message.getItem(), count++);
            }
        }


        createMessage(datalist);

        return datalist;


    }

    public void createMessage(List<Message> list0) {


    }
}

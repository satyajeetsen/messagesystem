package com.java.main;


import com.java.data.DataObjects;
import com.java.message.Message;
import com.java.sale.Sale;


import java.util.List;


public class Main {

    public static void main(String[] args) throws Exception {


        Sale sale = new Sale();


        DataObjects data = new DataObjects();
        List<Message> csvobjects = data.readingDataObjects();


    }


}


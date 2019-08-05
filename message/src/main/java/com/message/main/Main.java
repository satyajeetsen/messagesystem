package com.message.main;


import com.message.data.DataObjects;
import com.message.message.Message;
import com.message.sale.Sale;


import java.util.List;


public class Main {

    public static void main(String[] args) throws Exception {


        Sale sale = new Sale();


        DataObjects data = new DataObjects();
        List<Message> csvobjects = data.readingDataObjects();


    }


}


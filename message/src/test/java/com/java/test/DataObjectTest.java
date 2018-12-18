package com.java.test;

import com.java.Type.Type;
import com.java.adjustments.Adjustment;
import com.java.data.DataObjects;
import com.java.data.DataReader;
import com.java.message.Message;
import com.java.product.Product;
import com.java.sale.Sale;

import org.junit.Test;

import java.io.IOException;
import java.util.*;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertThat;

public class DataObjectTest {


    MessageReaderTest mrt = new MessageReaderTest();
    DataObjects d = new DataObjects();
    Adjustment ad = new Adjustment();
    Adjustment ad1 = new Adjustment();
    Adjustment ad2 = new Adjustment();
    Sale sale = new Sale();
    Sale sale1 = new Sale();
    Sale sale2 = new Sale();
    Product pr = new Product();
    Product pr1 = new Product();
    Product pr2 = new Product();

    List<Message> datalist;

    {
        try {
            datalist = d.readingDataObjects();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Message msg = datalist.get(0);
    Message msg1 = datalist.get(1);
    Message msg2 = datalist.get(2);
    Map<String, Double> productpricemap = sale.getItempricemap();
    Map<String, Integer> productoccurancemap = sale.getItemoccurancemap();
    Map<Type, Double> adjustmentamtmap = ad.getAdjustmentAmountMap();
  //  Map<String, List<String>> productadjlist = ad.getItemadjustmentlistmap();
    Map<String, Integer> productnoofsalesmap = sale.getItemnoofsales();
    Type type1 = Type.ADD;
    Type type2 = Type.SUBTRACT;
    Type type3 = Type.MULTIPLY;
    Type type4;


    @Test
    public void populateMessageType1() throws Exception {
        if (!msg.getAdjustment().isEmpty()) {
            type1 = Type.valueOf(msg.getAdjustment().toUpperCase());
            type2 = Type.valueOf(msg1.getAdjustment().toUpperCase());
            type3 = Type.valueOf(msg2.getAdjustment().toUpperCase());
        }

        assertEquals("LAPTOP", msg.getItem());
        assertEquals(1, msg.getOccurances());
        assertEquals(20.0, msg.getPrice());
        assertEquals("", msg.getAdjustment());


    }

    @Test
    public void populateMessageType2() throws Exception {


        assertEquals("IPAD", msg1.getItem());
        assertEquals(3, msg1.getOccurances());
        assertEquals(30.0, msg1.getPrice());
        assertEquals("", msg1.getAdjustment());
        productoccurancemap.put(msg1.getItem(), msg1.getOccurances());
        productnoofsalesmap.put(msg1.getItem(), msg1.getOccurances());
        productpricemap.put(msg1.getItem(), msg1.getPrice());
        adjustmentamtmap.put(type2, msg1.getPrice());
        //  productadjlist.put(msg1.getItem(), );

    }


    @Test
    public void populateMessageType3() throws Exception {


        assertEquals("MOBILE", msg2.getItem());
        assertEquals(2, msg2.getOccurances());
        assertEquals(10.0, msg2.getPrice());
        assertEquals("ADD", msg2.getAdjustment());

    }

    @Test
    public void mapTestType1() throws Exception {


        productoccurancemap.put(msg.getItem(), msg.getOccurances());
        productnoofsalesmap.put(msg.getItem(), msg.getOccurances());
        productpricemap.put(msg.getItem(), msg.getPrice());
        adjustmentamtmap.put(type4, msg.getPrice());
        //  productadjlist.put(msg.getItem(), Arrays.asList(Type.values()));
        sale.setItemoccurancemap(productoccurancemap);
        sale.setItemnoofsales(productnoofsalesmap);
        sale.setItempricemap(productpricemap);
      //  ad.setItemadjustmentlistmap(productadjlist);
        ad.setAdjustmentAmountMap(adjustmentamtmap);
        pr.setName(msg.getItem());
        pr.setPrice(msg.getPrice());
        sale.setProduct(pr);
        if (!msg.getAdjustment().isEmpty())
            ad.setAdjustmentType(type4);
        ad.setAdjustmentAmount(msg.getPrice());

        if (msg.getOccurances() == 1) {
            // System.out.println(sale.getItemoccurancemap().get(msg.getItem()));

            assertEquals(1, productoccurancemap.get(msg.getItem()).intValue());
            assert (sale.getItemoccurancemap().containsValue(msg.getOccurances()));
            assert (ad.getItemadjustmentlistmap().containsKey(msg.getItem()));
            assert (ad.getItemadjustmentlistmap().containsValue(Arrays.asList(Type.values())));
            assert (ad.getAdjustmentAmountMap().containsKey(ad.getAdjustmentType()));
            assert (ad.getAdjustmentAmountMap().containsValue(msg.getPrice()));
            assertEquals(20.0, sale.getItempricemap().get(msg.getItem()));

        }
    }

    @Test
    public void mapTestType2() throws Exception {


        productoccurancemap.put(msg1.getItem(), msg1.getOccurances());
        productnoofsalesmap.put(msg1.getItem(), msg1.getOccurances());
        productpricemap.put(msg1.getItem(), msg1.getPrice());
        adjustmentamtmap.put(type4, msg1.getPrice());
        //    productadjlist.put(msg1.getItem(),(String)Arrays.asList(Type.values()));
        sale.setItemoccurancemap(productoccurancemap);
        sale.setItemnoofsales(productnoofsalesmap);
        sale.setItempricemap(productpricemap);
      //  ad.setItemadjustmentlistmap(productadjlist);
        ad.setAdjustmentAmountMap(adjustmentamtmap);
        pr.setName(msg1.getItem());
        pr.setPrice(msg1.getPrice());
        sale.setProduct(pr);
        if (!msg.getAdjustment().isEmpty())
            ad.setAdjustmentType(type4);
        ad.setAdjustmentAmount(msg1.getPrice());

        if (msg.getOccurances() > 1) {
            // System.out.println(sale.getItemoccurancemap().get(msg.getItem()));

            assertEquals(4, productoccurancemap.get(msg1.getItem()).intValue());
            assert (sale.getItemoccurancemap().containsValue(msg1.getOccurances()));
            assert (ad.getItemadjustmentlistmap().containsKey(msg1.getItem()));
            assert (ad.getItemadjustmentlistmap().containsValue(Arrays.asList(Type.values())));
            assert (ad.getAdjustmentAmountMap().containsKey(ad.getAdjustmentType()));
            assert (ad.getAdjustmentAmountMap().containsValue(msg1.getPrice()));
            assertEquals(30.0, sale.getItempricemap().get(msg1.getItem()));

        }
    }

    @Test
    public void mapTestType3() throws Exception {


        productoccurancemap.put(msg2.getItem(), msg2.getOccurances());
        productnoofsalesmap.put(msg2.getItem(), msg2.getOccurances());
        productpricemap.put(msg2.getItem(), msg2.getPrice());
        adjustmentamtmap.put(type1, msg2.getPrice());
        //  productadjlist.put(msg2.getItem(),Arrays.asList(Type.values()));
        sale.setItemoccurancemap(productoccurancemap);
        sale.setItemnoofsales(productnoofsalesmap);
        sale.setItempricemap(productpricemap);
       // ad.setItemadjustmentlistmap(productadjlist);
        ad.setAdjustmentType(type1);
        ad.setAdjustmentAmountMap(adjustmentamtmap);
        pr.setName(msg2.getItem());
        pr.setPrice(msg2.getPrice());
        sale.setProduct(pr);
        if (!msg.getAdjustment().isEmpty())
            ad.setAdjustmentType(type4);
        ad.setAdjustmentAmount(msg2.getPrice());


        // System.out.println(sale.getItemoccurancemap().get(msg.getItem()));

        assertEquals(2, productoccurancemap.get(msg2.getItem()).intValue());
        assert (sale.getItemoccurancemap().containsValue(msg2.getOccurances()));
        assert (ad.getItemadjustmentlistmap().containsKey(msg2.getItem()));
        assert (ad.getItemadjustmentlistmap().containsValue(Arrays.asList(Type.values())));
        assert (ad.getAdjustmentAmountMap().containsKey(ad.getAdjustmentType()));
        assert (ad.getAdjustmentAmountMap().containsValue(msg2.getPrice()));
        assertEquals(10.0, productpricemap.get(msg2.getItem()));

    }
}



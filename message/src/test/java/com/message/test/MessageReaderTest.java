package com.message.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;

import com.java.message.Message;
import org.junit.Rule;
import org.junit.Test;

import com.java.data.DataReader;
import org.junit.rules.ExternalResource;
import org.junit.rules.TemporaryFolder;

public class MessageReaderTest extends ExternalResource {


    DataReader dr = new DataReader();

    @Test
    public void testReadingPersonObjectsFromCsvData() throws Exception {
        File testFile = new File("src/test/resources/test.csv");
        List<Message> datalist = dr.readFile(testFile);
        assertEquals(62, datalist.size());


        Message dt1 = datalist.get(0);
        assertEquals("LAPTOP", dt1.getItem());
        assertEquals(1, dt1.getOccurances());
        assertEquals(20.0, dt1.getPrice(), 0);
        assertEquals("", dt1.getAdjustment());

        Message dt2 = datalist.get(1);
        assertEquals("IPAD", dt2.getItem());
        assertEquals(3, dt2.getOccurances());
        assertEquals(30.0, dt2.getPrice(), 0);
        assertEquals("", dt2.getAdjustment());


        Message dt3 = datalist.get(2);
        assertEquals("MOBILE", dt3.getItem());
        assertEquals(2, dt3.getOccurances());
        assertEquals(10.0, dt3.getPrice(), 0);
        assertEquals("ADD", dt3.getAdjustment());

        Message dt4 = datalist.get(3);
        assertEquals("IPOD", dt4.getItem());
        assertEquals(0, dt4.getOccurances());
        assertEquals(20.0, dt4.getPrice(), 0);
        assertEquals("", dt4.getAdjustment());


        Message dt5 = datalist.get(4);
        assertEquals("TV", dt5.getItem());
        assertEquals(4, dt5.getOccurances());
        assertEquals(50.0, dt5.getPrice(), 0);
        assertEquals("", dt5.getAdjustment());


    }
}

package com.java.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;

import org.junit.Test;

import com.java.data.DataReader;

public class MessageReaderTest {

	@Test
	public void testReadingPersonObjectsFromCsvData() throws Exception {
		File testFile = new File("C:\\Users\\Satyajeet Sen\\Desktop\\test.csv");
		List<Data> datalist = DataReader.readFile(testFile);
		assertEquals(5, datalist.size());
		Data dt1 = datalist.get(0);
		assertEquals("LAPTOP", dt1.getItems());
		assertEquals(2, dt1.getOccurances());
		assertEquals(20, dt1.getPrice());
		assertEquals("ADD", dt1.getAdjustments());
		
		Data dt2 = datalist.get(1);
		assertEquals("IPAD", dt2.getItems());
		assertEquals(3, dt2.getOccurances());
		assertEquals(30, dt2.getPrice());
		assertEquals("SUBTRACT", dt2.getAdjustments());
		
		
	
		
		
		Data dt3 = datalist.get(2);
		assertEquals("MOBILE", dt3.getItems());
		assertEquals(2, dt3.getOccurances());
		assertEquals(10, dt3.getPrice());
		assertEquals("MULTIPLY", dt3.getAdjustments());
		
		
		Data dt4 = datalist.get(3);
		assertEquals("IPOD", dt4.getItems());
		assertEquals(1, dt4.getOccurances());
		assertEquals(20, dt4.getPrice());
		assertEquals("ADD", dt4.getAdjustments());
		
		
		
		Data dt5 = datalist.get(4);
		assertEquals("TV", dt5.getItems());
		assertEquals(4, dt5.getOccurances());
		assertEquals(50, dt5.getPrice());
		assertEquals("ADD", dt5.getAdjustments());
		
		
	}
}

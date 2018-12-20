package com.message.data;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.message.message.Message;

import java.io.File;
import java.util.List;


public class DataReader {


    public List<Message> readFile(File csvFile) throws Exception {
        MappingIterator<Message> dataIter = new CsvMapper().readerWithTypedSchemaFor(Message.class).readValues(csvFile);

        return dataIter.readAll();
    }
}

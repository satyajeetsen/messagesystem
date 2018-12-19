# messagesystem

This is a messaging application program which fetch values of item name,occurances,price and adjustment data from a csv file containing 62 rows of data.It  puts these values inside their respective pojo classes.The pojo classes creates maps of different data types used for sales calculation of each item per 10 messages are processed in the application.When the number of messages reaches 50,it notifies the user using a logger message.
 The entry point of the application is from the class Main.java which calls
DataObjects.java which reads the CSV file from src/java/resources directory. 


A Sale contains Product, and maintains a map of itemoccurance,itemnoofsales map. This is the total sales per product type.
A Product class contains Item name,price and adjustment.
An Adjustment class contains name,adjustmentType,price and Product and calculates sales per item and Adjustment per item and its respective price.

DataObjects class reports on every 10th sale, number of sales per product type and total value.
On every 50th message it reads, it logs and pauses that application and reports total adjustments per product type for 50messages processed.

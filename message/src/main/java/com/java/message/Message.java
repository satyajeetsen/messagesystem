package com.java.message;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "items", "occurances", "price", "adjustments" })
public class Message {

	public String item;
	public int occurances;
	public int price;
	public String adjustment;


	public Message(String items, int occurances, int price, String adjustments) {
		this.item = items;
		this.occurances = occurances;
		this.price = price;
		this.adjustment = adjustment;
	}

	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getOccurances() {
		return occurances;
	}
	public void setOccurances(int occurances) {
		this.occurances = occurances;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAdjustments() {
		return adjustment;
	}
	public void setAdjustments(String adjustments) {
		this.adjustment = adjustment;
	}

    @Override
    public String toString() {
        return "Message{" +
                "item='" + item + '\'' +
                ", occurances=" + occurances +
                ", price=" + price +
                ", adjustments='" + adjustment + '\'' +
                '}';
    }
}

package com.java.message;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "item", "occurances", "price", "adjustment" })
public class Message {

	public String item;
	public int occurances;
	public int price;
	public String adjustment;
	public String msg;

	public Message(){

	}

public Message(String msg){
	this.msg= msg;
}
	public Message(String item, int occurances, int price, String adjustment) {
		this.item = item;
		this.occurances = occurances;
		this.price = price;
		this.adjustment = adjustment;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
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
	public String getAdjustment() {
		return adjustment;
	}
	public void setAdjustment(String adjustment) {
		this.adjustment = adjustment;
	}

    @Override
    public String toString() {
        return "Message{" +
                "item='" + item + '\'' +
                ", occurances=" + occurances +
                ", price=" + price +
                ", adjustment='" + adjustment + '\'' +
                '}';
    }
}

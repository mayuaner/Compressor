package edu.brandeis.cs12b.pa8;
/**
 * COSI 12B, PA8
 * @author Yuanyuan Ma
 * email: yyma@brandeis.edu
 */
public class Order implements Comparable<Order>{
	public String[] fields;
	
	public Order(String[] fields) {
		this.fields = fields;
	}
	
	public String get(int index) {
		return fields[index];
	}
	
	public String[] to_arr() {
		return fields;
	}
	
	public int compareTo(Order compareOrder) {
		return this.fields[1].compareTo(compareOrder.get(1));
	}
}
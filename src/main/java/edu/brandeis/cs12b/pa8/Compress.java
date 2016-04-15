package edu.brandeis.cs12b.pa8;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.zip.Deflater;

import org.tukaani.xz.LZMA2Options;
import org.tukaani.xz.XZOutputStream;
/**
 * COSI 12B, PA8
 * @author Yuanyuan Ma
 * email: yyma@brandeis.edu
 */
public class Compress extends Compresser {


	/**
	 * Compress the given orders, and write the results to filename. You do not
	 * need to preserve the ordering of the orders, but you do need to preserve each one.
	 * 
	 * Each order is formatted as follows:
	 * 
	 * purchased_by|purchased_from|quantity|item_sku|price|zip|state
	 * 
	 * purchased_by will be a string containing the name of the person who made the order, like "Ryan Marcus" (without quotes)
	 * purchased_from will be a string containing the name of the store to which the order was made, like "Metzger's Hardware"
	 * quantity will be an integer between 0 and Integer.MAX_VALUE expressing the number of items ordered
	 * item_sku is a 6-digit number representing the SKU (a type of ID) of the item being purchased
	 * price is an integer representing the number of cents that an item costs (an order for N screws, each of which cost 5 cents, will have a price of 5)
	 * zip is the zipcode of the customer (ex: 02453)
	 * state is the two-character state abbreviation of the customer (ex: MA, NM)
	 * 
	 * 
	 * 
	 * 
	 * @param orders an array of orders to compress, described above
	 * @param filename the filename to write
	 * @throws IOException 
	 */
	public void compress(String[] orders, String filename) throws IOException {
		// TODO implement me!
		int step = 600000;
		FileOutputStream stream = new FileOutputStream(filename);
		XZOutputStream outxz = new XZOutputStream(stream, new LZMA2Options());
		try {
			int startIndex = 0;
			while (startIndex < orders.length) {
				byte[] output = compressHelper(orders, startIndex, step);
				startIndex += step;
				outxz.write(output.length >> 24);
				outxz.write(output.length >> 16);
				outxz.write(output.length >> 8);
				outxz.write(output.length);
				outxz.write(output, 0, output.length);
			}
		} finally {
		    //stream.close();
		    outxz.close();
		}
	}
	
	public byte[] compressHelper(String[] orders, int startIndex, int step) throws UnsupportedEncodingException {
		Column[] columns = {new Column(-1), new Column(-1), new Column(-1), new Column(6), new Column(-1), new Column(5)};
		Order[] orderArr = new Order[Math.min(orders.length - startIndex, step)];
		String Delimiter = "#";
		
		for (int i = startIndex; i < orders.length && i < startIndex + step; i++) {
			String[] fields = orders[i].split("\\|");
			orderArr[i - startIndex] = new Order(fields);
		}
		Arrays.sort(orderArr);
		for (Order order: orderArr) {
			for (int i = 0; i < 6; i++) columns[i].add(order.get(i));
		}
		StringBuilder inputString = new StringBuilder();
		for (int i = 0; i < 6; i++) {
			inputString.append(columns[i].serialize());
			if (i < 5) inputString.append(Delimiter);
		}
		return inputString.toString().getBytes("UTF-8");
	}


}

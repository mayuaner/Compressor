package edu.brandeis.cs12b.pa8;

import java.util.ArrayList;

public class Column {
	private ArrayList<String> values = new ArrayList<String>();
	private int fixedLength;
	static String Delimiter = "$";
	
	public Column(int fixedLength) {
		this.fixedLength = fixedLength;
	}
	
	public void add(String value) {
		values.add(value);
	}
	
	public int size() {
		return values.size();
	}
	
	public String get(int index) {
		return values.get(index);
	}
	
	public String serialize() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < values.size(); i++) {
			s.append(values.get(i));
			if (fixedLength == -1 && i < values.size() - 1) s.append(Delimiter); 
		}
		return s.toString();
	}
	
	public void deserialize(String s) {
		if (fixedLength == -1) {
			String[] arr = s.split("\\$");
			for (String value: arr) values.add(value);
		} else {
			for(int i = 0; i < s.length(); i += fixedLength) {
				values.add(s.substring(i, i + fixedLength));
			}
		}
	}
}
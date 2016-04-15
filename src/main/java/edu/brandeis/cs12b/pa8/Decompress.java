package edu.brandeis.cs12b.pa8;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

import org.tukaani.xz.XZIOException;
import org.tukaani.xz.XZInputStream;
/**
 * COSI 12B, PA8
 * @author Yuanyuan Ma
 * email: yyma@brandeis.edu
 */
public class Decompress extends Decompresser {

	/**
	 * Here, you will be given a file that was produced by your Compress class. You should read from that file
	 * and transform the compressed information back into an array of strings.
	 * 
	 * @param f the file created by your compressor
	 * @return the original array of strings, modulo ordering 
	 * @throws IOException 
	 * @throws DataFormatException 
	 */
	public String[] decompress(File f) throws IOException, XZIOException {
		// TODO implement me!
		
		InputStream stream = new FileInputStream(f);
		XZInputStream inxz = new XZInputStream(stream);
		//PrintWriter out = new PrintWriter("output.txt");
		
		try {
			ArrayList<String> ret = new ArrayList<String>();
			while (true) {
				int bit32 = inxz.read();
				if (bit32 == -1) break;
				int bit24 = inxz.read();
				int bit16 = inxz.read();
				int bit8 = inxz.read();
				int dataLength = (bit32 << 24) | (bit24 << 16) | (bit16 << 8) | (bit8);
				System.out.println(dataLength);
				byte[] buffer = new byte[dataLength];
				inxz.read(buffer, 0, dataLength);
				String[] partOfRet = decompressHelper(buffer, dataLength);
				for(int i = 0; i < partOfRet.length; i++) ret.add(partOfRet[i]);
			}
			String[] Ret = new String[ret.size()];
			for (int i = 0 ; i < ret.size(); i++) {
				Ret[i] = ret.get(i);
				//out.println(Ret[i]);
			}
			return Ret;
		} finally {
		    inxz.close();
		    //out.close();
		}	
	}
	
	private String[] decompressHelper(byte[] buffer, int dataLength) {
		Column[] columns = {new Column(-1), new Column(-1), new Column(-1), new Column(6), new Column(-1), new Column(5)};
		
		//String output = inflate(buffer, compressedDataLength);
		String output = new String(buffer, StandardCharsets.UTF_8);
	    String[] strArr = output.split("#");
	    for (int i = 0; i < strArr.length; i++) {
	    	columns[i].deserialize(strArr[i]);
	    }
	    int len = columns[0].size();
	    String[] ret = new String[len];
	    for (int i = 0; i < len; i++) {
	    	ret[i] = "";
	    	for (int j = 0; j < 6; j++) {
	    		ret[i] += columns[j].get(i) + "|";
	    	}
	    	ret[i] += ZipDecode.decode(columns[5].get(i));
	    	//System.out.println(ret[i]);
	    }
	    return ret;
	}


}

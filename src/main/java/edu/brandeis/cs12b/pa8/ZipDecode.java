package edu.brandeis.cs12b.pa8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * COSI 12B, PA8
 * @author Yuanyuan Ma
 * email: yyma@brandeis.edu
 */
public class ZipDecode {
	public static String decode(String zipcode) {
		int zip = Integer.parseInt(zipcode) / 100;
		if (zip >= 5 && zip <= 5) return "NY";
		else if (zip >= 6 && zip <= 7) return "PR";
		else if (zip >= 8 && zip <= 8) return "VI";
		else if (zip >= 9 && zip <= 9) return "PR";
		else if (zip >= 10 && zip <= 27) return "MA";
		else if (zip >= 28 && zip <= 29) return "RI";
		else if (zip >= 30 && zip <= 38) return "NH";
		else if (zip >= 39 && zip <= 49) return "ME";
		else if (zip >= 50 && zip <= 54) return "VT";
		else if (zip >= 55 && zip <= 55) return "MA";
		else if (zip >= 56 && zip <= 59) return "VT";
		else if (zip >= 60 && zip <= 69) return "CT";
		else if (zip >= 70 && zip <= 89) return "NJ";
		else if (zip >= 90 && zip <= 99) return "AE";
		else if (zip >= 100 && zip <= 149) return "NY";
		else if (zip >= 150 && zip <= 196) return "PA";
		else if (zip >= 197 && zip <= 199) return "DE";
		else if (zip >= 200 && zip <= 200) return "DC";
		else if (zip >= 201 && zip <= 201) return "VA";
		else if (zip >= 202 && zip <= 205) return "DC";
		else if (zip >= 206 && zip <= 212) return "MD";
		else if (zip >= 214 && zip <= 219) return "MD";
		else if (zip >= 220 && zip <= 246) return "VA";
		else if (zip >= 247 && zip <= 268) return "WV";
		else if (zip >= 270 && zip <= 289) return "NC";
		else if (zip >= 290 && zip <= 299) return "SC";
		else if (zip >= 300 && zip <= 319) return "GA";
		else if (zip >= 320 && zip <= 339) return "FL";
		else if (zip >= 340 && zip <= 340) return "AA";
		else if (zip >= 341 && zip <= 342) return "FL";
		else if (zip >= 344 && zip <= 344) return "FL";
		else if (zip >= 346 && zip <= 347) return "FL";
		else if (zip >= 349 && zip <= 349) return "FL";
		else if (zip >= 350 && zip <= 352) return "AL";
		else if (zip >= 354 && zip <= 369) return "AL";
		else if (zip >= 370 && zip <= 385) return "TN";
		else if (zip >= 386 && zip <= 397) return "MS";
		else if (zip >= 398 && zip <= 399) return "GA";
		else if (zip >= 400 && zip <= 427) return "KY";
		else if (zip >= 430 && zip <= 459) return "OH";
		else if (zip >= 460 && zip <= 471) return "IN";
		else if (zip >= 472 && zip <= 479) return "IN";
		else if (zip >= 480 && zip <= 499) return "MI";
		else if (zip >= 500 && zip <= 528) return "IA";
		else if (zip >= 530 && zip <= 532) return "WI";
		else if (zip >= 534 && zip <= 535) return "WI";
		else if (zip >= 537 && zip <= 549) return "WI";
		else if (zip >= 550 && zip <= 551) return "MN";
		else if (zip >= 553 && zip <= 567) return "MN";
		else if (zip >= 570 && zip <= 577) return "SD";
		else if (zip >= 580 && zip <= 588) return "ND";
		else if (zip >= 590 && zip <= 599) return "MT";
		else if (zip >= 600 && zip <= 620) return "IL";
		else if (zip >= 622 && zip <= 629) return "IL";
		else if (zip >= 630 && zip <= 631) return "MO";
		else if (zip >= 633 && zip <= 641) return "MO";
		else if (zip >= 644 && zip <= 658) return "MO";
		else if (zip >= 660 && zip <= 662) return "KS";
		else if (zip >= 664 && zip <= 679) return "KS";
		else if (zip >= 680 && zip <= 681) return "NE";
		else if (zip >= 683 && zip <= 693) return "NE";
		else if (zip >= 700 && zip <= 701) return "LA";
		else if (zip >= 703 && zip <= 708) return "LA";
		else if (zip >= 710 && zip <= 714) return "LA";
		else if (zip >= 716 && zip <= 729) return "AR";
		else if (zip >= 730 && zip <= 731) return "OK";
		else if (zip >= 733 && zip <= 733) return "TX";
		else if (zip >= 734 && zip <= 741) return "OK";
		else if (zip >= 743 && zip <= 749) return "OK";
		else if (zip >= 750 && zip <= 799) return "TX";
		else if (zip >= 800 && zip <= 816) return "CO";
		else if (zip >= 820 && zip <= 831) return "WY";
		else if (zip >= 832 && zip <= 838) return "ID";
		else if (zip >= 840 && zip <= 847) return "UT";
		else if (zip >= 850 && zip <= 850) return "AZ";
		else if (zip >= 852 && zip <= 853) return "AZ";
		else if (zip >= 855 && zip <= 857) return "AZ";
		else if (zip >= 859 && zip <= 860) return "AZ";
		else if (zip >= 863 && zip <= 865) return "AZ";
		else if (zip >= 870 && zip <= 875) return "NM";
		else if (zip >= 877 && zip <= 884) return "NM";
		else if (zip >= 885 && zip <= 885) return "TX";
		else if (zip >= 889 && zip <= 891) return "NV";
		else if (zip >= 893 && zip <= 895) return "NV";
		else if (zip >= 897 && zip <= 898) return "NV";
		else if (zip >= 900 && zip <= 908) return "CA";
		else if (zip >= 910 && zip <= 928) return "CA";
		else if (zip >= 930 && zip <= 961) return "CA";
		else if (zip >= 962 && zip <= 966) return "AP";
		else if (zip >= 967 && zip <= 968) return "HI";
		else if (zip >= 969 && zip <= 969) return "FM";
		else if (zip >= 970 && zip <= 979) return "OR";
		else if (zip >= 980 && zip <= 986) return "WA";
		else if (zip >= 988 && zip <= 994) return "WA";
		else if (zip >= 995 && zip <= 999) return "AK";
		
		return "ERROR";
	}
	
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("zips.txt"));
		try {
		    String line = br.readLine();

		    while (line != null) {
		    	String[] arr = line.split(",");
		        String name = decode(arr[0]);
		        if (!name.equals(arr[1])) {
		        	System.out.println(String.format("Zipcodes: %s, correct: %s, wrong: %s\n", arr[0], arr[1], name));
		        }
		        line = br.readLine();
		    }
		} finally {
		    br.close();
		}
	}
}
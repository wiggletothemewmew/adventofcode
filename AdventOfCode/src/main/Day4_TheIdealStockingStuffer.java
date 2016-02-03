package main;

import java.security.MessageDigest;

/**
 * --- Day 4: The Ideal Stocking Stuffer ---

Santa needs help mining some AdventCoins (very similar to bitcoins) to use as gifts for all the economically forward-thinking little girls and boys.

To do this, he needs to find MD5 hashes which, in hexadecimal, start with at least five zeroes. The input to the MD5 hash is some secret key (your puzzle input, given below) followed by a number in decimal. To mine AdventCoins, you must find Santa the lowest positive number (no leading zeroes: 1, 2, 3, ...) that produces such a hash.

For example:

If your secret key is abcdef, the answer is 609043, because the MD5 hash of abcdef609043 starts with five zeroes (000001dbbfa...), and it is the lowest such number to do so.
If your secret key is pqrstuv, the lowest number it combines with to make an MD5 hash starting with five zeroes is 1048970; that is, the MD5 hash of pqrstuv1048970 looks like 000006136ef....
 *
 */
public class Day4_TheIdealStockingStuffer {	
	/*
	 * Credit for bytesToHexString method: karstens_rage (reddit) 
	 */
	public static String bytesToHexString(byte[] b) throws Exception {
        String result = "";
        for (int i=0; i < b.length; i++) {
            result += Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
        }
        return result;
	}
	
	public static int getIdealMD5HashForSanta(String key, int numOfLeadingZeroes){
		int num = 1;
		String leadingZeroes = new String(new char[numOfLeadingZeroes]).replace("\0", "0");
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			while (true) {
				byte[] hash = digest.digest((key + String.valueOf(num)).getBytes("UTF-8"));
				if (bytesToHexString(hash).startsWith(leadingZeroes)) {
					break;
				}
				num++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
	
	public static void main(String[] args) {
		/*System.out.println("5 leading zeroes: " + getIdealMD5HashForSanta("yzbqklnj", 5));*/
		System.out.println("6 leading zeroes: " + getIdealMD5HashForSanta("yzbqklnj", 6));

	}

}

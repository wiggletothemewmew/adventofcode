package main;

import java.io.IOException;

import reader.File_Reader;

/**
 * --- Day 5: Doesn't He Have Intern-Elves For This? ---

Santa needs help figuring out which strings in his text file are naughty or nice.

A nice string is one with all of the following properties:

It contains at least three vowels (aeiou only), like aei, xazegov, or aeiouaeiouaeiou.
It contains at least one letter that appears twice in a row, like xx, abcdde (dd), or aabbccdd (aa, bb, cc, or dd).
It does not contain the strings ab, cd, pq, or xy, even if they are part of one of the other requirements.
 *
 */
public class Day5_DoesntHeHaveInternElvesForThis {

	public static boolean isNice(String s){
		if (s.length() < 3 || s.matches(".*(ab|cd|pq|xy).*")) return false;
		return s.matches(".*([a-z])\\1.*") && s.replaceAll("[^aeiou]", "").length() > 2;
	}
	
	public static int getNumberOfNiceStrings(String[] input){
		int numOfNice = 0;
		for (String s: input) {
			if (isNice(s)) {System.out.println("Nice: " + s); numOfNice++; } }
		return numOfNice;
	}
	
/**
 * 
 * --- Part Two ---

Realizing the error of his ways, Santa has switched to a better model of determining whether a string is naughty or nice. None of the old rules apply, as they are all clearly ridiculous.

Now, a nice string is one with all of the following properties:

It contains a pair of any two letters that appears at least twice in the string without overlapping, like xyxy (xy) or aabcdefgaa (aa), but not like aaa (aa, but it overlaps).
It contains at least one letter which repeats with exactly one letter between them, like xyx, abcdefeghi (efe), or even aaa.
For example:

qjhvhtzxzqqjkmpb is nice because is has a pair that appears twice (qj) and a letter that repeats with exactly one letter between them (zxz).
xxyxx is nice because it has a pair that appears twice and a letter that repeats with one between, even though the letters used by each rule overlap.
uurcxstgmygtbstg is naughty because it has a pair (tg) but no repeat with a single letter between them.
ieodomkazucvgmuy is naughty because it has a repeating letter with one between (odo), but no pair that appears twice.
How many strings are nice under these new rules?
 */
	
	public static boolean isNicePart2(String s){
		return s.matches(".*?([a-z]{2}).*?\\1.*?") && s.matches(".*?([a-z]).\\1.*");
	}
	
	public static void main(String[] args) {
		try {
			String s = File_Reader.readFile("input/DoesntHeHaveInternElvesForThis.txt");
			String[] s_array = s.split("\n");
			int numOfNice = 0;
			for (String input: s_array) 
				if (isNice(input)) numOfNice++; 
			System.out.println("Number of Nice Strings: "+ numOfNice);
			
			int numOfNice2 = 0;
			for (String input: s_array)
				if (isNicePart2(input)) numOfNice2++;
			System.out.println("Number of Nice Strings Part 2: "+ numOfNice2);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

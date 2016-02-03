package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Day5_DoesntHeHaveInternElvesForThis;

public class Day5_DoesntHeHaveInternElvesForThisTest {

	@Test
	public void test_isNice() {
		assertFalse(Day5_DoesntHeHaveInternElvesForThis.isNice("aa"));
		assertFalse(Day5_DoesntHeHaveInternElvesForThis.isNice("cdab"));
		
		assertTrue(Day5_DoesntHeHaveInternElvesForThis.isNice("ugknbfddgicrmopn"));
		assertTrue(Day5_DoesntHeHaveInternElvesForThis.isNice("aaac"));
		
		assertFalse(Day5_DoesntHeHaveInternElvesForThis.isNice("jchzalrnumimnmhp"));
		assertFalse(Day5_DoesntHeHaveInternElvesForThis.isNice("haegwjzuvuyypxyu"));
		assertFalse(Day5_DoesntHeHaveInternElvesForThis.isNice("dvszwmarrgswjxmb"));
	}
	
	@Test
	public void test_isNicePart2() {
		assertTrue(Day5_DoesntHeHaveInternElvesForThis.isNicePart2("qjhvhtzxzqqjkmpb"));
		assertTrue(Day5_DoesntHeHaveInternElvesForThis.isNicePart2("xxyxx"));
		assertFalse(Day5_DoesntHeHaveInternElvesForThis.isNicePart2("uurcxstgmygtbstg"));
		assertFalse(Day5_DoesntHeHaveInternElvesForThis.isNicePart2("ieodomkazucvgmuy"));
		
	}
}

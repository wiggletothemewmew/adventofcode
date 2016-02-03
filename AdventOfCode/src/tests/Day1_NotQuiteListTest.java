package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Day1_NotQuiteLisp;

public class Day1_NotQuiteListTest {

	@Test
	public void test_followInstructions() {
		int expectedFloor1 = Day1_NotQuiteLisp.findFloor("(())");
		assertEquals(expectedFloor1, 0);
		int expectedFloor2 = Day1_NotQuiteLisp.findFloor("(((");
		assertEquals(expectedFloor2, 3);
	}
	
	@Test
	public void test_getIndexForBasement() {
		int expectedIndex1 = Day1_NotQuiteLisp.getIndexForBasement(")");
		assertEquals(expectedIndex1, 1);
		int expectedIndex2 = Day1_NotQuiteLisp.getIndexForBasement("()())");
		assertEquals(expectedIndex2, 5);
	}

}

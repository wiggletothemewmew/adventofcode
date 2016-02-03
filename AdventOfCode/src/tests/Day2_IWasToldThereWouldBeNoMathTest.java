package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Day2_IWasToldThereWouldBeNoMath;

public class Day2_IWasToldThereWouldBeNoMathTest {

	@Test
	public void test_getTotalSqFtWrappingPaper2Order() {
		int expected1 = Day2_IWasToldThereWouldBeNoMath.getTotalSqFtWrappingPaper2Order("2x3x4");
		assertEquals(expected1, 58);
		int expected2 = Day2_IWasToldThereWouldBeNoMath.getTotalSqFtWrappingPaper2Order("2x3x4\n1x1x10");
		assertEquals(expected2, 101);
	}
	
	@Test
	public void test_getTotalLengthOfRibbon(){
		int expected1 = Day2_IWasToldThereWouldBeNoMath.getTotalLengthOfRibbon("2x3x4");
		assertEquals(expected1, 34);
		int expected2 = Day2_IWasToldThereWouldBeNoMath.getTotalLengthOfRibbon("2x3x4\n1x1x10");
		assertEquals(expected2, 48);
	}

}

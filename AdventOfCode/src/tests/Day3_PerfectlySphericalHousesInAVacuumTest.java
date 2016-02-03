package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Day3_PerfectlySphericalHousesInAVacuum;

public class Day3_PerfectlySphericalHousesInAVacuumTest {

	@Test
	public void test_getNumberOfHousesVisitedBySantaOnly() {
		int expected1 = Day3_PerfectlySphericalHousesInAVacuum.getNumberOfHousesVisitedBySantaOnly(">");
		assertEquals(expected1, 2);
		int expected2 = Day3_PerfectlySphericalHousesInAVacuum.getNumberOfHousesVisitedBySantaOnly("^>v<");
		assertEquals(expected2, 4);
		int expected3 = Day3_PerfectlySphericalHousesInAVacuum.getNumberOfHousesVisitedBySantaOnly("^v^v^v^v^v");
		assertEquals(expected3, 2);
	}
	
	@Test
	public void test_getNumberOfHousesVisitedBySantaAndRoboSanta() {
		int expected1 = Day3_PerfectlySphericalHousesInAVacuum.getNumberOfHousesVisitedBySantaAndRoboSanta("^v");
		assertEquals(expected1, 3);
		int expected2 = Day3_PerfectlySphericalHousesInAVacuum.getNumberOfHousesVisitedBySantaAndRoboSanta("^>v<");
		assertEquals(expected2, 3);
		int expected3 = Day3_PerfectlySphericalHousesInAVacuum.getNumberOfHousesVisitedBySantaAndRoboSanta("^v^v^v^v^v");
		assertEquals(expected3, 11);
	}

}

package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Day6_ProbabyAFireHazard;

public class Day6_ProbabyAFireHazardTest {

	@Test
	public void test_getNumberOfLightsToTurnOn() {
		assertEquals(Day6_ProbabyAFireHazard.getNumberOfLightsToTurnOn(new String[]{"turn on 0,0 through 999,999"}), 1000000);
		assertEquals(Day6_ProbabyAFireHazard.getNumberOfLightsToTurnOn(
				new String[]{"turn on 0,0 through 999,999", "toggle 0,0 through 999,0"}
		), 999000);
		assertEquals(Day6_ProbabyAFireHazard.getNumberOfLightsToTurnOn(
				new String[]{"turn on 0,0 through 999,999", "turn off 0,1 through 0, 10", "toggle 0,0 through 999,0"}
		), 998990);
	
	}
	
	@Test
	public void test_getTotalBrightness(){
		assertEquals(Day6_ProbabyAFireHazard.getTotalBrightness(new String[]{"turn on 0,0 through 0,0"}), 1);
		assertEquals(Day6_ProbabyAFireHazard.getTotalBrightness(new String[]{"turn on 0,0 through 0,0", "turn off 0,0 through 0,0"}), 0);
		assertEquals(Day6_ProbabyAFireHazard.getTotalBrightness(new String[]{"turn on 0,0 through 0,0", "turn off 0,0 through 0,0", "turn off 0,0 through 0,0"}), 0);
		assertEquals(Day6_ProbabyAFireHazard.getTotalBrightness(new String[]{"toggle 0,0 through 999,999"}), 2000000);
	}

}

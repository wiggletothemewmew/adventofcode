package main;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import reader.File_Reader;

/**
 * --- Day 6: Probably a Fire Hazard ---

Because your neighbors keep defeating you in the holiday house decorating contest year after year, you've decided to deploy one million lights in a 1000x1000 grid.

Furthermore, because you've been especially nice this year, Santa has mailed you instructions on how to display the ideal lighting configuration.

Lights in your grid are numbered from 0 to 999 in each direction; the lights at each corner are at 0,0, 0,999, 999,999, and 999,0. The instructions include whether to turn on, turn off, or toggle various inclusive ranges given as coordinate pairs. Each coordinate pair represents opposite corners of a rectangle, inclusive; a coordinate pair like 0,0 through 2,2 therefore refers to 9 lights in a 3x3 square. The lights all start turned off.

To defeat your neighbors this year, all you have to do is set up your lights by doing the instructions Santa sent you in order.

For example:

turn on 0,0 through 999,999 would turn on (or leave on) every light.
toggle 0,0 through 999,0 would toggle the first line of 1000 lights, turning off the ones that were on, and turning on the ones that were off.
turn off 499,499 through 500,500 would turn off (or leave off) the middle four lights.
After following the instructions, how many lights are lit?
 *
 */
public class Day6_ProbabyAFireHazard {

	public static int[] getCoordinates(String instruction, Pattern pattern){
		Matcher coordinatesMatcher = pattern.matcher(instruction);
		int[] coordinates = new int[4];
		int i = 0;
		while (coordinatesMatcher.find()){
			coordinates[i] = Integer.parseInt(coordinatesMatcher.group());
			i++;
		}
		return coordinates;
	}
	
	public static int getNumberOfLightsToTurnOn(String[] instructions){
		Pattern coordinatesPattern = Pattern.compile("[0-9]+");
		int[][] grid = new int[1000][1000];
		int lightsOn = 0;
		for (String s: instructions){
			int[] coordinates = getCoordinates(s, coordinatesPattern);
			int startX = coordinates[0], startY = coordinates[1], endX = coordinates[2], endY = coordinates[3];
			for (int x=startX; x <= endX; x++){
				for(int y=startY; y <= endY; y++){
					if (grid[x][y]==0 && (s.matches("turn on.*") || (s.matches("toggle.*")))){
						grid[x][y] = 1; lightsOn++;
					}
					else if (grid[x][y]==1 && (s.matches("turn off.*") || (s.matches("toggle.*")))){
						grid[x][y] = 0; lightsOn--;
					}
				}
			}
			
		}
		return lightsOn;
	}
	
	public static int getTotalBrightness(String instructions[]){
		Pattern coordinatesPattern = Pattern.compile("[0-9]+");
		int[][] grid = new int[1000][1000];
		int totalBrightness = 0;
		for (String s: instructions){
			int[] coordinates = getCoordinates(s, coordinatesPattern);
			int startX = coordinates[0], startY = coordinates[1], endX = coordinates[2], endY = coordinates[3];
			for (int x=startX; x <= endX; x++){
				for(int y=startY; y <= endY; y++){
					if (s.matches("turn on.*")){
						grid[x][y]++; totalBrightness++;
					}
					else if (s.matches("toggle.*")) {
						grid[x][y] +=2; totalBrightness += 2;
					}
					else if (s.matches("turn off.*") && grid[x][y]>0){
						grid[x][y]--; totalBrightness--;
					}
				}
			}
		}
		return totalBrightness;
	}
	
	public static void main(String[] args) {
		try {
			String input = File_Reader.readFile("input/ProbabyAFireHazard.txt");
			String[] instructions = input.split("[x\n]");
//			System.out.println("Number of Lights to Turn On: " + getNumberOfLightsToTurnOn(instructions));
			System.out.print("Total brightness: " + getTotalBrightness(instructions));	
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

package main;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import reader.File_Reader;

/**
 * --- Day 3: Perfectly Spherical Houses in a Vacuum ---

Santa is delivering presents to an infinite two-dimensional grid of houses.

He begins by delivering a present to the house at his starting location, and then an elf at the North Pole calls him via radio and tells him where to move next. Moves are always exactly one house to the north (^), south (v), east (>), or west (<). After each move, he delivers another present to the house at his new location.

However, the elf back at the north pole has had a little too much eggnog, and so his directions are a little off, and Santa ends up visiting some houses more than once. How many houses receive at least one present?

For example:

> delivers presents to 2 houses: one at the starting location, and one to the east.
^>v< delivers presents to 4 houses in a square, including twice to the house at his starting/ending location.
^v^v^v^v^v delivers a bunch of presents to some very lucky children at only 2 houses.
 *
 */
class Coordinates {
	int x; int y;
	
	Coordinates(int x, int y){
		this.x = x;
		this.y = y;
	}
	public boolean equals(Object o){
		Coordinates c = (Coordinates)o;
		return c.x == x && c.y == y;
	}
	public int hashCode(){
		return x+y;
	}
	
}

public class Day3_PerfectlySphericalHousesInAVacuum {

	public static int getNumberOfHousesVisitedBySantaOnly(String input) {
		char[] char_input = input.toCharArray();
		int x_axis = 0, y_axis = 0;
		Set<Coordinates> houseCoordinates = new HashSet<Coordinates>();
		houseCoordinates.add(new Coordinates(x_axis, y_axis));
		for (char c: char_input){
			/*switch (c){
			case '^': y_axis++; break;
			case 'v': y_axis--; break;
			case '>': x_axis++; break;
			case '<': x_axis--;
			}*/
			
			// Contrary to popular belief, if/else seems to perform faster here
			// if/else: 18 milliseconds vs switch case: 21 milliseconds
			if (c=='^') y_axis++;
			else if (c=='v') y_axis--;
			else if (c=='>') x_axis++;
			else if (c=='<') x_axis--;
			houseCoordinates.add(new Coordinates(x_axis, y_axis));
		}
		return houseCoordinates.size();
	}
	
	/**
	 *--- Part Two ---

	The next year, to speed up the process, Santa creates a robot version of himself, Robo-Santa, to deliver presents with him.

	Santa and Robo-Santa start at the same location (delivering two presents to the same starting house), then take turns moving based on instructions from the elf, who is eggnoggedly reading from the same script as the previous year.

	This year, how many houses receive at least one present?

	For example:

	^v delivers presents to 3 houses, because Santa goes north, and then Robo-Santa goes south.
	^>v< now delivers presents to 3 houses, and Santa and Robo-Santa end up back where they started.
	^v^v^v^v^v now delivers presents to 11 houses, with Santa going one direction and Robo-Santa going the other.
	 *
	 */
	
	public static int getNumberOfHousesVisitedBySantaAndRoboSanta(String input){
		char[] char_input = input.toCharArray();
		int x_axis_santa = 0, y_axis_santa = 0, x_axis_robo = 0, y_axis_robo = 0;
		Set<Coordinates> houseCoordinates = new HashSet<Coordinates>();
		houseCoordinates.add(new Coordinates(0, 0));
		for (int i=0; i < char_input.length; i++){
			char c = char_input[i];
			
			if (i%2==0){
				if (c=='^') y_axis_santa++;
				else if (c=='v') y_axis_santa--;
				else if (c=='>') x_axis_santa++;
				else if (c=='<') x_axis_santa--;
				houseCoordinates.add(new Coordinates(x_axis_santa, y_axis_santa));
			}
			else {
				if (c=='^') y_axis_robo++;
				else if (c=='v') y_axis_robo--;
				else if (c=='>') x_axis_robo++;
				else if (c=='<') x_axis_robo--;
				houseCoordinates.add(new Coordinates(x_axis_robo, y_axis_robo));
			}
		}
		return houseCoordinates.size();
	}
	
	public static void main(String[] args) {
		try {
			String s = File_Reader.readFile("input/PerfectlySphericalHousesInAVacuum.txt");
			/*long startTime = System.currentTimeMillis();*/
			System.out.println("Number of Houses Visited By Santa Only: " + getNumberOfHousesVisitedBySantaOnly(s));
			/*long endTime   = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			System.out.println(totalTime);*/
			System.out.println("Number of Houses Visited By Santa & Robo-Santa: " + getNumberOfHousesVisitedBySantaAndRoboSanta(s));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

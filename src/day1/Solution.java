package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.Math.abs;

/**
 * Day 1: No Time for a Taxicab
 *
 * Copy and Paste your inputs into data.txt or just pass them as a String
 */
public class Solution {

    public static void main(String[] args) {
        try {
            String[] data = parseDataFile("src/day1/data.txt");

            // String[] data = parseDataString({yourInputsHere});

            System.out.println(calculateDistanceFromStart(data));
        } catch (IOException e) { // As File reader can fail
            e.printStackTrace();
        }
    }

    /**
     * Calculate distance traveled for a given Array of Strings
     * @param data Array of Strings
     * @return Travel distance
     */
    private static int calculateDistanceFromStart(String[] data) {
        int facing = 0; // Determines which direction you are facing. 0 = North, 1 = East, 2 = South , 3 = West
        int[] coords = new int[] {0, 0}; // Starting position, always 0, 0
        int parseDistance; // Used to get the integer part of the data

        for (String s : data) {
            // Did we go Right or left?
            if (s.charAt(0) == 'R')
                facing += 5; // Rotate clockwise ( 1 + 4)
            else
                facing += 3; // Rotate anti-clockwise ( -1 + 4)


            parseDistance = Integer.parseInt(s.substring(1)); // Get the distance part of the String
            switch (facing % 4) { // Mod positive number by 4 to get NESW value
                case 0: // Case of North, move Y coord in positive direction
                    coords[1] += parseDistance;
                    break;
                case 1: // Case of East, move X coord in positive direction
                    coords[0] += parseDistance;
                    break;
                case 2: // Case of South, move Y coord in negative direction
                    coords[1] -= parseDistance;
                    break;
                case 3: // Case of West, move X coord in negative direction
                    coords[0] -= parseDistance;
                    break;
            }
        }
        return (abs(coords[0]) + abs(coords[1])); // Add total of X + Y (positive) to get distance traveled, since city grid system is 1, 1 movements all we need to do is total X Y
    }

    /**
     * Simple method to convert the inputs from a String to an Array of Strings. Use parseDataFile if you want to pass
     * inputs as a file
     * @param data String of data
     * @return parsed data
     */
    private static String[] parseDataString(String data) {
        return data.split(", ");
    }

    /**
     * Simple method to just parse a txt file containing all your data for the challenge
     * @param path - Path relative to the directory that contains your directions
     * @return - An Array of Strings containing all your directions with commas and white space removed
     * @throws IOException Throw Exception to the top layer of logic
     */
    private static String[] parseDataFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path)); // Simple bufferedReader to take in your data.
        String data = br.readLine(); // Read the file and remove all whitespace.
        String[] parsedData = data.split(", "); // Split the string after all commas.
        br.close(); // Ensure you close the BufferedReader.
        return parsedData;
    }
}

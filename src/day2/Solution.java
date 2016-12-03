package day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Day 2: Bathroom Security
 *
 * Just paste your inputs into data.txt
 */
public class Solution {

    // Used to represent the number pad in part 1 of the challenge
    private static int[][] numberPad = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };

    // Used to represent the key pad in part 2 of the challenge
    private static String[][] keyPad = {
            {null, null, "1", null, null},
            {null, "2", "3", "4", null},
            {"5", "6", "7", "8", "9"},
            {null, "A", "B", "C", null},
            {null, null, "D", null, null}
    };

    public static void main(String[] args) {
        try {
            List<String> data = parseDataFile("src/day2/data.txt");
            List<Integer> firstAns = computeFirstPartKeyPad(data);
            System.out.println("Part 1 = \n" + firstAns);

            List<String> secondAns = computeSecondPartKeyPad(data);
            System.out.println("Part 2 = \n" + secondAns);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Second part: computes the instructions and returns a List of keys to press in order
     * @param data Instructions from the data.txt
     * @return List of keys
     */
    private static List<String> computeSecondPartKeyPad(List<String> data) {
        int column = 0; // Starting point
        int row = 2; // Starting point
        List<String> ans = new ArrayList<>();
        for (String s : data) {
            List<Object> x = computeStringForInstructions(column, row, s);
            ans.add((String) x.get(0));
            row = (int) x.get(1);
            column = (int) x.get(2);
        }
        return ans;
    }

    /**
     * First part: computes the instructions and returns a List of Integers to press in order
     * @param data Instructions from the data.txt
     * @return List of Integers
     */
    private static List<Integer> computeFirstPartKeyPad(List<String> data) {
        int column = 1; // Starting point
        int row = 1; // Starting point
        List<Integer> ans = new ArrayList<>();
        for (String s : data) {
            int[] x = computeNumberForInstructions(column, row, s);
            ans.add(x[0]);
            row = x[1];
            column = x[2];
        }
        return ans;
    }

    /**
     * Compute instructions for the String key pad, return a List of Objects so that we can return the String we found
     * and also the new row and column to start from for the next line of instructions
     * @param row row to start on
     * @param column column to start on
     * @param instructions line of instructions
     * @return List of objects containing the final key and the position of that key
     */
    private static List<Object> computeStringForInstructions(int row, int column, String instructions) {
        for (int i = 0; i < instructions.length(); ++i) {
            switch (instructions.charAt(i)) {
                case 'U':
                    if (row != 0 && keyPad[row - 1][column] != null)
                        --row;
                    break;
                case 'D':
                    if (row != 4 && keyPad[row + 1][column] != null)
                        ++row;
                    break;
                case 'L':
                    if (column != 0 && keyPad[row][column - 1] != null)
                        --column;
                    break;
                case 'R':
                    if (column != 4 && keyPad[row][column + 1] != null)
                        ++column;
                    break;
            }
        }
        List<Object> result = new ArrayList<>();
        result.add(keyPad[row][column]);
        result.add(row);
        result.add(column);

        return result;
    }

    /**
     * Compute instructions for the Int number pad, return a List of Integers with the value of the key and position
     * of that key we press
     * @param row row to start on
     * @param column column to start on
     * @param instructions line of instructions
     * @return Array of ints [1][2] containing row,column position of last step and [0] with the value we landed on
     */
    private static int[] computeNumberForInstructions(int row, int column, String instructions) {
        for (int i = 0; i < instructions.length(); ++i) {
            switch (instructions.charAt(i)) {
                case 'U':
                    if (row != 0)
                        --row;
                    break;
                case 'D':
                    if (row != 2)
                        ++row;
                    break;
                case 'L':
                    if (column != 0)
                        --column;
                    break;
                case 'R':
                    if (column != 2)
                        ++column;
                    break;
            }
        }
        return new int[] {numberPad[row][column], row, column};
    }

    /**
     * Simple method to just parse a txt file containing all your data for the challenge
     *
     * @param path - Path relative to the directory that contains your directions
     * @return - An List of Strings which each String contains instructions for one digit.
     * @throws IOException Throw Exception to the top layer of logic
     */
    private static List<String> parseDataFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path)); // Simple bufferedReader to take in your data.
        List<String> list = new ArrayList<>();
        String data;
        while((data = br.readLine()) != null) {
            list.add(data);
        }
        br.close(); // Ensure you close the BufferedReader.
        return list;
    }
}

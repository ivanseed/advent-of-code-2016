package day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Day 3: Squares With Three Sides
 *
 * Just paste your inputs into data.txt
 */
public class Solution {

    public static void main(String[] args) {
        try {
            List<Integer[]> data = parseDataFile("src/day3/data.txt");

            System.out.println("Part 1 = " + countValidTrianglesInRow(data));
            System.out.println("Part 2 = " + countValidTrianglesInColumn(data));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Computes the count of valid triangles for data in a row, by validating that no two sides are less than the
     * remaining side.
     * @param data List of Integer Arrays which contain the 3 sides
     * @return total count of valid triangles
     */
    private static int countValidTrianglesInRow(List<Integer[]> data) {
        int counter = 0;
        for (Integer[] triangle : data) {
            if (triangle[0] + triangle[1] > triangle[2] &&
                    triangle[1] + triangle[2] > triangle[0] &&
                    triangle[0] + triangle[2] > triangle[1]) {
                ++counter;
            }
        }
        return counter;
    }

    /**
     * Computes the count of valid triangles for data in a column, the difference is that it goes down the columns
     * rather than across the rows
     * @param data List of Integer Arrays which contain the 3 sides
     * @return total count of valid triangles
     */
    private static int countValidTrianglesInColumn(List<Integer[]> data) {
        int counter = 0;
        for (int i = 0; i < data.size(); i += 3) {
            for (int y = 0; y < 3; ++y) {
                if (data.get(i)[y] + data.get(i + 1)[y] > data.get(i + 2)[y] &&
                        data.get(i + 1)[y] + data.get(i + 2)[y] > data.get(i)[y] &&
                        data.get(i)[y] + data.get(i + 2)[y] > data.get(i + 1)[y]) {
                    ++counter;
                }
            }
        }
        return counter;
    }

    /**
     * Simple method to just parse a txt file containing all your data for the challenge
     *
     * @param path - Path relative to the directory that contains your triangle data
     * @return - A list of Integer arrays of size 3, containing the lengths of triangles.
     * @throws IOException Throw Exception to the top layer of logic
     */
    private static List<Integer[]> parseDataFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path)); // Simple bufferedReader to take in your data.
        List<Integer[]> list = new ArrayList<>();
        String data;
        while((data = br.readLine()) != null) {
            Integer[] parsedData = new Integer[3];
            String[] splitArray = data.split("\\s+");
            int i = 0;
            for (String s : splitArray) {
                if (!s.equals("")) {
                    parsedData[i] = Integer.parseInt(s);
                    ++i;
                }
            }
            list.add(parsedData);
        }
        br.close(); // Ensure you close the BufferedReader.
        return list;
    }
}

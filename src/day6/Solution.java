package day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Day 6: Signals and Noise
 *
 * Just paste your inputs into data.txt
 *
 * Couldn't be bothered to remove duplicated code ^^
 *
 * Probably a better way to search through the map but I
 * have been extremely busy as of late :(
 */
public class Solution {

    public static void main(String[] args) {
        try {
            List<char[]> data = parseDataFile("src/day6/data.txt");

            System.out.println("Part 1" + calculateErrorCorrectMostCommon(data));
            System.out.println("Part 2" + calculateErrorCorrectLeastCommon(data));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private static List<Character> calculateErrorCorrectMostCommon(List<char[]> data) {
        List<Character> ans = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        int max = 0;
        Character maxC = null;
        for (int i = 0; i < data.get(0).length; ++i) {
            map.clear();
            for (char[] aData : data) {
                char c = aData[i];
                Integer val = map.get(c);
                if (val != null)
                    map.put(c, val + 1);
                else
                    map.put(c, 1);
            }
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (max < entry.getValue()) {
                    max = entry.getValue();
                    maxC = entry.getKey();
                }
            }
            max = 0;
            ans.add(maxC);
        }
        return ans;
    }

    private static List<Character> calculateErrorCorrectLeastCommon(List<char[]> data) {
        List<Character> ans = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        Character maxC = null;
        for (int i = 0; i < data.get(0).length; ++i) {
            map.clear();
            for (char[] aData : data) {
                char c = aData[i];
                Integer val = map.get(c);
                if (val != null)
                    map.put(c, val + 1);
                else
                    map.put(c, 1);
            }
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (min > entry.getValue()) {
                    min = entry.getValue();
                    maxC = entry.getKey();
                }
            }
            min = Integer.MAX_VALUE;
            ans.add(maxC);
        }
        return ans;
    }

    /**
     * Simple method to just parse a txt file containing all your data for the challenge
     *
     * @param path - Path relative to the directory that contains your directions
     * @return - An List of Strings which room names
     * @throws IOException Throw Exception to the top layer of logic
     */
    private static List<char[]> parseDataFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path)); // Simple bufferedReader to take in your data.
        List<char[]> list = new ArrayList<>();
        String data;
        while((data = br.readLine()) != null) {
            list.add(data.toCharArray());
        }
        br.close(); // Ensure you close the BufferedReader.
        return list;
    }
}

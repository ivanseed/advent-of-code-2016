package day5;

/**
 * Day 5: How About a Nice Game of Chess?
 */
public class Solution {

    // Avoid rebuilding stringBuilder
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        System.out.println(calculatePassword("wtnhxymk"));
    }

    private static String calculatePassword(String data) {
        char[] password = new char[]{
            '-', '-','-','-','-','-','-','-'
        };
        boolean isValid;
        int offset = 0;
        String hash;

        while(offset < 100000000) {
            hash = calculateMD5Hash(data + offset);
            isValid = true;

            assert hash != null;
            if (!hash.startsWith("00000"))
                isValid = false;

            if (isValid) {
                // System.out.println(hash); // Uncomment this if you need the first 5 hashes for part 1
                char c = hash.charAt(5);
                if (Character.isDigit(c) && Character.getNumericValue(c) < 8 &&
                        password[Character.getNumericValue(c)] == '-') {
                    password[Character.getNumericValue(c)] = hash.charAt(6);
                    for (char p : password) {
                        if (p == '-')
                            isValid = false;
                    }
                    if (isValid)
                        return new String(password);
                }
            }
            ++offset;
        }
        return null;
    }

    private static String calculateMD5Hash(String input) {
        try {
            stringBuilder.setLength(0);
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] hex = md.digest(input.getBytes("UTF-8"));
            for (byte b : hex) {
                stringBuilder.append(String.format("%02x", b));
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}

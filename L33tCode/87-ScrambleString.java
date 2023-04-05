import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

class Solution {
    public boolean isScramble(String s1, String s2) {
        // We can scramble a string using the following algorithm:
        // if the length of the string is 1, then stop
        // If the length of the string is > 1, do the following:
            // Split the string into two non-empty substrings at a random index, i.e., if the string is s, divide it to x and y where s = x + y.
            // Randomly decide to swap the two substrings or to keep them in the same order. i.e., after this step, s may become s = x + y or s = y + x.
            // Apply step 1 recursively on each of the two substrings x and y.
        // Given two strings s1 and s2 of the same length, return true if s2 is a scrambled string of s1, otherwise, return false.
        // First, check if the two strings are equal
        if (s1.equals(s2)) {
            return true;
        }
        // Next, check if the two strings are anagrams
        int[] charCount = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            charCount[s1.charAt(i) - 'a']++;
            charCount[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (charCount[i] != 0) {
                return false;
            }
        }
        // Next, check if the two strings are scrambled
        for (int i = 1; i < s1.length(); i++) {
            // Check if the two strings are scrambled
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            // Check if the two strings are scrambled
            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) {
                return true;
            }
        }
        return false;
    }

    public boolean isScramble2(String s1, String s2) {
        // First, check if the two strings are equal
        if (s1.equals(s2)) {
            return true;
        }
        // Next, check if the two strings are anagrams
        int[] charCount = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            charCount[s1.charAt(i) - 'a']++;
            charCount[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (charCount[i] != 0) {
                return false;
            }
        }
        // Next, check if the two strings are scrambled

        // create a memoization table
        int n = s1.length();
        boolean[][][] memo = new boolean[n][n][n + 1];
        // initialize the memoization table

        // fill the memoization table
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                for (int k = 1; k <= n - Math.max(i, j); k++) {
                    if (s1.substring(i, i + k).equals(s2.substring(j, j + k))) {
                        memo[i][j][k] = true;
                    } else {
                        for (int l = 1; l < k; l++) {
                            if ((memo[i][j][l] && memo[i + l][j + l][k - l]) || (memo[i][j + k - l][l] && memo[i + l][j][k - l])) {
                                memo[i][j][k] = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return memo[0][0][n];

    }

    Map<String, Boolean> map = new HashMap<>();

    public boolean isScramble3(String s1, String s2) {
        int n = s1.length();
        // check if the two strings are equal
        if (s1.equals(s2)) {
            return true;
        }
        // initialize frequency arrays for s1, s2, and current substring
        int[] a = new int[26], b = new int[26], c = new int[26];
        // check if the current substring has already been computed
        if (map.containsKey(s1 + s2)) {
            return map.get(s1 + s2);
        }
        // check all possible splits of the two strings
        for (int i = 1; i <= n - 1; i++) {
            int j = n - i;
            // update frequency arrays for s1, s2, and current substring
            a[s1.charAt(i - 1) - 'a']++;
            b[s2.charAt(i - 1) - 'a']++;
            c[s2.charAt(j) - 'a']++;
            // check if the current substring has the same characters
            if (Arrays.equals(a, b) && isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) {
                // if the substrings are scrambled versions of each other, return true
                map.put(s1 + s2, true);
                return true;
            }
            // check if the current substring and its complement have the same characters
            if (Arrays.equals(a, c) && isScramble(s1.substring(0, i), s2.substring(j)) && isScramble(s1.substring(i), s2.substring(0, j))) {
                // if the substrings are scrambled versions of each other, return true
                map.put(s1 + s2, true);
                return true;
            }
        }
        // if none of the splits result in scrambled versions, return false
        map.put(s1 + s2, false);
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isScramble3("great", "rgeat"));
        System.out.println(solution.isScramble3("abcde", "caebd"));
        System.out.println(solution.isScramble3("a", "a"));
    }
}
import java.util.Arrays;

/** 
You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti.
A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.
Return the length longest chain which can be formed.
You do not need to use up all the given intervals. You can select pairs in any order.
*/

class Solution {
    public int findLongestChain(int[][] pairs) {
        // Sort by the end of the pair
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
        
        // Greedy Algorithm
        int count = 0;
        int end = Integer.MIN_VALUE;
        
        for (int[] pair : pairs) {
            if (pair[0] > end) {
                count++;
                end = pair[1];
            }
        }
        
        return count;
    }
}
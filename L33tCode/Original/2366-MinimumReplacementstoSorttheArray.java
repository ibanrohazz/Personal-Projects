/** 
 * Problem: https://leetcode.com/problems/minimum-replacements-to-sort-the-array/
 * You are given a 0-indexed integer array nums. In one operation you can replace any element of the array with any two elements that sum to it.
 * For example, consider nums = [5,6,7]. In one operation, we can replace nums[1] with 2 and 4 and convert nums to [5,2,4,7].
 * Return the minimum number of operations to make an array that is sorted in non-decreasing order.
 */

class Solution {
    public long minimumReplacement( int[] nums ) {
        int n = nums.length;
        int last = nums[ n - 1 ];
        long result = 0;
        for (int i = n - 2; i >= 0; --i ) {
            if ( nums[ i ] > last ) {
                int t = nums[i] / last;
                if ( nums[ i ] % last != 0 ) {
                    t++;
                }
                last = nums[ i ] / t;
                result += t - 1;
            } else {
                last = nums[ i ];
            }
        }
        return result;
    }
}
/**
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), 
 * ans[i] is the number of 1's in the binary representation of i.
 */

class Solution {
    public int[] countBits(int n) {
        int[] result = new int[ n + 1 ];
        result[ 0 ] = 0;
        for ( int i = 1; i <= n; ++i ) {
            // Bitwise AND of i and i - 1 will remove the last set bit from i
            result[ i ] = result[ i / 2 ] + i % 2;
        }
        return result;    
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] result = s.countBits( 5 );
        for ( int i = 0; i < result.length; ++i ) {
            System.out.println( result[ i ] );
        }   
    }
}
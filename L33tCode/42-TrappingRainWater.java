class Solution {
    public int trap(int[] height) {
        // given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
        // 1. find the highest bar
        // 2. from left to right, find the highest bar on the left of the current bar
        // 3. from right to left, find the highest bar on the right of the current bar
        // 4. the water trapped by the current bar is the min of the two highest bars on the left and right minus the height of the current bar
        // 5. sum up the water trapped by each bar
        int n = height.length;
        if( n == 0 ) {
            return 0;
        }
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = height[0];
        right[n - 1] = height[n - 1];
        for( int i = 1; i < n; i++ ) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        for( int i = n - 2; i >= 0; i-- ) {
            right[i] = Math.max(right[i + 1], height[i]);
        }
        int sum = 0;
        for( int i = 0; i < n; i++ ) {
            sum += Math.min(left[i], right[i]) - height[i];
        }
        return sum;
    }
}
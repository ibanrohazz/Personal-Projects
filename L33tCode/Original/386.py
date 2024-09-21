""" 
09/21/2023 Leetcode 386

You must write an algorithm that runs in O(n) time and uses O(1) extra space. 

Example 1:
Input: n = 13
Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]

Example 2:
Input: n = 2
Output: [1,2]
 
Constraints:
1 <= n <= 5 * 104
"""

class Solution (object):
    def lexicalOrder (self, n):
        """ 
        :type n: int
        :rtype: List[int]
        """
        # Initialize the result list
        res = []
        # Start from 1
        curr = 1
        
        for i in range(n):
            # Add the current number to the result
            res.append(curr)
            # If the current number is less than n * 10
            if curr * 10 <= n:
                # Multiply the current number by 10
                curr *= 10
            # Otherwise
            else:
                # If the current number is greater than or equal to n
                if curr >= n:
                    # Divide the current number by 10
                    curr //= 10
                # Increment the current number by 1
                curr += 1
                # While the current number is divisible by 10
                while curr % 10 == 0:
                    # Divide the current number by 10
                    curr //= 10
                    
        return res
    
        
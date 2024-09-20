""" 
You are given a string s. You can convert s to a 
palindrome
 by adding characters in front of it.

Return the shortest palindrome you can find by performing this transformation.

 

Example 1:

Input: s = "aacecaaa"
Output: "aaacecaaa"
Example 2:

Input: s = "abcd"
Output: "dcbabcd"
 

Constraints:

0 <= s.length <= 5 * 104
s consists of lowercase English letters only.
"""

class Solution (object):
    def shortestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        n = len(s) 
        if n == 0:
            return ""
        rev = s[::-1] # reverse the string
        for i in range(n): # find the longest palindrome substring starting from the beginning
            if s[:n-i] == rev[i:]: # if the substring is a palindrome
                return rev[:i] + s
        return ""
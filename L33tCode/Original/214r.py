""" 
Revised Solution for daily leetcode problem 214
"""

class Solution (object):
    def shortestPalindrome(self, s):
        """
        This function returns the shortest palindrome you can find by performing this transformation.
        :type s: str
        :rtype: str
        """
        n = len(s)
        i = 0
        for j in range(n - 1, -1, -1): # uses two pointers to find the longest palindrome substring starting from the beginning
            if s[i] == s[j]: # if the two pointers are equal that means the substring is a palindrome
                i += 1
        if i == n:
            return s
        remain_rev = s[i:][::-1] # reverse the remaining string
        return remain_rev + self.shortestPalindrome(s[:i]) + s[i:] # recursively call the function to find the shortest palindrome
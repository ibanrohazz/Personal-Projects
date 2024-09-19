""" 
Given a string expression of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. You may return the answer in any order.

The test cases are generated such that the output values fit in a 32-bit integer and the number of different results does not exceed 104.

 

Example 1:

Input: expression = "2-1-1"
Output: [0,2]
Explanation:
((2-1)-1) = 0 
(2-(1-1)) = 2
Example 2:

Input: expression = "2*3-4*5"
Output: [-34,-14,-10,-10,10]
Explanation:
(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10
 

Constraints:

1 <= expression.length <= 20
expression consists of digits and the operator '+', '-', and '*'.
All the integer values in the input expression are in the range [0, 99].
The integer values in the input expression do not have a leading '-' or '+' denoting the sign.
"""

class Solution (object): 
    def diffWaysToCompute(self, expression): 
        """
        :type expression: str
        :rtype: List[int]
        """
        if expression.isdigit(): # if the expression is a number, return the number
            return [int(expression)] 
        res = [] 
        for i in range(len(expression)):  # split the expression by operator
            if expression[i] in "+-*": 
                res1 = self.diffWaysToCompute(expression[:i]) 
                res2 = self.diffWaysToCompute(expression[i+1:]) 
                for j in res1: 
                    for k in res2: 
                        if expression[i] == "+": 
                            res.append(j+k) 
                        elif expression[i] == "-": 
                            res.append(j-k) 
                        else: 
                            res.append(j*k)
        return res
    
if __name__ == "__main__":
    expression = "2-1-1"
    print(Solution().diffWaysToCompute(expression)) # [0, 2]
    expression = "2*3-4*5"
    print(Solution().diffWaysToCompute(expression)) # [-34, -14, -10, -10, 10]
    expression = "2+3"
    print(Solution().diffWaysToCompute(expression)) # [5]
    expression = "2-3"
    print(Solution().diffWaysToCompute(expression)) # [-1]
    expression = "2*3"
    print(Solution().diffWaysToCompute(expression)) # [6]
    expression = "2+3+4"
    print(Solution().diffWaysToCompute(expression)) # [9, 5]
    expression = "2-3-4"
    print(Solution().diffWaysToCompute(expression)) # [-5, -9]
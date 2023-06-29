#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int maxArea(vector<int>& height) {
        // return variable and the length of the array
       int ans = 0, n = height.size();
       // current index and end index
       int i = 0, j = n-1;
       while( i < j ) {
        // compares the front and the end simultaneously
           if( height[ i ] > height[ j ] ) {
               ans = max( ans, ( j - i ) * height[ j ]);
               j--;
           }
           else{
               ans = max( ans, ( j - i ) * height[ i ] );
               i++;
           }
       }
       return ans;
    }

};
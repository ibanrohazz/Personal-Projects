#include <stdio.h>;
#include <iostream>;
#include <vector>;
#include <string>;
#include <algorithm>;
using namespace std;


/** 
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
 * Each solution contains a distinct board configuration of the n-queens' placement,
 */
class Solution {
public:
    vector<vector<string>> solveNQueens( int n ) {
        vector<string> arr;
        string curr;
        vector<vector<string>> res;
        for( int i = 0; i < n; i++ ) {
            curr += '.';
        }
        for( int i = 0; i < n; i++ ) {
            arr.push_back( curr );
        }

        dfs( 0, 0, n, arr, res );

        return res;
    }

    void dfs( int index, int count, int n, vector<string> arr, vector<vector<string>> &res ) {
        if( count == n ){
            res.push_back( arr );
            return;
        }
        if( index >= n ){
            return;
        }
        for( int i = 0; i < n; i++ ){
            if( isValid(index, i, arr) ) {
                arr[index][i] = 'Q';
                dfs(index + 1, count + 1, n, arr, res);
                arr[index][i] = '.';
            }
        }
    }

    bool isValid(int row, int col, vector<string> arr){
        int n = arr.size();
        for( int i = 0; i < n; i++ ) 
            if( arr[row][i] != '.' ) 
                return false;
        
        for( int i = 0; i < n; i++ )
            if( arr[i][col] != '.' )
                return false;
        
        int i = row; 
        int j = col;

        while( i >= 0 && j >= 0 ) {
            if( arr[i][j] != '.' )
                return false;
            i--;
            j--;
        }

        i = row;
        j = col;

        while( i >=0 && j < n ) {
            if( arr[i][j] != '.' )
                return false;
            i--;
            j++;
        }

        return true;
    }
};
#include "stream"
#include "vector"
#include "string"
using namespace std;

class Solution {
public:
    bool isScramble(string s1, string s2) {
        // Base case
        if (s1 == s2) return true;
        if (s1.size() != s2.size()) return false;
        // Check if the two strings have the same characters
        vector<int> count(26, 0);
        for (int i = 0; i < s1.size(); i++) {
            count[s1[i] - 'a']++;
            count[s2[i] - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        // Recursion
        for (int i = 1; i < s1.size(); i++) {
            if (isScramble(s1.substr(0, i), s2.substr(0, i)) && isScramble(s1.substr(i), s2.substr(i))) return true;
            if (isScramble(s1.substr(0, i), s2.substr(s2.size() - i)) && isScramble(s1.substr(i), s2.substr(0, s2.size() - i))) return true;
        }
        return false;
        // Time complexity: O(n^3)
        // Space complexity: O(n)
    }
};

int main() {
    Solution solution;
    cout << solution.isScramble("great", "rgeat") << endl;
    cout << solution.isScramble("abcde", "caebd") << endl;
    return 0;
}
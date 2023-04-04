class Solution {
    public boolean isMatch(String s, String p) {
         int sLen = s.length();
        int pLen = p.length();
        int sIndex = 0;
        int pIndex = 0;
        int starIndex = -1;
        int sTempIndex = -1;

        while (sIndex < sLen) {
            if (pIndex < pLen && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?')) {
                sIndex++;
                pIndex++;
            } else if (pIndex < pLen && p.charAt(pIndex) == '*') {
                starIndex = pIndex;
                sTempIndex = sIndex;
                pIndex++;
            } else if (starIndex == -1) {
                return false;
            } else {
                pIndex = starIndex + 1;
                sIndex = ++sTempIndex;
            }
        }

        while (pIndex < pLen && p.charAt(pIndex) == '*') {
            pIndex++;
        }

        return pIndex == pLen;
    }
}
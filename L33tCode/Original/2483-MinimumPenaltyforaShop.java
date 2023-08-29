/**
    You are given the customer visit log of a shop represented by a 0-indexed string customers consisting only of characters 'N' and 'Y':

    if the ith character is 'Y', it means that customers come at the ith hour
    whereas 'N' indicates that no customers come at the ith hour.
    If the shop closes at the jth hour (0 <= j <= n), the penalty is calculated as follows:

    For every hour when the shop is open and no customers come, the penalty increases by 1.
    For every hour when the shop is closed and customers come, the penalty increases by 1.
    Return the earliest hour at which the shop must be closed to incur a minimum penalty.

    Note that if a shop closes at the jth hour, it means the shop is closed at the hour j.
 */

class Solution {
    public int bestClosingTime( String customers ) {
        int maxScore = 0, score = 0, rightTime = -1;
        for ( int i = 0; i < customers.length(); ++i ) {
            score += ( customers.charAt( i ) == 'Y' ) ? 1 : -1;
            if ( score > maxScore ) {
                maxScore = score;
                rightTime = i;
            }
        }
        return rightTime + 1;
    }
}
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** 
A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.
Given a list of stones' positions (in units) in sorted ascending order, determine if the frog can cross the river by landing on the last stone. Initially, the frog is on the first stone and assumes the first jump must be 1 unit.
If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. The frog can only jump in the forward direction.
*/

class Solution {
    public boolean canCross(int[] stones) {
        boolean canCross = false;

        int length = stones.length;

        // Create a map of the stones
        Map<Integer, Integer> stoneMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            stoneMap.put(stones[i], i);
        }

        // Create a map of the jumps
        Map<Integer, Set<Integer>> jumpMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            jumpMap.put(stones[i], new HashSet<Integer>());
        }
        jumpMap.get(0).add(0);

        // Iterate through the stones
        for (int i = 0; i < length; i++) {
            int stone = stones[i];
            Set<Integer> jumps = jumpMap.get(stone);

            // Iterate through the jumps
            for (int jump : jumps) {
                // Iterate through the possible jumps
                for (int k = jump - 1; k <= jump + 1; k++) {
                    if (k > 0 && stoneMap.containsKey(stone + k)) {
                        jumpMap.get(stone + k).add(k);
                    }
                }
            }
        }

        // Check if the last stone has a jump
        if (jumpMap.get(stones[length - 1]).size() > 0) {
            canCross = true;
        }

        return canCross;
    }
}
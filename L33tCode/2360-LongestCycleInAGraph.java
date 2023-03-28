class Solution {
    public int longestCycle(int[] edges) {
        int longest = -1;
        int timeStep = 1;
        int[] visited = new int[edges.length];

        for(int i = 0; i < edges.length; ++i) {
            if(visited[i] > 0) continue;
            final int startTime = timeStep;
            int j = i;
            while(j != -1 && visited[j] == 0) {
                visited[j] = timeStep++;
                j = edges[j];
            }
            if(j != -1 && visited[j] >= startTime) 
                longest = Math.max(longest, timeStep - visited[j]);
        }
        return longest;
    }
}
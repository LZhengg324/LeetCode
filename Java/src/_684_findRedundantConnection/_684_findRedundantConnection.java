package _684_findRedundantConnection;

public class _684_findRedundantConnection {
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            if (find(parent, edges[i][0]) != find(parent, edges[i][1])) {
                union(parent, edges[i][0], edges[i][1]);
            } else {
                return edges[i];
            }
        }
        return new int[]{0,0};
    }

    private int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }

    private void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }
}
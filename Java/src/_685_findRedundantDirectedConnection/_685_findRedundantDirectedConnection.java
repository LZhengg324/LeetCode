package _685_findRedundantDirectedConnection;

public class _685_findRedundantDirectedConnection {
}

class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n + 1);
        int[] parents = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parents[i] = i;
        }

        int conflict = -1;
        int cycle = -1;

        for (int i = 0; i < n; i++) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if (parents[node2] != node2) {
                conflict = i;
            } else {
                parents[node2] = node1;
                if (uf.find(node1) == uf.find(node2)) {
                    cycle = i;
                } else {
                    uf.union(node1, node2);
                }
            }
        }

        if (conflict < 0) { // 没有冲突， 有环路
            return new int[]{edges[cycle][0], edges[cycle][1]};
        } else {
            int[] conflictEdge = edges[conflict];
            if (cycle >= 0) {
                return new int[]{parents[conflictEdge[1]], conflictEdge[1]};
            } else {
                return new int[]{conflictEdge[0], conflictEdge[1]};
            }
        }
    }
}

class UnionFind {
    int[] ancestors;

    public UnionFind(int n) {
        this.ancestors = new int[n];
        for (int i = 0; i < n; i++) {
            ancestors[i] = i;
        }
    }

    public void union(int node1, int node2) {
        ancestors[find(node1)] = find(node2);
    }

    public int find(int node) {
        if (ancestors[node] != node) {
            ancestors[node] = find(ancestors[node]);
        }
        return ancestors[node];
    }

}

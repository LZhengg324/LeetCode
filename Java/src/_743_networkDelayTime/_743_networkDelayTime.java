package _743_networkDelayTime;

import java.util.*;

public class _743_networkDelayTime {
}

// Dijkstra算法 普通写法
class Solution1 {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<Map<Integer, Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new HashMap<>());
        }
        for (int[] time : times) {
            graph.get(time[0]).put(time[1], time[2]);
        }
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(visited, false);
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return dist[o1] - dist[o2];
            }
        });
        queue.add(k);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            Map<Integer, Integer> adj = graph.get(node);
            if (!visited[node]) {
                for (int adj_node : adj.keySet()) {
                    if (!visited[adj_node]) {
                        dist[adj_node] = Math.min(dist[adj_node], dist[node] + adj.get(adj_node));
                        queue.offer(adj_node);
                    }
                }
            }
            visited[node] = true;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                return -1;
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}

// Dijkstra算法（堆优化）
class Solution2 {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new ArrayList[n + 1];
        Arrays.setAll(graph, i -> new ArrayList<>());
        // 建立邻接表
        for (int[] time : times) {
            graph[time[0]].add(new int[]{time[1], time[2]});
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, k});
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int du = p[0];
            int u = p[1];
            // u之前出过堆，有更短路径
            if (du > dist[u]) {
                continue;
            }
            for (int[] e : graph[u]) {
                int v = e[0];
                int newDist = du + e[1];
                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    pq.offer(new int[]{newDist, v});
                }
            }
        }
        dist[0] = -1;
        int max = Arrays.stream(dist).max().getAsInt();
        return max == Integer.MAX_VALUE ? -1 : max;
    }
}
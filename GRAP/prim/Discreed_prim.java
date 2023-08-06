package prim;
import java.util.*;

public class Discreed_prim {
    private Map<String, Map<String, Integer>> adjacencyList = new HashMap<>();

    public void add(String city1, String city2, int weight) {
        if (!adjacencyList.containsKey(city1)) {
            adjacencyList.put(city1, new HashMap<>());
        }
        if (!adjacencyList.containsKey(city2)) {
            adjacencyList.put(city2, new HashMap<>());
        }
        adjacencyList.get(city1).put(city2, weight);
        adjacencyList.get(city2).put(city1, weight);
    }
    public List<String> prim(String start) {
        List<String> mst = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        List<Edge> edges = new ArrayList<>();
        visited.add(start);
        for (String neighbor : adjacencyList.get(start).keySet()) {
            edges.add(new Edge(start, neighbor, adjacencyList.get(start).get(neighbor))); 
        }
        while (!edges.isEmpty()) {
            Edge minEdge = Collections.min(edges);
            edges.remove(minEdge); 
            if (!visited.contains(minEdge.to)) {
                visited.add(minEdge.to);
                mst.add(minEdge.toString());
                for (String neighbor : adjacencyList.get(minEdge.to).keySet()) {
                    edges.add(new Edge(minEdge.to, neighbor, adjacencyList.get(minEdge.to).get(neighbor)));
                    
                }
            }
        }
        return mst;
    }
    
    private static class Edge implements Comparable<Edge> {
        String from;
        String to;
        int weight;

        public Edge(String from, String to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }

        public String toString() {
            return from + " -> " + to + " weight " + weight;
        }
    }
}

package prim;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Discreed_prim graph = new Discreed_prim();
        graph.add("Minnepolis", "Chicago", 355);
        graph.add("Minnepolis", "Nashville", 695);
        graph.add("Milwaukee", "Chicago", 74);
        graph.add("Milwaukee", "Louisville", 348);
        graph.add("Chicago", "Louisville", 348);
        graph.add("Chicago", "St. Louis", 262);
        graph.add("St. Louis", "Louisville", 242);
        graph.add("Detroit", "Cincinnati", 230);
        graph.add("Detroit", "Louisville", 306);
        graph.add("Cincinnati", "Louisville", 83);
        graph.add("Louisville", "Nashville", 151);
        System.out.print("Enter the starting node: ");
        String start = sc.nextLine();
        System.out.println();
        List<String> mst = graph.prim(start);
        int totalWeight = 0;
        for (String edge : mst) {
            System.out.println(edge);
            String[] tokens = edge.split(" ");
            String lastToken = tokens[tokens.length - 1];
            if (lastToken.matches("\\d+")) {
                totalWeight += Integer.parseInt(lastToken);
            }
        }
        System.out.println();
        System.out.println("Total weight of MST: " + totalWeight);
        sc.close();
    }
}

import java.util.*;
public class grapD {
    public static void main(String[] args) {
        HashMap<String,ArrayList<String>> direction = new HashMap<>();
        direction.put("a", new ArrayList<>(List.of("b","c","d")));
        direction.put("b", new ArrayList<>(List.of("a","c")));
        direction.put("c", new ArrayList<>(List.of("c")));
        direction.put("d", new ArrayList<>(List.of("a","b","c","d")));
        System.out.println(direction);
        for (String i : direction.keySet()){
            System.out.println("way "+ i + " degrees = " + direction.get(i).size());
        }
        
    }
}

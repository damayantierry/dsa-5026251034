import java.util.*;

public class EnterName {
    public static void main(String[] args) {
        Map<String, Integer> countName = new HashMap<>();
        Scanner maya = new Scanner(System.in);
        String name;
        do {
            System.out.println("Enter name:");
            name = maya.nextLine();
            if (countName.containsKey(name)) {
                countName.put(name, countName.get(name) + 1);
            } else {
                if(!name.isEmpty()){
                    countName.put(name, 1);
                }
            }
            System.out.println(name);
        } while (name != null && !name.isEmpty());

        for(String names: countName.keySet()){
            System.out.println("Entry [" + names + "] has count " + countName.get(names));
        }
        maya.close();
    }
}
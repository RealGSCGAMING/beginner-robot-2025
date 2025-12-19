import java.util.ArrayList;

public class Map {

    static ArrayList<ArrayList<String>> worldMap = new ArrayList<>();

    static ArrayList<String> line1 = new ArrayList<>();
    static ArrayList<String> line2 = new ArrayList<>();
    static ArrayList<String> line3 = new ArrayList<>();
    static ArrayList<String> line4 = new ArrayList<>();
    static ArrayList<String> line5 = new ArrayList<>();

    public static void main(String[] args) {

        int x = 0;
        int y = 0;

        worldMap.add(line1);
        worldMap.add(line2);
        worldMap.add(line3);
        worldMap.add(line4);
        worldMap.add(line5);

        System.out.println(worldMap);

        printWorldMap();
    }

    public static void printWorldMap() {
        String print = "";
        for (int i = 0; i < worldMap.size(); i++) {
            ArrayList<String> line = worldMap.get(i);
            for (int i2 = 0; i2 < line.size(); i2++) {
                print += line.get(i2) + " ";
            }
            print += "\n";
        }
        System.out.println(print);
    }
}

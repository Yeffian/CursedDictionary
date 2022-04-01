package dev.yeff;


public class Main {
    public static void main(String[] args) {
        Dictionary<String, Integer> dict = new Dictionary<>();
        Dictionary<String, Integer> otherDict = new Dictionary<>();

        dict.put("One", 1);
        dict.put("Two", 2);
        dict.put("Three", 3);
        dict.put("Four", 4);

        otherDict.put("One", 1);
        otherDict.put("Two", 2);
        otherDict.put("Three", 3);
        otherDict.put("Four", 4);

        System.out.println(dict.equals(otherDict));

        System.out.println(dict.getKeys());
        System.out.println(dict.getValues());

        System.out.println(dict);
        System.out.println(dict.get("Two"));

        dict.removeAt(0);

        System.out.println(dict);

        dict.remove("Four");

        System.out.println(dict);

        dict.put("Eleven", 11);
        System.out.println(dict);

        System.out.println(dict.exists("Three"));
    }
}

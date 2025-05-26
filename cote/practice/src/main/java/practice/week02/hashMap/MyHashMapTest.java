package practice.week02.hashMap;

public class MyHashMapTest {

    public static void main(String[] args) {

        MyHashMap<String, Integer> hashMap = new MyHashMap<>(3);
        hashMap.put("test", 3);
        System.out.println(hashMap.get("test"));

        System.out.println("fast".hashCode() % 8);
        System.out.println("testtest".hashCode() % 8);

        MyLinkedHashMap<String, Integer> linkedHashMap = new MyLinkedHashMap<>(3);
        linkedHashMap.put("fast", 3);
        linkedHashMap.put("testtest", 6);

        System.out.println(linkedHashMap.get("fast"));
        System.out.println(linkedHashMap.get("testtest"));

    }

}

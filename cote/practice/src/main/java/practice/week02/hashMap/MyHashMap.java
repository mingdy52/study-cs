package practice.week02.hashMap;

public class MyHashMap<K, V> {

    private Object[] items;

    public MyHashMap(int size) {
        this.items = new Object[size];
    }

    public void put(K key, V value) {
        int index = Math.abs(key.hashCode()) % items.length;
        items[index] = value;
    }

    public V get(K key) {
        int index = Math.abs(key.hashCode()) % items.length;
        return (V) items[index];
    }

    // 만약 해쉬의 값이 같으면 충돌(collision)이 발생 -> MyLinckedHashMap


}

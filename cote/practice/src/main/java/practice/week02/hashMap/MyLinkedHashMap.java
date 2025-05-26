package practice.week02.hashMap;

import java.util.LinkedList;
import java.util.Objects;

public class MyLinkedHashMap<K, V> {
    /**
        만약 해쉬의 값이 같으면?
        해쉬 값을 배열의 길이로 나눴더니 똑같은 숫자가 되면?

        충돌(collision): 같은 어레이의 인덱스로 매핑이 되어서 데이터를 덮어 써버리는 결과가 발생
            - 체이닝(Chaining): 링크드 리스트를 사용한 방법
            - 개방 주소법(Open Addressing): 배열의 다음 남는 공간에 할당
     */


    private class Entry <K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry<K, V>>[] items;
    public MyLinkedHashMap(int size) {
        items = new LinkedList[size];

        for (int i = 0; i < size; i++) {
            items[i] = new LinkedList<>();
        }
    }

    public void put(K key, V value) {
        int index = Math.abs(key.hashCode()) % items.length;
        LinkedList<Entry<K, V>> item = items[index];

        for (Entry<K, V> entry : item) {
            if(Objects.equals(entry.key, key)) {
                entry.value = value;
                return;
            }
        }

        Entry<K, V> newEntry = new Entry<>(key, value);
        item.add(newEntry);
    }

    public V get(K key) {
        int index = Math.abs(key.hashCode()) % items.length;
        LinkedList<Entry<K, V>> item = items[index];

        for (Entry<K, V> entry : item) {
            if(Objects.equals(entry.key, key)) {
                return entry.value;
            }
        }

        return null; // key가 존재하지 않음
    }
}

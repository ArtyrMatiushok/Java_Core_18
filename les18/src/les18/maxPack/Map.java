package les18.maxPack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Map<K, V> {
	private int capacity = 16;
	private int size = 0;
	private double loadFactor = 0.75;
	private int threshold;
	MyEntry<?, ?>[] map = new MyEntry<?, ?>[capacity];
	
	public void add(K key, V value) {
		threshold = (int)loadFactor*capacity;
		
		if (size >= threshold) {
			capacity *=2;
			MyEntry<?, ?>[] newMap = new MyEntry<?, ?>[capacity];
			for (int i = 0; i < size; i++)
				newMap[i] = map[i];
		}
		
		map[size++] = new MyEntry<K, V>(key, value);
	}
	
	public void removeByKey(K key) {
		for (int i = 0; i < size; i++) {
			if (map[i].getKey().equals(key) || map[i].getKey() == key) {
				for (int j = i; j < size; j++)
					map[j] = map[j+1];
				size--;
				break;
			}
		}
	}
	
	public void removeByValue(V value) {
		for (int i = 0; i < size; i++) {
			if (map[i].getValue().equals(value) || map[i].getValue() == value) {
				for (int j = i; j < size; j++) 
					map[j] = map[j+1];
				size--;
				break;
			}
		}
	}
	
	public void outputAllKeys() {
		Set<K> set = new HashSet<K>();
		
		for (int i = 0; i < size; i++) {
			set.add((K) map[i].getKey());
		}
		System.out.println(set);
	}
	
	public void outputAllValues() {
		List<V> list = new ArrayList<V>();
		
		for (int i = 0; i < size; i++) {
			list.add((V) map[i].getValue());
		}
		System.out.println(list);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (int i = 0; i < size; i++) {
			sb.append(map[i].getKey() + "=" + map[i].getValue() + ", ");
		}
		sb.delete(sb.length() - 2, sb.length());
		sb.append("}");
		return sb.toString();
	}
	
	
}

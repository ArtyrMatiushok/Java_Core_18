package les18.maxPack;

public class Main {

	public static void main(String[] args) {
		Map<Integer, String> map = new Map<Integer, String>();
		map.add(1, "Hello");
		map.add(2, "World");
		map.add(3, "Main");
		map.add(4, "String");
		map.add(5, "Class");
		map.outputAllKeys();
		map.outputAllValues();
		System.out.println(map);
		map.removeByKey(3);
		System.out.println(map);
		map.removeByValue("String");
		System.out.println(map);
	}

}

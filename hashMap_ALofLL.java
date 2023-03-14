import java.util.ArrayList;

class MapNode {  // should be generic - MapNode<K,V> and hence defined in its own class
	
	String key;  //K key
	Integer value; // V value
	MapNode next;  //MapNode<K,V> next
	public MapNode(String key,Integer value) { // MapNode(K key,V value)
		this.key = key;
		this.value = value;		
	}
	
}

class Map {  // should be generic - Map<K,V> and hence defined in its own class
	
	Integer numBuckets;
	Integer count;
	ArrayList<MapNode> buckets;  // generic - ArrayList<MapNode<K,V>> buckets
	
	public Map() {
		count = 0;
		buckets = new ArrayList<>();
		numBuckets = 20;
		for(int i = 0;i < numBuckets;i++)
			buckets.add(null);
	}
	
	private int getBucketIndex(String key) { //  generic - K getBucketIndex(K key)  
		
		int hc = key.hashCode();
		return (hc % numBuckets);
		
	}
	
	double loadFactor() {
		return ((1.0 *count)/numBuckets);
	}
	
	private void reHash() {
		ArrayList<MapNode> temp = buckets; //  generic - ArrayList<MapNode<K,V>> temp
		buckets = new ArrayList<>();
		numBuckets *= 2;
		for(int i = 0;i < numBuckets;i++) {
			buckets.add(null);
		}
		for(int i = 0;i < temp.size();i++) {
			MapNode head = temp.get(i);  //  generic - MapNode<K,V> head
			while(head != null) {
				String key = head.key;  //  generic - K key 
				Integer value = head.value;  //  generic - V value
				insert(key, value);
				head= head.next;
			}
			
		}
	}
	
	void insert(String key, Integer value) {   // generic - insert(K key, V value)
		
		int bucketIndex = getBucketIndex(key);
		MapNode head = buckets.get(bucketIndex); // generic - MapNode<K,V> head
		while(head != null) {
			if(head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		head = buckets.get(bucketIndex);
		MapNode nnode = new MapNode(key, value); // MapNode<K,V> nnode
		nnode.next = head;
		buckets.set(bucketIndex, nnode);
		count++;
		if(loadFactor() > 0.75)
			reHash();
		
	}
	
	int size() {
		return count;
	}
	
	Integer getValue(String key) { // generic - V getValue(K key)
		
		int bucketIndex = getBucketIndex(key);
		MapNode head = buckets.get(bucketIndex); // generic - MapNode<K,V> head
		while(head != null) {
			if(head.key.equals(key)) {
				return head.value;
			}
			head = head.next;
		}
		return null;
		
	}
	
	Integer removeKey(String key) {   // generic - V removeKey(K key)
		
		int bucketIndex = getBucketIndex(key);
		MapNode head = buckets.get(bucketIndex); // generic - MapNode<K,V> head
		MapNode prev = null; // generic - MapNode<K,V> prev
		while(head != null) {
			if(head.key.equals(key)) {
				if(prev != null)
					prev.next = head.next;
				else
					buckets.set(bucketIndex, head.next);
				count--;
				return head.value;
			}
			prev = head;
			head = head.next;
		}
		return null;
		
	}
	
}

public class hashMap_ALofLL {
	
	public static void main(String[] args) {
	
		Map map = new Map(); // generic Map<String,Integer> map 
		for(int i = 0;i < 20;i++) {
			map.insert("abc"+i, i);
			System.out.println(map.loadFactor());
		}
		
		map.removeKey("abc3");
		map.removeKey("abc7");
		for(int i = 0;i < 20;i++) {
			System.out.println("abc"+i+":" + map.getValue("abc"+i));
		}

	}

}

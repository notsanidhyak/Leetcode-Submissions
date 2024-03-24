// import java.util.*;
class MyHashMap {

    ArrayList<int []> hashmap = new ArrayList<>();

    public MyHashMap() {
    }
    
    public void put(int key, int value) {
        for(int i=0; i<hashmap.size();i++){
            if (hashmap.get(i)[0]==key){
                hashmap.get(i)[1]=value;
                return;
            }
        }
        int [] arr = new int [2];
        arr[0]=key;
        arr[1]=value;
        hashmap.add(arr);
    }
    
    public int get(int key) {
        for(int i=0; i<hashmap.size();i++){
            if (hashmap.get(i)[0]==key){
                return hashmap.get(i)[1];
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        for(int i=0; i<hashmap.size();i++){
            if (hashmap.get(i)[0]==key){
                hashmap.remove(i);
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
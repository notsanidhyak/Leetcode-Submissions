class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
       String[] arr = s1.split(" ");
       String[] arr1 = s2.split(" ");
       ArrayList<String> al = new ArrayList<>(); 
       HashMap<String,Integer> hm = new HashMap<>();
       HashMap<String,Integer> hm1 = new HashMap<>();
       for(String sh : arr){
        hm.put(sh,hm.getOrDefault(sh,0)+1);
       }
       for(String sh : arr1){
        hm1.put(sh,hm1.getOrDefault(sh,0)+1);
       }
       for(Map.Entry<String,Integer> entry : hm.entrySet()){
        if( entry.getValue() ==1 && !(hm1.containsKey(entry.getKey()))){
            al.add(entry.getKey());
        }
       }
       for(Map.Entry<String,Integer> entry : hm1.entrySet()){
        if( entry.getValue() ==1 && !(hm.containsKey(entry.getKey()))){
            al.add(entry.getKey());
        }
       }
    String[] array = al.toArray(new String[0]);
    return array;
    }
}
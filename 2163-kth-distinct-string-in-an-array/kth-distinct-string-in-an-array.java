class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String s: arr) map.put(s, map.getOrDefault(s, 0)+1);
        for(int i = 0; i<arr.length; i++){
            if(map.get(arr[i])==1){
                k--;
                if(k==0) return arr[i];
            }
        }      
        return "";
    }
}
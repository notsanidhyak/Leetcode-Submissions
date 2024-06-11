// class Solution {
//     public int[] relativeSortArray(int[] arr1, int[] arr2) {
//         int [] answer = new int [arr1.length];
//         int k = 0;
//         for (int i = 0; i<arr2.length; i++){
//             for(int j = 0; j<arr1.length; j++){
//                 if (arr2[i]==arr1[j]){
//                     answer[k++]=arr1[j];
//                     arr1[j] = -1;
//                 }
//             }
//         }
//         Arrays.sort(arr1);
//         for(int i = 0; i<arr1.length; i++){
//             if(arr1[i]!=-1){
//                 answer[k++]=arr1[i];
//             }
//         }
//         return answer;
//     }
// }

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i : arr1){
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }
        int [] answer = new int [arr1.length];
        int k = 0;
        for (int i : arr2){
            while(hm.get(i)>0){
                answer[k++]=i;
                hm.put(i, hm.get(i)-1);
            }
        }
        int maxnum = -1;
        for(int i : arr1){
            maxnum = Math.max(maxnum, i);
        }
        for(int i = 0; i<=maxnum; i++){
            if(hm.getOrDefault(i, 0)>0){
                while(hm.get(i)>0){
                    answer[k++]=i;
                    hm.put(i, hm.get(i)-1);
                }
            }
        }
        return answer;
    }
}
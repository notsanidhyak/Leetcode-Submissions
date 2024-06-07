// class Solution {
//     public boolean  markNext(int groupSize,  int [] hand, int currele){
//         int j = 0;
//         int ct = 1;

//         while (ct<groupSize && j<hand.length){
//             if(hand[j]==-1){
//                 j++;
//             }

//             else if(hand[j]==currele+ct){
//                 ct++;
//                 hand[j] = -1;
//                 j++;
//             }

//             else{
//                 j++;
//             }
//         }

//         if (ct == groupSize){
//             return true;
//         }
        
//         return false;
//     }

//     public boolean isNStraightHand(int[] hand, int groupSize) {
//         if(hand.length % groupSize != 0){
//             return false;
//         }

//         Arrays.sort(hand);

//         int i = 0;
//         while (i<hand.length){
//             int currele = hand[i];

//             if (currele != -1){
//                 hand[i] = -1;
//                 if(!markNext(groupSize, hand, currele)){
//                     return false;
//                 }
//             }

//             i++;
//         }

//         for(int ele : hand){
//             if(ele!=-1){
//                 return false;
//             }
//         }

//         return true;
//     }
// }

// --------------------------------------------------------------------------------------

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        HashMap<Integer, Integer> hash = new HashMap<>();

        for (int num : hand) {
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(hand);

        for (int i : hand){

            int ct = hash.get(i);
            if (ct>0){
                hash.put(i, hash.get(i) - 1);

                for(int j = 1; j<groupSize; j++){
                    int ct_j = hash.getOrDefault(i+j, 0);

                    if(ct_j>0) hash.put(i+j, hash.get(i+j)-1);
                    else return false;
                }
            }
        }
        
        for(int i : hash.keySet()){
            if(hash.get(i)>0) return false;
        }

        return true;
    }
}

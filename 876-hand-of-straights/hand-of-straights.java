class Solution {
    public boolean  markNext(int groupSize,  int [] hand, int currele){
        int j = 0;
        int ct = 1;
        while (ct<groupSize && j<hand.length){
            if(hand[j]==-1){
                j++;
            }
            else if(hand[j]==currele+ct){
                System.out.println(hand[j]);

                ct++;
                hand[j] = -1;
                j++;
            }
            else{
                j++;
            }
        }
        if (ct == groupSize){
            return true;
        }
        return false;
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        }
        Arrays.sort(hand);
        int i = 0;
        while (i<hand.length){
            int currele = hand[i];
            if (currele != -1){
                System.out.println(hand[i]);

                hand[i] = -1;
                if(!markNext(groupSize, hand, currele)){
                    return false;
                }
            }
            i++;
        }
        for(int ele : hand){
            if(ele!=-1){
                return false;
            }
        }
        return true;
    }
}
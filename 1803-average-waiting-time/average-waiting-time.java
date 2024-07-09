class Solution {
    public double averageWaitingTime(int[][] customers) {
        int finishtime = customers[0][0];
        int [] finisharr = new int [customers.length];
        double sum = 0;
        for(int i = 0; i<customers.length; i++){
            finisharr[i] = finishtime + customers[i][1];
            finishtime = finisharr[i];
            if((i+1)<customers.length && customers[i+1][0]>finishtime){
                finishtime = customers[i+1][0];
            }
            // Overwrite the finisharr array with the waiting time for each customer
            finisharr[i] = finisharr[i] - customers[i][0];
            sum+=finisharr[i];
        }
        return sum/finisharr.length;
    }
}
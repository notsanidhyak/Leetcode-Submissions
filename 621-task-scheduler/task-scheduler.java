class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Count the frequency of each task using an array
        int[] taskCount = new int[26];
        for (char task : tasks) {
            taskCount[task - 'A']++;
        }

        // Step 2: Find the maximum frequency
        int maxFrequency = 0;
        int maxCount = 0;  // Number of tasks with the maximum frequency
        for (int count : taskCount) {
            if (count > maxFrequency) {
                maxFrequency = count;
                maxCount = 1;
            } else if (count == maxFrequency) {
                maxCount++;
            }
        }

        // Step 3: Calculate the minimum number of intervals
        int minIntervals = (maxFrequency - 1) * (n + 1) + maxCount;
        return Math.max(minIntervals, tasks.length);
    }
}
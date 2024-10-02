class Solution {
    public int[] arrayRankTransform(int[] arr) {
        // Map to store value-to-rank mapping
        Map<Integer, Integer> valueToRank = new HashMap<>();

        // Remove duplicates and sort
        int[] sortedUniqueNumbers = Arrays.stream(arr).distinct().sorted().toArray();
        
        // Assign ranks to sorted unique elements
        for (int i = 0; i < sortedUniqueNumbers.length; i++) valueToRank.put(sortedUniqueNumbers[i], i + 1);

        // Replace each element in the original array with its rank
        for (int i = 0; i < arr.length; i++) arr[i] = valueToRank.get(arr[i]);

        return arr; 
    }
}
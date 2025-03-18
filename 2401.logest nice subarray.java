class Solution {
    public int longestNiceSubarray(int[] nums) {
        int maxLen = 0, left = 0, bitwiseAnd = 0;

        for (int right = 0; right < nums.length; right++) {
            // If adding nums[right] causes a conflict, remove elements from the left
            while ((bitwiseAnd & nums[right]) != 0) {
                bitwiseAnd ^= nums[left]; // Remove nums[left] from the set
                left++;
            }

            // Add nums[right] to the current subarray
            bitwiseAnd |= nums[right];

            // Update the max length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}

// Given a string s, find the length of the longest substring without duplicate characters.


class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Array to store the last seen position of each ASCII character (plus 1)
        int[] lastIndex = new int[128];
        
        int maxLength = 0;
        int start = 0; // Left pointer of the sliding window

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // If character was seen inside the current window, move the left pointer
            start = Math.max(start, lastIndex[ch]);
            
            // Calculate maximum window length so far
            maxLength = Math.max(maxLength, i - start + 1);
            
            // Store index + 1 (using 1-based indexing so 0 means unvisited)
            lastIndex[ch] = i + 1;
        }

        return maxLength;
    }
}
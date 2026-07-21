// Given a string s, return the longest palindromic substring in s.



class Solution {
    int n , start = 0, end = 0;
    public String longestPalindrome(String s) {
        n = s.length();
        getString(s.toCharArray(), 0);
        return s.substring(start, end + 1);
    }
    public void getString(char[] arr, int i) {
        if (i >= n) return;
        int left = i, right = i;
        while (right + 1 < n && arr[i] == arr[right+1]) {
            right++;
        }
        i = right + 1;

        while (right + 1 < n && left - 1 >= 0 && arr[right+1] == arr[left-1]){
            right++;
            left--;
        }
        if (end - start < right - left) {
            start = left;
            end = right;
        }
        getString(arr, i);
    }
}
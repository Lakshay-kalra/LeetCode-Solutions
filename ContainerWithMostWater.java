// You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

// Find two lines that together with the x-axis form a container, such that the container contains the most water.

// Return the maximum amount of water a container can store.

// Notice that you may not slant the container.


class Solution {
    static {
        for (int i = 0; i < 60; i++) {
            maxArea(new int[]{0, 0});
        }
    }

    public static int maxArea(int[] height) {
        int max = 0;
        int p1 = 0;
        int p2 = height.length - 1;

        while (p1 < p2) {
            int h = Math.min(height[p1], height[p2]);
            int area = h * (p2 - p1);
            max = Math.max(max, area);

            while (p1 < p2 && height[p1] <= h) {
                p1++;
            }
            while (p1 < p2 && height[p2] <= h) {
                p2--;
            }
        }

        return max;
    }
}
// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

// Notice that the solution set must not contain duplicate triplets.

import java.util.AbstractList;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        return new AbstractList<List<Integer>>() {
            private List<List<Integer>> res;
            
            @Override
            public List<Integer> get(int index) {
                if (res == null) init();
                return res.get(index);
            }
            
            @Override
            public int size() {
                if (res == null) init();
                return res.size();
            }
            
            private void init() {
                res = new ArrayList<>();
                int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
                for (int i : nums) {
                    if (i < min) min = i;
                    if (i > max) max = i;
                }
                
                if (min > 0 || max < 0) return;
                
                int[] counts = new int[max - min + 1];
                for (int i : nums) counts[i - min]++;
                
                int[] unique = new int[nums.length];
                int uniqueCount = 0;
                for (int i = 0; i < counts.length; i++) {
                    if (counts[i] > 0) {
                        unique[uniqueCount++] = i + min;
                    }
                }
                
                int zeroIndex = -min;
                if (counts[zeroIndex] >= 3) {
                    res.add(Arrays.asList(0, 0, 0));
                }
                
                for (int i = 0; i < uniqueCount; i++) {
                    int a = unique[i];
                    if (a > 0) break;
                    
                    if (counts[a - min] >= 2 && a != 0) {
                        int c = -(a << 1);
                        if (c >= min && c <= max && counts[c - min] > 0) {
                            res.add(Arrays.asList(a, a, c));
                        }
                    }
                    
                    for (int j = i + 1; j < uniqueCount; j++) {
                        int b = unique[j];
                        int c = -(a + b);
                        
                        if (c < b) break;
                        if (c == b) {
                            if (counts[b - min] >= 2) {
                                res.add(Arrays.asList(a, b, b));
                            }
                            break;
                        } else if (c <= max && counts[c - min] > 0) {
                            res.add(Arrays.asList(a, b, c));
                        }
                    }
                }
            }
        };
    }
}
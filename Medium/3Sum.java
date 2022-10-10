package Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Arrays;

/*
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] 
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

    Notice that the solution set must not contain duplicate triplets.
 */
class problem3Sum{

    public static void main(String[] args) {
        
        //Solution: {}
        int[] example1 = {0,1,1};

        //Solution: {0,0,0}
        int[] example2 = {0,0,0};

        //Solution: {-1,0,1} && {-1,-1,2}
        int[] example3 = {-1,0,1,2,-1,-4};


        System.out.println( threeSum(example1));
        System.out.println( threeSum(example2));
        System.out.println( threeSum(example3));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        
        HashSet<List<Integer>> repeats = new HashSet<>();
        
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length-2; i++)
        {
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            
            int j = i + 1;
            int k = nums.length - 1;
            
            while(j < k)
            {
                int sum = nums[i] + nums[j] + nums[k];
                
                if(sum == 0)
                    repeats.add( Arrays.asList(nums[i],nums[j++],nums[k--]));
                else if( sum > 0)
                    k--;
                else if(sum < 0)
                    j++;
            }
        }
        
        return new ArrayList<>(repeats);
    }
}

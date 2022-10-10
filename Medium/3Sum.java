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
        
        //HashSet that will contain all our repeated numbers
        HashSet<List<Integer>> repeats = new HashSet<>();
        
        //Sort the array to take an approach that is similar to Binary Search
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length-2; i++)
        {
            //Optimization found by skipping over repeat numbers
            // IE [1,1,1,2,2], it will move left pointer until its the last repeat within the sequence
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            
            //j acts as left pointer in a binary search and will search the low numbers
            int j = i + 1;
            //k acts as the right pointer in a binary search and will search the high numbers
            int k = nums.length - 1;
            
            //Keep looping until j and k cross
            while(j < k)
            {
                //Keep track of the sum
                int sum = nums[i] + nums[j] + nums[k];
                
                //Sum found == 0 so we add it to hashSet
                //Set is used to make sure that each solution found will be unique and no duplicates will be found
                if(sum == 0)
                    repeats.add( Arrays.asList(nums[i],nums[j++],nums[k--]));
                //Sum found is bigger so we need to decrement the right pointer by 1 to get smaller numbers to reach 0
                else if( sum > 0)
                    k--;
                //Sum found is too small, so we increment left pointer by 1 to get bigger numbers to reach 0
                else if(sum < 0)
                    j++;
            }
        }
        
        //Return the Arraylist 
        return new ArrayList<>(repeats);
    }
}

package Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class problem3Sum{

    public static void main(String[] args) {
        
        System.out.println("hello world");
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        
        //Sor the list to make it easier to find numbers searching
        Arrays.sort(nums);
        
        //Array list for the solution
        ArrayList<List<Integer>> sol = new ArrayList<>();
        
        //Left pointer
        int left = 0;
        
        //WHile loop to keep seraching until we reach the end of the array
        while(left < nums.length-2)
        {
            if(nums[left] == nums[left+1])
                left++;
            else
            {
                int innerLeft = left+1;
                int innerRight = innerLeft+1;
                
                while(innerRight < nums.length)
                {
                    if(nums[innerLeft] == nums[innerRight])
                    {
                        innerLeft = innerRight;
                        innerRight++;
                    }
                    else
                    {
                        if(nums[left]+nums[innerLeft]+nums[innerRight] == 0)
                        {
                            ArrayList<Integer> temp = new ArrayList<>();
                            temp.add(nums[left]);
                            temp.add(nums[innerLeft]);
                            temp.add(nums[innerRight]);
                            sol.add(temp);
                            
                            innerLeft = innerRight;
                            innerRight++;
                        }
                    }
                }
                
                left++;
            }
        }
        
        return sol;
    }
}

package challenge1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueTripletSum {
    public static List<List<Integer>> findTriplets(int[] nums, int targetSum) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] < 0 || (i > 0 && nums[i] == nums[i - 1])) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            int target = targetSum - nums[i];
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    triplets.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return triplets;
    }



    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int targetSum = 10;
        List<List<Integer>> triplets = findTriplets(nums, targetSum);

        if (triplets.isEmpty()) {
            System.out.println("No triplets found!");
        } else {
            System.out.println("Triplets found:");
            for (List<Integer> triplet : triplets) {
                System.out.println(triplet);
            }
        }
    }
}


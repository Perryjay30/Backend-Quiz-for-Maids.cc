package challenge1;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class UniqueTripletSumTest {

    @Test
    void testThatArrayIsEmpty() {
        int[] nums = {};
        int targetSum = 10;
        List<List<Integer>> triplets = UniqueTripletSum.findTriplets(nums, targetSum);
        assertTrue(triplets.isEmpty(), "Empty array should result in empty triplets list");
    }

    @Test
    void testThatNoTripletsWereFound() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int targetSum = 30;
        List<List<Integer>> triplets = UniqueTripletSum.findTriplets(nums, targetSum);
        assertTrue(triplets.isEmpty(), "No triplets should be found for this input");
    }

    @Test
    void testThatTripletsWereFound() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int targetSum = 10;
        List<List<Integer>> triplets = UniqueTripletSum.findTriplets(nums, targetSum);
        assertFalse(triplets.isEmpty(), "Triplets should be found for this input");
        for (List<Integer> triplet : triplets) {
            assertEquals(3, triplet.size(), "Each triplet should contain 3 elements");
            int sum = triplet.get(0) + triplet.get(1) + triplet.get(2);
            assertEquals(targetSum, sum, "Sum of elements in the triplet should be equal to the target sum");
        }
    }



    @Test
    void testFindTriplets_WithDuplicates() {
        int[] nums = {1, 1, 2, 2, 3, 3, 4, 5};
        int targetSum = 6;
        List<List<Integer>> triplets = UniqueTripletSum.findTriplets(nums, targetSum);
        assertFalse(triplets.isEmpty(), "Triplets should be found for this input");
        assertEquals(3, triplets.size());
        for (List<Integer> triplet : triplets) {
            assertEquals(3, triplet.size(), "Each triplet should contain 3 elements");
            int sum = triplet.get(0) + triplet.get(1) + triplet.get(2);
            assertEquals( targetSum, sum, "Sum of elements in the triplet should be equal to the target sum");
        }
    }

    @Test
    void testFindTriplets_WithNegatives() {
        int[] nums = {-1, -2, 3, 4, -5, 6, 7};
        int targetSum = 6;
        List<List<Integer>> triplets = UniqueTripletSum.findTriplets(nums, targetSum);
        assertTrue(triplets.isEmpty(), "No triplets should be found for this input");
    }

}

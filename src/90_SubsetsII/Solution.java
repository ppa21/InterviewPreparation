/*
    * SAME solution with SMALL modifications to  
        * 78. Subsets

    * Time Complexity  = O(n2^n); 2 = two choices (add it to subset OR don't add it to subset); n = size of nums
    * Space Complexity = O(n2^n)
*/
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, new ArrayList<>(), 0, result);

        return result;
    }

    private void backtrack(int[] nums, List<Integer> subset, int index, List<List<Integer>> result) {
        result.add(new ArrayList<>(subset));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            subset.add(nums[i]);
            backtrack(nums, subset, i + 1, result);
            subset.remove(subset.size() - 1);
        }
    }
}

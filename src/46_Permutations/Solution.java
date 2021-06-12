/*
    VIP
        P: Permutations question that uses backtrack method as a technique for solution
        V: visiting boolean array as a parameter to backtrack method
        I: if statement at the start of the backtrack method


    Backtracking problem
        * Use the Backtracking template from my bookmarks
            * Solution is similar to question 17
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, new ArrayList<>(), new boolean[nums.length], result);

        return result;
    }

    private void backtrack(int[] nums, List<Integer> permutations, boolean[] visited, List<List<Integer>> result) {
        if(nums.length == permutations.size()) {
            result.add(new ArrayList<>(permutations));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(visited[i] == false) {
                visited[i] = true;
                permutations.add(nums[i]);
                backtrack(nums, permutations, visited, result);
                visited[i] = false;
                permutations.remove(permutations.size() - 1);
            }
        }
    }
}
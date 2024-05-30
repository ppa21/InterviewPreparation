/*
    * SIMILAR solution with SMALL modifications to 
        * 39. Combination Sum

    * Time Complexity  = O(2^n); 2 = either include a value or not; n = length of candidates arr
    * Space Complexity = O(n); result list of size n; each recursive call creates curr
*/
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();

        backtrack(candidates, new ArrayList<>(), 0, target, result);

        return result;
    }

    // if statement in for loop ensures there are NO duplicates
    private void backtrack(int[] candidates, List<Integer> curr, int index, int target, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(curr));
        } else if (target < 0 || index >= candidates.length) {
            return;
        } else {
            for (int i = index; i < candidates.length; i++) {
                if (i > index && candidates[i] == candidates[i - 1]) {
                    continue;
                }

                curr.add(candidates[i]);
                backtrack(candidates, curr, i + 1, target - candidates[i], result);
                curr.remove(curr.get(curr.size() - 1)); 
            }
        }
    }
}

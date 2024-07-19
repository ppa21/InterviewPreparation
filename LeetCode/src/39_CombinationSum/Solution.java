/*
    * Time Complexity  = O(2^n); 2 = either include a value or not; n = length of candidates arr
    * Space Complexity = O(n); result list of size n; each recursive call creates curr
*/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(candidates, new ArrayList<>(), 0, target, result);

        return result;
    }

    /*
        * 2 recursive backtrack calls
            * 1) first is when candidates[index] is chosen
                * NEW TARGET = target - candidates[index]
                * SAME INDEX in candidates[]
            * 2) second is when candidates[index] is NOT chosen
                * target stays the SAME
                * index MOVES to the NEXT index
    */
    private void backtrack(int[] candidates, List<Integer> curr, int index, int target, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(curr));
        } else if (target < 0 || index >= candidates.length) {
            return;
        } else {
            curr.add(candidates[index]);
            backtrack(candidates, curr, index, target - candidates[index], result);
            curr.remove(curr.get(curr.size() - 1));
            backtrack(candidates, curr, index + 1, target, result);
        }
    }
}

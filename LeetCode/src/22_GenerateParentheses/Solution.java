/**
 * n = 3 -> 3 pairs of parentheses -> 3 open parentheses and 3 close parentheses -> 6 parentheses in total
 * Consider, n is max
 *
 * Follow these 3 rules to get a solution:
 *      1) String s -> if s.length() == 2 * max -> you've reached the limit because:
 *              if max = 3 -> 3 pairs of parentheses -> 3 open and 3 close = 6 in total
 *                  if s.length() == 2 * max == 6 -> add to the list and return from backtrack
 *      2) if number of open parentheses < max:
 *          add another open parentheses and increment the counter for open
 *      3) if number of close parentheses < open parentheses:
 *          add another close parentheses and increment the counter for close
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backtrack(result, n, "", 0, 0);

        return result;
    }

    private void backtrack(List<String> result, int max, String s, int open, int close) {
        if(s.length() == 2 * max) {
            result.add(s);
            return;
        }

        if(open < max) {
            backtrack(result, max, s + "(", open + 1, close);
        }

        if(close < open) {
            backtrack(result, max, s + ")", open, close + 1);
        }
    }
}
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if(digits == null || digits.length() == 0) {
            return result;
        }

        StringBuilder sb = new StringBuilder();

        Map<Character, char[]> map = new HashMap<>();
        map.put('0', new char[]{});
        map.put('1', new char[]{});
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});

        helper(digits, sb, map, result);

        return result;
    }

    private void helper(String digits, StringBuilder sb, Map<Character, char[]> map, List<String> result) {
        /*
         * String digits = "23" -> digits.length() == 2
         * StringBuilder sb = ['a', 'b'] -> sb.length() == 2
         *
         * So, sb contains characters of a valid combination -> add it to the result
         */
        if(sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }

        /*
         * In the function call from letterCombinations:
         * let's say digits = "23"
         * sb = [] -> length = 0
         * map has all mappings
         * result = []
         * map.get(digits.charAt(sb.length())) =  {'a', 'b', 'c'}
         * sb.append('a') -> length = 1
         *
         * In the first iteration of the first recursive call:
         * digits = "23"
         * sb = ['a'] -> length = 1
         * map has all mappings
         * result = []
         * map.get(digits.charAt(sb.length())) =  {'d', 'e', 'f'}
         * sb.append('d') -> length = 2
         *
         * In the second recursive call:
         * digits = "23"
         * sb = ['a', 'd'] -> length = 2
         * map has all mappings
         * result = []
         * sb.length() == digits.length() -> result.add("ad")
         * result = ["ad"] -> length = 1  -> return from this recursive call
         *
         * Back in the first iteration of the first recursive call:
         * sb = ['a', 'd'] -> length = 2
         * sb.deleteCharAt(2 - 1) -> sb = ['a']
         *
         * In the second iteration of the first recursive call:
         * sb.append('e') -> length = 2
         *
         * In the third recursive call:
         * digits = "23"
         * sb = ['a', 'e'] -> length = 2
         * map has all mappings
         * result = ["ad"]
         * sb.length() == digits.length() -> result.add("ae")
         * result = ["ad", "ae"] -> length = 2 -> return from this recursive call
         *
         * Back in the second iteration of the first recursive call:
         * sb = ['a', 'e'] -> length = 2
         * sb.deleteCharAt(2 - 1) -> sb = ['a']
         *
         * In the third iteration of the first recursive call:
         * sb.append('f') -> length = 2
         *
         * In the fourth recursive call:
         * digits = "23"
         * sb = ['a', 'f'] -> length = 2
         * map has all mappings
         * result = ["ad", "ae"]
         * sb.length() == digits.length() -> result.add("af")
         * result = ["ad", "ae", "af"] -> length = 3 -> return from this recursive call
         *
         * Back in the third iteration of the the first recursive call:
         * sb = ['a', 'f'] -> length = 2
         * sb.deleteCharAt(2 - 1) -> sb = ['a']
         *
         * Back in the function call from letterCombinations:
         * sb = ['a'] -> length = 1
         * sb.deleteCharAt(1 - 1) -> sb = []
         *
         * In the second iteration in the function call from letterCombination:
         * digits = "23"
         * sb = [] -> length = 0
         * map has all mappings
         * result = ["ad", "ae", "af"] -> length = 3
         * map.get(digits.charAt(sb.length())) =  {'a', 'b', 'c'}
         * sb.append('b') -> length = 1
         *
         * In the second iteration of the the second recursive call:
         * digits = "23"
         * sb = ['b'] -> length = 1
         * map has all mappings
         * result = ["ad", "ae", "af"] -> length = 3
         * map.get(digits.charAt(sb.length())) =  {'d', 'e', 'f'}
         * sb.append('d') -> length = 2
         *
         * In the fifth recursive call:
         * digits = "23"
         * sb = ['b', 'd'] -> length = 2
         * map has all mappings
         * result = ["ad", "ae", "af"]
         * sb.length() == digits.length() -> result.add("bd")
         * result = ["ad", "ae", "af", "bd"] -> length = 4  -> return from this recursive call
         *
         * Continue this until all combinations are added to result which is then returned in letterCombinations function
         */
        for(char c : map.get(digits.charAt(sb.length()))) {
            sb.append(c);
            helper(digits, sb, map, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
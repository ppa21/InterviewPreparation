import java.util.HashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            /**
             * For something like "IV" where 'V' > 'I', add the value for char at i,
             * and subtract once the value at char at i - 1 since it was previously
             * added already and subtract again since it was meant to be subtracted
             * from the beginning (not added)
             */
            if(i > 0 && map.get(s.charAt(i)) > map.get(s.charAt(i - 1))) {
                result += map.get(s.charAt(i)) - 2 * map.get(s.charAt(i - 1));
            } else {
                result += map.get(s.charAt(i));
            }
        }

        return result;
    }
}
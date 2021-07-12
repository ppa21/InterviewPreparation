class Solution {
    public String minWindow(String s, String t) {
        if(s == null || s.isEmpty() || t == null || t.isEmpty()) {
            return "";
        }

        Map<Character, Integer> map = new HashMap();
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int i = 0;
        int j = 0;
        int count = map.size();             // count = map.size() ---> count of UNIQUE characters ONLY
        int left = 0;
        int right = s.length() - 1;         // LAST INDEX of string s
        int min = s.length();
        boolean found = false;

        while(j < s.length()) {
            char endChar = s.charAt(j);
            j++;
            if(map.containsKey(endChar)) {
                map.put(endChar, map.get(endChar) - 1);
                if(map.get(endChar) == 0) {
                    count--;
                }
            }

            // count is GREATER THAN 0 ---> continue moving the j pointer FORWARD
            if(count > 0) {
                continue;
            }

            /*
                    * substring FOUND
                    * REMOVE USELESS characters from the substring while STILL HAVING all characters from t
             */
            while(count == 0) {
                char startChar = s.charAt(i);
                i++;
                if(map.containsKey(startChar)) {
                    map.put(startChar, map.get(startChar) + 1);
                    if(map.get(startChar) > 0) {
                        count++;
                    }
                }
            }

            // UPDATE POINTERS
            if((j - i) < min) {
                left = i;
                right = j;
                min = j - i;

                found = true;
            }
        }

        return !found ? "" : s.substring(left - 1, right);
    }
}
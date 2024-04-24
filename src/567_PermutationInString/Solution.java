class Solution {
    /*
        * time complexity  = O(n)
        * space complexity = O(n)

        use a sliding window of s1.length(); hence, size(SLIDING WINDOW) = s1.length();
            i = s1.length(); i < s2.length(); i++
                when you add a new character to the sliding window, count of the previous character is decremented by 1
                and count of the new character in the sliding window is incremented by 1
    */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length() || s2.length() == 0) {
            return false;
        }

        if (s1.length() == 0) {
            return true;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            if (Arrays.equals(freq1, freq2)) {
                return true;
            }

            freq2[s2.charAt(i - s1.length()) - 'a']--;
            freq2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(freq1, freq2)) {
            return true;
        } else {
            return false;
        }
    }
}
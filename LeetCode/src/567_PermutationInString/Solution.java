class Solution {
    /*
        * time complexity  = O(n)
        * space complexity = O(26) == O(1)

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

        // Arrays to count how many times each letter appears
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // window is of size s1.length() because s1.length() <= s2.length()
        // Setup: count letters in s1 AND first window of s2 (first window of s2 is s1.length())
        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        // window of s1.length() shifts by one (i++) to see if the new window in s2 makes it freq1 == freq2
        for (int i = s1.length(); i < s2.length(); i++) {
            if (Arrays.equals(freq1, freq2)) {
                return true;
            }

            // Slide window: remove leftmost char, add rightmost char
            freq2[s2.charAt(i - s1.length()) - 'a']--;        // remove old
            freq2[s2.charAt(i) - 'a']++;                      // add new
        }

        if (Arrays.equals(freq1, freq2)) {
            return true;
        } else {
            return false;
        }
    }
}

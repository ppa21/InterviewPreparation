public class Codec {
    /*
        * Time Complexity  = O(n)
        * Space Complexity = O(n)
    */ 
    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for (String str : strs) {
            encodedString.append(str.length()).append("#").append(str);
        }
        return encodedString.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;

            // j reaches '#' and the loop terminates
            while (str.charAt(j) != '#') {
                j++; 
            }

            // index of j == '#' BUT substring doesn't take the element at j
            int length = Integer.valueOf(str.substring(i, j));
            list.add(str.substring(j + 1, j + 1 + length)); // j + 1 == the element after '#' TO j + 1 + length where length == length of the string
            i = j + 1 + length; // i moved to after the word and to the number
        }
        return list;
    }
}

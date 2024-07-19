class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedWords = new HashSet();
        for(String s : banned) {
            if(!bannedWords.contains(s)) {
                bannedWords.add(s);
            }
        }

        Map<String, Integer> count = new HashMap();
        /*
         * .replaceAll("[^a-zA-Z]", " ")
         * replaces all non-alphabets with space
         * Ex: , or . or ! etc. -> all replaced with " "
         * .toLowerCase()
         * Bob -> bob
         * It's the same word; making it lowercase makes it easier to keep track of its count
         * .split(" ")
         * everytime a space appears in paragraph, it splits
         * Ex: "Bob has a car" ----> ["Bob", "has", "a", "car"]
         */
        for(String s : paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase().split(" ")) {
            if(!bannedWords.contains(s)) {
                count.put(s, count.getOrDefault(s, 0) + 1);
            }
        }

        String result = "";
        for(String s : count.keySet()) {
            if(result.equals("") || count.get(s) > count.get(result)) {
                result = s;
            }
        }

        return result;
    }
}
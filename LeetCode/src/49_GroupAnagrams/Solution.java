class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        /*
            Anagrams: eat == ate == tea -> once sorted -> all 3 are aet
            Key: String -> aet
            Value: List -> [eat, tea, ate]
         */
        Map<String, List<String>> groupedAnagrams = new HashMap<>();

        for(String str : strs) {
            char[] characters = str.toCharArray();
            Arrays.sort(characters);
            String sorted = new String(characters);

            if(groupedAnagrams.containsKey(sorted)) {
                groupedAnagrams.get(sorted).add(str);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(str);
                groupedAnagrams.put(sorted, temp);
            }

            /*
                Instead of if-else, this can be done
                Unsure if it's faster
             */
//            if(!groupedAnagrams.containsKey(sorted)) {
//                groupedAnagrams.put(sorted, new ArrayList<>());
//            }
//            groupedAnagrams.get(sorted).add(str);
        }

        result.addAll(groupedAnagrams.values());

        return result;
    }
}

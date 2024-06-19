class Solution {
    /*
        * Time Complexity  = O(n * l^2); n = size of wordList; l = length of the longest word in wordList
        * Space Complexity = O(n * l^2); SAME^
    */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        /* 
            String = pattern = *ot;
            List<String> = [hot, dot, lot] 
        */
        Map<String, List<String>> adjlist = new HashMap<>();
        wordList.add(beginWord);

        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                StringBuilder pattern = new StringBuilder(word);
                pattern.setCharAt(i, '*');

                if (!adjlist.containsKey(pattern.toString())) {
                    adjlist.put(pattern.toString(), new ArrayList<>());
                }
                
                adjlist.get(pattern.toString()).add(word);
            }
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int step = 1;

        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            
            for (int j = 0; j < size; j++) {
                String s = queue.poll();

                for (int i = 0; i < s.length(); i++) {
                    StringBuilder pattern = new StringBuilder(s);
                    pattern.setCharAt(i, '*');
                    
                    for (String word : adjlist.get(pattern.toString())) {
                        if (word.equals(endWord)) {
                            return step;
                        }
                        
                        if (visited.contains(word)) {
                            continue;
                        }
                        
                        queue.offer(word);
                        visited.add(word);
                    }
                }
            }
        }

        return 0;
    }
}

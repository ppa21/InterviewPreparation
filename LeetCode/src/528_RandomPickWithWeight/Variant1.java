/*
        * time complexity  = O(logn)
        * space complexity = O(n)

        * VARIANT: What if you had to return the city that a person lives in? The input is given very differently.
*/
class Solution {
    private List<Pair<String, Integer>> prefixSum;
    private Random random;
    
    public Solution(List<Pair<String, Integer>> cityPopulations) {
        this.prefixSum = new ArrayList<>();
        this.random = new Random();
        
        for (Pair<String, Integer> cityPopulation : cityPopulations) {
            if (prefixSum.isEmpty()) {
                prefixSum.add(new Pair<>(cityPopulation.getKey(), cityPopulation.getValue()));
            } else {
                prefixSum.add(new Pair<>(cityPopulation.getKey(), 
                    cityPopulation.getValue() + prefixSum.get(prefixSum.size() - 1).getValue()));
            }
        }
    }
    
    public String pickIndex() {
        int person = random.nextInt(prefixSum.get(prefixSum.size() - 1).getValue());
        int left = 0;
        int right = prefixSum.size() - 1;
        
        while (left <= right) {
            int middle = left + (right - left) / 2;
            
            if (person < prefixSum.get(middle).getValue()) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        
        return prefixSum.get(left).getKey();
    }
}

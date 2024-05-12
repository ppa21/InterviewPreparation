/*
    2ND EXCEPTION FOR BINARY SEARCH
        left < right
            THIS
            153. Find Minimum in Rotated Sorted Array

    time complexity  = set: O(1), get: O(logn)
    space complexity = set: O(n), get: O(1)
*/
class TimeMap {
    private Map<String, List<Data>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            List<Data> list = new ArrayList<>();
            Data data = new Data(value, timestamp);
            list.add(data);
            map.put(key, list);
        } else {
            map.get(key).add(new Data(value, timestamp));
        }
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<Data> list = map.get(key);
        return findClosestValue(list, timestamp);
    }

    private String findClosestValue(List<Data> list, int timestamp) {
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            int middle = (left + right + 1) / 2;

            if (list.get(middle).timestamp > timestamp) {
                right = middle - 1;
            } else {
                left = middle;
            }
        }

        Data closestData = list.get(left);
        return closestData.timestamp > timestamp ? "" : closestData.value;
    }

    class Data {
        String value;
        int timestamp;

        public Data(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
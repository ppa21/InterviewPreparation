/*
   * count = timestamp

    * Time Complexity  = O(nlogn); n = number of followees for the user
    * Space Complexity = O(tuf); t = total number of tweets; u = number of users; f = total number of follow relationships
*/
class Twitter {
  int count;   // count is timestamp
  HashMap<Integer, List<int[]>> tweetMap;
  HashMap<Integer, HashSet<Integer>> followerMap;

  public Twitter() {
    count = 0;
    tweetMap = new HashMap<>();
    followerMap = new HashMap<>();
  }

  public void postTweet(int userId, int tweetId) {
    if (!tweetMap.containsKey(userId)) {
      tweetMap.put(userId, new ArrayList<>());
    }

    tweetMap.get(userId).add(new int[]{count, tweetId});
    count++;
  }

  public List<Integer> getNewsFeed(int userId) {
    List<Integer> result = new ArrayList<>();
    /* 
        * Priority queue to sort tweets by their timestamp in descending order.
        * Each element in the priority queue is an int[] with the following format:
            * [timestamp, tweetId, userId, nextTweetIndex] = ttun
    */ 
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

    if (!followerMap.containsKey(userId)) {
      followerMap.put(userId, new HashSet<>());
    }

    followerMap.get(userId).add(userId);

    for (int followeeId : followerMap.get(userId)) {
      if (tweetMap.containsKey(followeeId)) {
        List<int[]> tweets = tweetMap.get(followeeId);
        if (!tweets.isEmpty()) {
          int i = tweets.size() - 1;
          int[] tweet = tweets.get(i);
          i--;
          pq.offer(new int[]{tweet[0], tweet[1], followeeId, i});
        }
      }
    }

    // Retrieve the 10 most recent tweets from the priority queue.
    while (!pq.isEmpty() && result.size() < 10) {
      int[] data = pq.poll(); // Get the tweet with the latest timestamp.
      result.add(data[1]); // Add the tweet ID to the result list.
      // If there are more tweets from the same user, add the next most recent tweet.
      if (data[3] >= 0) {
        int[] tweet = tweetMap.get(data[2]).get(data[3]);
        data[3]--;
        pq.offer(new int[]{tweet[0], tweet[1], data[2], data[3]});
      }
    }

    return result; // Return the list of tweet IDs.
  }

  public void follow(int followerId, int followeeId) {
    if (!followerMap.containsKey(followerId)) {
      followerMap.put(followerId, new HashSet<>());
    }

    followerMap.get(followerId).add(followeeId);
  }

  public void unfollow(int followerId, int followeeId) {
    if (followerMap.containsKey(followerId)) {
      HashSet<Integer> set = followerMap.get(followerId);
      set.remove(followeeId);
      followerMap.put(followerId, set);
    }
  }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

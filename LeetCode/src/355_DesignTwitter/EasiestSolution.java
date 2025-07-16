/*
    * Time Complexity  = O(nlogn); n = number of followees for the user
    * Space Complexity = O(tuf); t = total number of tweets; u = number of users; f = total number of follow relationships
*/
class Twitter {
  int timestamp;
  HashMap<Integer, List<int[]>> tweetMap;
  HashMap<Integer, HashSet<Integer>> followerMap;

  public Twitter() {
    timestamp = 0;
    tweetMap = new HashMap<>();
    followerMap = new HashMap<>();
  }

  public void postTweet(int userId, int tweetId) {
    if (!tweetMap.containsKey(userId)) {
      tweetMap.put(userId, new ArrayList<>());
    }

    tweetMap.get(userId).add(new int[]{timestamp, tweetId});
    timestamp++;
  }

  public List<Integer> getNewsFeed(int userId) {
        List<int[]> allTweets = new ArrayList<>();
    
        if (!followerMap.containsKey(userId)) {
            followerMap.put(userId, new HashSet<>());
        }
        followerMap.get(userId).add(userId);

        // collect every follower's tweets
        for (int followeeId : followerMap.get(userId)) {
            if (tweetMap.containsKey(followeeId)) {
                List<int[]> tweets = tweetMap.get(followeeId);
                allTweets.addAll(tweets);
            }
        }
    
        // sort by timestamp
        allTweets.sort((a, b) -> b[0] - a[0]);
    
        List<Integer> result = new ArrayList<>();
    
        // get top 10 tweet ids based on timestamp
        for (int i = 0; i < Math.min(10, allTweets.size()); i++) {
            int[] tweet = allTweets.get(i);
            int tweetId = tweet[1];
            result.add(tweetId);
        }
    
        return result;
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
      // followerMap.get(followerId).remove(followeeId);
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

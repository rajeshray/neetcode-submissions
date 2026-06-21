class Twitter {

    data class Tweet(
        val timestamp: Int,
        val userId: Int,
        val tweetId: Int
    )

    val followMap = mutableMapOf<Int, MutableSet<Int>>()
    var timestamp = 0
    var userPosts = mutableMapOf<Int, MutableList<Tweet>>()

    fun postTweet(userId: Int, tweetId: Int) {
        userPosts.getOrPut(userId) { mutableListOf<Tweet>() }.add(
            Tweet(
                timestamp,
                userId,
                tweetId
              )
            )
        timestamp++
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val pq = PriorityQueue<Pair<Tweet, Int>>(compareByDescending { it.first.timestamp} )

        val result = mutableListOf<Int>()
    
        val allIds = mutableListOf(userId)
        followMap[userId]?.let { allIds.addAll(it) }


        for (id in allIds) {
            val tweets = userPosts[id] ?: continue
            if (tweets.isEmpty()) continue
            val index = tweets.size - 1
            pq.add(Pair(tweets[index], index))
        }

        while(pq.isNotEmpty() && result.size < 10) {
            val top = pq.poll()
            result.add(top.first.tweetId)
            val index = top.second

            if (index > 0) {
                pq.add(Pair(userPosts[top.first.userId]!![index-1],index - 1))
            }
        }

      
        return result
    }

    fun follow(followerId: Int, followeeId: Int) {
        if (followerId == followeeId) return
       followMap.getOrPut(followerId) { mutableSetOf<Int>() }.add(followeeId)

    }

    fun unfollow(followerId: Int, followeeId: Int) {
        followMap[followerId]?.remove(followeeId)
    }
}

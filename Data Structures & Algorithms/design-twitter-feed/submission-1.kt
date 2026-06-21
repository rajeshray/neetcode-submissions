class Twitter {

    data class Tweet(
        val timestamp: Int,
        val userId: Int,
        val tweetId: Int
    )

    val followMap = mutableMapOf<Int, MutableSet<Int>>()
    var timestamp = 0
    var posts = mutableListOf<Tweet>()

    fun postTweet(userId: Int, tweetId: Int) {
        posts.add(Tweet(timestamp, userId, tweetId))
        timestamp++
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val pq = PriorityQueue<Tweet>(compareBy { it.timestamp} )
        val allPosts = mutableListOf<Tweet>()
        val allIds = mutableListOf<Int>()

        allIds.add(userId)

        if (followMap[userId]?.isNotEmpty() == true) {
            allIds.addAll(followMap[userId]!!.toList())
        }

        for (eachId in allIds) {
            val postsByUser = posts?.filter {it.userId == eachId } ?: emptyList()
            allPosts.addAll(postsByUser)
        }

        for (eachPost in allPosts) {
            pq.add(eachPost) 
            if (pq.size > 10) pq.poll()
        }

        val result = mutableListOf<Int>()

        while(pq.isNotEmpty()) {
            result.add(pq.poll().tweetId)
        }

        result.reverse()

        return result
    }

    fun follow(followerId: Int, followeeId: Int) {
        if (followerId == followeeId) return
       followMap!!.getOrPut(followerId) { mutableSetOf<Int>() }.add(followeeId)

    }

    fun unfollow(followerId: Int, followeeId: Int) {
        followMap[followerId]?.remove(followeeId)
    }
}

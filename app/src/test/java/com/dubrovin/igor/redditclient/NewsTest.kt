package com.dubrovin.igor.redditclient

import com.dubrovin.igor.redditclient.data.api.news.INewsApi
import com.dubrovin.igor.redditclient.domain.entity.RedditNewsResponse
import com.dubrovin.igor.redditclient.data.repository.NewsRepository
import com.dubrovin.igor.redditclient.domain.entity.RedditChildrenResponse
import com.dubrovin.igor.redditclient.domain.entity.RedditDataResponse
import com.dubrovin.igor.redditclient.domain.entity.RedditNewsDataResponse
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.observers.TestObserver
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.junit.Before
import org.junit.Test
import retrofit2.Call
import retrofit2.Response
import java.util.*

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 13.08.2017.
 */
class NewsTest {

    lateinit var testSub: TestObserver<RedditNewsResponse>
    var apiMock = mock<INewsApi>()
    var callMock = mock<Call<RedditNewsResponse>>()

    @Before
    fun setUp(){
        whenever(apiMock.getNews(any<String>(), any<String>())).thenReturn(callMock)
    }

    @Test
    fun success_response(){
        val redditNewsResponse = RedditNewsResponse(RedditDataResponse(listOf(), null, null))
        val response = Response.success(redditNewsResponse)

        whenever(callMock.execute()).thenReturn(response)

        val newsRepository = NewsRepository(apiMock)

        testSub = newsRepository.getNews("").test()

        testSub.assertNoErrors()
        testSub.assertValueCount(1)
        testSub.assertComplete()
    }

    @Test
    fun test_success_check_one_news(){
        val redditNewsDataResponse = RedditNewsDataResponse(
                "author",
                "title",
                10,
                Date().time,
                "thumbnail",
                "url"
        )
        val redditChildrenResponse = RedditChildrenResponse(redditNewsDataResponse)
        val redditDataResponse = RedditDataResponse(listOf(redditChildrenResponse), "after", "")
        val redditNewsResponse = RedditNewsResponse(redditDataResponse)
        val response = Response.success(redditNewsResponse)

        whenever(callMock.execute()).thenReturn(response)

        val newsRepository = NewsRepository(apiMock)
        testSub = newsRepository.getNews("").test()

        testSub.assertNoErrors()
        testSub.assertValueCount(1)
        testSub.assertComplete()

        assert(testSub.values()[0].data.children[0].data.author == redditNewsDataResponse.author)
        assert(testSub.values()[0].data.children[0].data.thumbnail == redditNewsDataResponse.thumbnail)
    }

    @Test
    fun error_response(){
        val errorResponse = Response.error<RedditNewsResponse>(500, ResponseBody.create(MediaType.parse("application/json"), ""))
        whenever(callMock.execute()).thenReturn(errorResponse)

        val newsRepository = NewsRepository(apiMock)

        testSub = newsRepository.getNews("").test()

        testSub.assertError { true }
    }

}
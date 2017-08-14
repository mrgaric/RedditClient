package com.dubrovin.igor.redditclient

import com.dubrovin.igor.redditclient.data.api.news.INewsApi
import com.dubrovin.igor.redditclient.data.api.news.RedditNewsResponse
import com.dubrovin.igor.redditclient.domain.entity.RedditDataResponse
import com.dubrovin.igor.redditclient.data.repository.NewsRepository
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import retrofit2.Call
import retrofit2.Response

/**
 * JuntoTeam
 * Created by Igor Dubrovin on 13.08.2017.
 */
class NewsPresenterTest{

    var testSub = TestObserver<RedditNewsResponse>()
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

        val repo = NewsRepository()

        repo.getNews().subscribe(testSub)

        testSub.assertNoErrors()
        testSub.assertValueCount(1)
        testSub.assertComplete()
    }

}
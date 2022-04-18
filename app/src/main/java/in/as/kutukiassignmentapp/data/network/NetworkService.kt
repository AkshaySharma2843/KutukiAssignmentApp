package `in`.`as`.kutukiassignmentapp.data.network

import `in`.`as`.kutukiassignmentapp.data.model.CategoryResponse
import `in`.`as`.kutukiassignmentapp.data.model.ContentResponse
import io.reactivex.Maybe
import retrofit2.http.GET
import retrofit2.http.Url
import java.util.*


/**
 * Created by Akshay Sharma on 30-03-2022.
 */
interface NetworkService {

    @GET
    fun getCategory(
        @Url url: String
    ): Maybe<CategoryResponse>


    @GET
    fun getVideoList(
        @Url buildVideoUrl: String
    ): Maybe<ContentResponse>
}
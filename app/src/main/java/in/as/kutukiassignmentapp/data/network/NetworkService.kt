package `in`.`as`.kutukiassignmentapp.data.network

import `in`.`as`.kutukiassignmentapp.data.model.CategoryResponse
import `in`.`as`.kutukiassignmentapp.data.model.ContentResponse
import `in`.`as`.kutukiassignmentapp.data.network.request.HomeApiRequest
import `in`.`as`.kutukiassignmentapp.data.network.request.ScheduleRequest
import `in`.`as`.kutukiassignmentapp.data.network.response.HomeApiResponse
import `in`.`as`.kutukiassignmentapp.data.network.response.ScheduleResponse
import `in`.`as`.kutukiassignmentapp.data.network.response.UserPackageResponse
import io.reactivex.Maybe
import io.reactivex.Single
import retrofit2.http.*
import java.util.*


/**
 * Created by Akshay Sharma on 30-03-2022.
 */
interface NetworkService {

  @GET(Endpoints.USER_PACKAGE)
  fun fetchPackage(
      @Header(Networking.HEADER_ACCESS_TOKEN) accessToken:String?
  ) : Single<UserPackageResponse>
  @POST(Endpoints.HOME_API)
  fun fetchHomeApi(
      @Body request: HomeApiRequest,
      @Header(Networking.HEADER_ACCESS_TOKEN) accessToken: String?
  ) : Single<HomeApiResponse>

  @POST(Endpoints.SCHEDULE_DETAILS)
  fun fetchScheduleDetails(
      @Body request: ScheduleRequest,
      @Header(Networking.HEADER_ACCESS_TOKEN) accessToken: String?
  ) : Single<ScheduleResponse>
}
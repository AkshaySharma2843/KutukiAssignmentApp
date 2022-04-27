package `in`.`as`.kutukiassignmentapp.data.repository

import `in`.`as`.kutukiassignmentapp.data.network.NetworkService
import `in`.`as`.kutukiassignmentapp.data.network.request.HomeApiRequest
import `in`.`as`.kutukiassignmentapp.data.network.request.ScheduleRequest
import `in`.`as`.kutukiassignmentapp.data.network.response.HomeApiResponse
import `in`.`as`.kutukiassignmentapp.data.network.response.ScheduleResponse
import `in`.`as`.kutukiassignmentapp.data.network.response.UserPackageResponse
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Akshay Sharma on 19-04-2022.
 */
class MotionRepository @Inject constructor(val networkService: NetworkService) {

    fun getPackageDetails(
        token : String?
    ) : Single<UserPackageResponse> = networkService.fetchPackage("Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjo0NzM2NywiZXhwaXJlc19hdCI6IjIwMjItMDQtMTkgMTg6NTc6NTEifQ.oYNNAob_6imkjqL2Uma1U4age22fn_3qSTl3m5bpXqw")


    fun getHomeApiDetails(
        apkVersion : String?,
        batchId : Int?,
        classId : Int?,
        courseId : Int?,
        deviceId : String?,
        targetId : Int?,
        token: String?

    ) : Single<HomeApiResponse> = networkService.fetchHomeApi(HomeApiRequest("1.31",48,2,13,"8da15a8d2f83640b",2),"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjo0NzM2NywiZXhwaXJlc19hdCI6IjIwMjItMDQtMTkgMTg6NTc6NTEifQ.oYNNAob_6imkjqL2Uma1U4age22fn_3qSTl3m5bpXqw")

    fun getScheduleDetails(
        batchId :Int?,
        courseId: Int?,
        date : String?,
        day :String?,
        token: String?
    ) : Single<ScheduleResponse> = networkService.fetchScheduleDetails(ScheduleRequest(55,13,"2022-04-20","2022-04-20"),"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjo0NzM2NywiZXhwaXJlc19hdCI6IjIwMjItMDQtMTkgMTg6NTc6NTEifQ.oYNNAob_6imkjqL2Uma1U4age22fn_3qSTl3m5bpXqw")
}
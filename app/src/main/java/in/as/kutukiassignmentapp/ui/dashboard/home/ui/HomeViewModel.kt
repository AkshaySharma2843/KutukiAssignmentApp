package `in`.`as`.kutukiassignmentapp.ui.dashboard.home.ui

import `in`.`as`.kutukiassignmentapp.data.network.response.HomeApiResponse
import `in`.`as`.kutukiassignmentapp.data.network.response.ScheduleResponse
import `in`.`as`.kutukiassignmentapp.data.network.response.UserPackageResponse
import `in`.`as`.kutukiassignmentapp.data.repository.MotionRepository
import `in`.`as`.kutukiassignmentapp.ui.base.BaseViewModel
import `in`.`as`.kutukiassignmentapp.utils.common.Resource
import `in`.`as`.kutukiassignmentapp.utils.rx.SchedulerProvider
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Akshay Sharma on 19-04-2022.
 */
class HomeViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
   private val motionRepository: MotionRepository
) : BaseViewModel(schedulerProvider, compositeDisposable) {

   private val _userPackageLiveData = MutableLiveData<Resource<UserPackageResponse>>()
    val userPackage = _userPackageLiveData

    private val _homeApiLiveData = MutableLiveData<Resource<HomeApiResponse>>()
    val homeApiDetails = _homeApiLiveData

    private val _scheduleLiveData = MutableLiveData<Resource<ScheduleResponse>>()
    val scheduleDetails = _scheduleLiveData


    fun getUserPackage(){
        userPackage.postValue(Resource.loading())
        compositeDisposable.addAll(
            motionRepository.getPackageDetails("Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjo0NzM2NywiZXhwaXJlc19hdCI6IjIwMjItMDQtMTkgMTg6NTc6NTEifQ.oYNNAob_6imkjqL2Uma1U4age22fn_3qSTl3m5bpXqw")
                .subscribeOn(schedulerProvider.io())
                .subscribe(
                    {
                        userPackage.postValue(Resource.success(it))
                    },
                    {
                        userPackage.postValue(Resource.error())
                    }
                )
        )
    }

    fun getHomeApiDetails(){
        homeApiDetails.postValue(Resource.loading())
        compositeDisposable.addAll(
            motionRepository.getHomeApiDetails("1.31",48,2,13,"8da15a8d2f83640b",2,"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjo0NzM2NywiZXhwaXJlc19hdCI6IjIwMjItMDQtMTkgMTg6NTc6NTEifQ.oYNNAob_6imkjqL2Uma1U4age22fn_3qSTl3m5bpXqw")
                .subscribeOn(schedulerProvider.io())
                .subscribe(
                    {
                        homeApiDetails.postValue(Resource.success(it))
                    },
                    {
                        homeApiDetails.postValue(Resource.error())
                    }
                )
        )

    }

    fun getScheduleDetails(){
        scheduleDetails.postValue(Resource.loading())
        compositeDisposable.addAll(
            motionRepository.getScheduleDetails(55,13,"2022-04-20","2022-04-20","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjo0NzM2NywiZXhwaXJlc19hdCI6IjIwMjItMDQtMTkgMTg6NTc6NTEifQ.oYNNAob_6imkjqL2Uma1U4age22fn_3qSTl3m5bpXqw")
                .subscribeOn(schedulerProvider.io())
                .subscribe(
                    {
                        scheduleDetails.postValue(Resource.success(it))
                    },
                    {

                    }
                )
        )

    }

}
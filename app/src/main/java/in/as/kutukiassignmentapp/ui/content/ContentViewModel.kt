package `in`.`as`.kutukiassignmentapp.ui.content

import `in`.`as`.kutukiassignmentapp.data.model.ContentResponse
import `in`.`as`.kutukiassignmentapp.data.model.VideoDetails
import `in`.`as`.kutukiassignmentapp.data.repository.KutukiRepository
import `in`.`as`.kutukiassignmentapp.ui.base.BaseViewModel
import `in`.`as`.kutukiassignmentapp.utils.rx.SchedulerProvider
import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Akshay Sharma on 31-03-2022.
 */
class ContentViewModel(
    schedulerProvider : SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    val repository: KutukiRepository
) : BaseViewModel(
    schedulerProvider, compositeDisposable
){

    private val _videoList = MutableLiveData<ArrayList<VideoDetails>>()
    val videoList = _videoList

    val arrayListOfVideos = ArrayList<VideoDetails>()

    fun getVideList() {
        compositeDisposable.add(
            repository.getVideosList().subscribeOn(
                schedulerProvider.io()
            ).subscribe(
                {
                    mapCategoryResponse(it)
                },
                {
                    handleNetworkError()
                }
            )
        )
    }

    private fun mapCategoryResponse(data: ContentResponse) {
        data.let {
            if(it.response.videos.isNotEmpty()){
                arrayListOfVideos.addAll(it.response.videos.values)
                _videoList.postValue(arrayListOfVideos)
            }
        }
    }
}
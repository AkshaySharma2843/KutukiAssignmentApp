package `in`.`as`.kutukiassignmentapp.ui.category

import `in`.`as`.kutukiassignmentapp.data.model.CategoryResponse
import `in`.`as`.kutukiassignmentapp.data.repository.KutukiRepository
import `in`.`as`.kutukiassignmentapp.ui.base.BaseViewModel
import `in`.`as`.kutukiassignmentapp.utils.common.Resource
import `in`.`as`.kutukiassignmentapp.utils.rx.SchedulerProvider
import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by Akshay Sharma on 30-03-2022.
 */
class CategoryViewModel @Inject constructor(
     schedulerProvider: SchedulerProvider,
     compositeDisposable : CompositeDisposable,
   private val repository : KutukiRepository
) : BaseViewModel(
    schedulerProvider, compositeDisposable
){

    private val _categoryLiveData = MutableLiveData<Resource<CategoryResponse>>()
    val categoryLiveData = _categoryLiveData


    fun getCategories() {
        categoryLiveData.postValue(Resource.loading())
        compositeDisposable.addAll(
            repository.getCategories().
            subscribeOn(
                schedulerProvider.io()
            ).subscribe(
                {
                    categoryLiveData.postValue(Resource.success(it))
                },
                {
                    categoryLiveData.postValue(Resource.error())

                }
            )
        )
    }
}
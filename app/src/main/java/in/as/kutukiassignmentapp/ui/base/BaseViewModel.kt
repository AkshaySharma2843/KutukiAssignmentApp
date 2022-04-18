package `in`.`as`.kutukiassignmentapp.ui.base

import `in`.`as`.kutukiassignmentapp.utils.rx.SchedulerProvider
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Akshay Sharma on 30-03-2022.
 */
abstract class BaseViewModel(
    protected val schedulerProvider: SchedulerProvider,
    protected val compositeDisposable: CompositeDisposable,
) : ViewModel() {

    fun handleNetworkError(){

    }
}
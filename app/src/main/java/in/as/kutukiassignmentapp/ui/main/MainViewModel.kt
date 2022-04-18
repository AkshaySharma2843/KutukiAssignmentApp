package `in`.`as`.kutukiassignmentapp.ui.main

import `in`.`as`.kutukiassignmentapp.ui.base.BaseViewModel
import `in`.`as`.kutukiassignmentapp.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Akshay Sharma on 30-03-2022.
 */
class MainViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable
) : BaseViewModel(
    schedulerProvider, compositeDisposable
) {

}
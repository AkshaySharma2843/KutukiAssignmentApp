package `in`.`as`.kutukiassignmentapp.ui.dashboard.practice

import `in`.`as`.kutukiassignmentapp.data.repository.MotionRepository
import `in`.`as`.kutukiassignmentapp.ui.base.BaseViewModel
import `in`.`as`.kutukiassignmentapp.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Akshay Sharma on 19-04-2022.
 */
class PracticeViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    private val motionRepository: MotionRepository
) : BaseViewModel(schedulerProvider, compositeDisposable){
}
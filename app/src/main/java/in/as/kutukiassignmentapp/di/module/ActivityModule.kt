package `in`.`as`.kutukiassignmentapp.di.module

import `in`.`as`.kutukiassignmentapp.ui.base.BaseActivity
import `in`.`as`.kutukiassignmentapp.ui.dashboard.DashBoardViewModel
import `in`.`as`.kutukiassignmentapp.ui.main.MainViewModel
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.Module
import dagger.Provides
import `in`.`as`.kutukiassignmentapp.utils.common.ViewModelProviderFactory
import `in`.`as`.kutukiassignmentapp.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Akshay Sharma on 30-03-2022.
 */
@Module
class ActivityModule(private val activity: BaseActivity<*, *>){

    @Provides
    fun provideContext(
    ) : Context = activity

    @Provides
    fun provideLinearLayoutManager() : LinearLayoutManager = LinearLayoutManager(activity)

    @Provides
    fun provideMainViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable
    ): MainViewModel = ViewModelProvider(
        activity, ViewModelProviderFactory(MainViewModel::class) {
            MainViewModel(
                schedulerProvider, compositeDisposable
            )
        }).get(MainViewModel::class.java)


    @Provides
    fun provideDashBoardViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable
    ): DashBoardViewModel = ViewModelProvider(
        activity, ViewModelProviderFactory(DashBoardViewModel::class){
            DashBoardViewModel(
                schedulerProvider, compositeDisposable
            )
        }).get(DashBoardViewModel::class.java)


}
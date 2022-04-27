package `in`.`as`.kutukiassignmentapp.di.module

import `in`.`as`.kutukiassignmentapp.data.repository.MotionRepository
import `in`.`as`.kutukiassignmentapp.ui.base.BaseFragment
import `in`.`as`.kutukiassignmentapp.ui.dashboard.doubts.DoubtsViewModel
import `in`.`as`.kutukiassignmentapp.ui.dashboard.home.ui.HomeViewModel
import `in`.`as`.kutukiassignmentapp.ui.dashboard.practice.PracticeViewModel
import `in`.`as`.kutukiassignmentapp.ui.dashboard.profile.ProfileViewModel
import `in`.`as`.kutukiassignmentapp.ui.dashboard.store.StoreViewModel
import `in`.`as`.kutukiassignmentapp.utils.common.ViewModelProviderFactory
import `in`.`as`.kutukiassignmentapp.utils.rx.SchedulerProvider
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * Created by Akshay Sharma on 30-03-2022.
 */
@Module
class FragmentModule(private val fragment : BaseFragment<*, *>) {

    @Provides
    @Singleton
    fun provideLinearLayoutManager() : LinearLayoutManager = LinearLayoutManager(fragment.activity)

    @Provides
    fun provideHomeViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        motionRepository: MotionRepository
    ) : HomeViewModel = ViewModelProvider(fragment,ViewModelProviderFactory(HomeViewModel::class){
        HomeViewModel(schedulerProvider,compositeDisposable,motionRepository)
    }).get(HomeViewModel::class.java)

    @Provides
    fun providePracticeViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        motionRepository: MotionRepository
    ) : PracticeViewModel = ViewModelProvider(
        fragment, ViewModelProviderFactory(PracticeViewModel::class){
            PracticeViewModel(schedulerProvider,compositeDisposable,motionRepository)
        }).get(PracticeViewModel::class.java)


    @Provides
    fun provideDoubtsViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        motionRepository: MotionRepository
    ) : DoubtsViewModel = ViewModelProvider(
        fragment, ViewModelProviderFactory(DoubtsViewModel::class)
        {
            DoubtsViewModel(schedulerProvider,compositeDisposable,motionRepository)
        }).get(DoubtsViewModel::class.java)


    @Provides
    fun provideProfileViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        motionRepository: MotionRepository
    ) : ProfileViewModel = ViewModelProvider(
        fragment, ViewModelProviderFactory(ProfileViewModel::class)
        {
            ProfileViewModel(schedulerProvider,compositeDisposable,motionRepository)
        }).get(ProfileViewModel::class.java)


    @Provides
    fun provideStoreViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        motionRepository: MotionRepository
    ) : StoreViewModel = ViewModelProvider(
        fragment, ViewModelProviderFactory(StoreViewModel::class)
        {
            StoreViewModel(schedulerProvider,compositeDisposable,motionRepository)
        }).get(StoreViewModel::class.java)


}
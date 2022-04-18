package `in`.`as`.kutukiassignmentapp.di.module

import `in`.`as`.kutukiassignmentapp.data.repository.KutukiRepository
import `in`.`as`.kutukiassignmentapp.ui.base.BaseFragment
import `in`.`as`.kutukiassignmentapp.ui.category.CategoryViewModel
import `in`.`as`.kutukiassignmentapp.ui.content.ContentViewModel
import `in`.`as`.kutukiassignmentapp.ui.login.LoginViewModel
import `in`.`as`.kutukiassignmentapp.ui.register.RegisterViewModel
import `in`.`as`.kutukiassignmentapp.utils.common.ViewModelProviderFactory
import `in`.`as`.kutukiassignmentapp.utils.rx.SchedulerProvider
import android.content.SharedPreferences
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
    fun provideCategoryViewModel(
        schedulerProvider : SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        kutukiRepository: KutukiRepository
    ): CategoryViewModel = ViewModelProvider(
        fragment, ViewModelProviderFactory(CategoryViewModel::class) {
            CategoryViewModel(
                schedulerProvider,
                compositeDisposable,
                kutukiRepository
            )
        }).get(CategoryViewModel::class.java)

    @Provides
    fun provideContentViewModel(
        schedulerProvider : SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        kutukiRepository: KutukiRepository
    ): ContentViewModel = ViewModelProvider(
        fragment, ViewModelProviderFactory(ContentViewModel::class) {
            ContentViewModel(
                schedulerProvider,
                compositeDisposable,
                kutukiRepository

            )
        }).get(ContentViewModel::class.java)

    @Provides
    fun provideLoginViewModel(
        schedulerProvider : SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        sharedPreferences: SharedPreferences
    ): LoginViewModel = ViewModelProvider(
        fragment, ViewModelProviderFactory(LoginViewModel::class) {
            LoginViewModel(
                schedulerProvider,
                compositeDisposable,
                sharedPreferences
            )
        }).get(LoginViewModel::class.java)

    @Provides
    fun provideRegisterViewModel(
        schedulerProvider : SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        sharedPreferences: SharedPreferences
    ): RegisterViewModel = ViewModelProvider(
        fragment, ViewModelProviderFactory(RegisterViewModel::class) {
            RegisterViewModel(
                schedulerProvider,
                compositeDisposable,
                sharedPreferences
            )
        }).get(RegisterViewModel::class.java)

}
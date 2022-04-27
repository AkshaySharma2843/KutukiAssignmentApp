package `in`.`as`.kutukiassignmentapp.di.component

import `in`.`as`.kutukiassignmentapp.KutukiApplication
import `in`.`as`.kutukiassignmentapp.data.repository.KutukiRepository
import `in`.`as`.kutukiassignmentapp.data.repository.MotionRepository
import `in`.`as`.kutukiassignmentapp.di.module.ApplicationModule
import `in`.`as`.kutukiassignmentapp.utils.rx.SchedulerProvider
import android.content.SharedPreferences
import dagger.Component
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Akshay Sharma on 30-03-2022.
 */
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(kutukiApplication: KutukiApplication)
    fun getSchedulerProvider(): SchedulerProvider
    fun getCompositeDisposable(): CompositeDisposable
    fun getRepo(): KutukiRepository
    fun getMotionRepo() : MotionRepository
    fun getSharedPrefs() : SharedPreferences


}
package `in`.`as`.kutukiassignmentapp

import `in`.`as`.kutukiassignmentapp.di.component.ApplicationComponent
import `in`.`as`.kutukiassignmentapp.di.component.DaggerApplicationComponent
import `in`.`as`.kutukiassignmentapp.di.module.ApplicationModule
import android.app.Application
import timber.log.Timber

/**
 * Created by Akshay Sharma on 30-03-2022.
 */
class KutukiApplication : Application() {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }




}
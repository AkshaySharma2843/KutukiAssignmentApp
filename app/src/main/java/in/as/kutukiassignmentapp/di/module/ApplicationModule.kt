package `in`.`as`.kutukiassignmentapp.di.module

import `in`.`as`.kutukiassignmentapp.KutukiApplication
import `in`.`as`.kutukiassignmentapp.data.network.NetworkService
import `in`.`as`.kutukiassignmentapp.data.network.Networking
import `in`.`as`.kutukiassignmentapp.data.repository.KutukiRepository
import `in`.`as`.kutukiassignmentapp.utils.rx.RxSchedulerProvider
import `in`.`as`.kutukiassignmentapp.utils.rx.SchedulerProvider
import android.content.Context
import android.content.SharedPreferences
import androidx.viewbinding.BuildConfig
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Retrofit

/**
 * Created by Akshay Sharma on 30-03-2022.
 */
@Module
class ApplicationModule(private val application : KutukiApplication) {

    @Provides
    fun provideContext() : Context = application

    @Provides
    fun provideRetrofitInstance() : NetworkService = Networking.create()

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = RxSchedulerProvider()

    @Provides
    fun provideRepository(networkService: NetworkService) = KutukiRepository(networkService)

    @Provides
    fun provideSharedPrefs() : SharedPreferences =  application.getSharedPreferences("KUTUKI", Context.MODE_PRIVATE)



}
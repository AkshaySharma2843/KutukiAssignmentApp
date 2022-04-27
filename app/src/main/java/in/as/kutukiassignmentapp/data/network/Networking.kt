package `in`.`as`.kutukiassignmentapp.data.network

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Akshay Sharma on 30-03-2022.
 */
object Networking {

    const val HEADER_ACCESS_TOKEN = "Authorization"

    fun create(): NetworkService {
        return Retrofit.Builder()
            .baseUrl("https://quizmastertesting.motion.ac.in/motioneducation/")
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(
                        HttpLoggingInterceptor()
                            .apply {
                                level = HttpLoggingInterceptor.Level.BODY
                            })
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(NetworkService::class.java)
    }
}
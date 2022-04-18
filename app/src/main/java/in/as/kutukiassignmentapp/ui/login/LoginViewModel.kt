package `in`.`as`.kutukiassignmentapp.ui.login

import `in`.`as`.kutukiassignmentapp.ui.base.BaseViewModel
import `in`.`as`.kutukiassignmentapp.utils.common.IS_USER_LOGGED_IN
import `in`.`as`.kutukiassignmentapp.utils.rx.SchedulerProvider
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Akshay Sharma on 31-03-2022.
 */
class LoginViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    val sharedPreference : SharedPreferences
) : BaseViewModel(schedulerProvider, compositeDisposable) {

    fun saveUserLogin(toSaveUserLogin : Boolean) {
        sharedPreference.edit().putBoolean(IS_USER_LOGGED_IN, toSaveUserLogin).apply()
    }

    fun getUserLogin() = sharedPreference.getBoolean(IS_USER_LOGGED_IN, false)
}
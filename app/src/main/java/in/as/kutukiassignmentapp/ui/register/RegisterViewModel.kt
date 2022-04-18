package `in`.`as`.kutukiassignmentapp.ui.register

import `in`.`as`.kutukiassignmentapp.ui.base.BaseViewModel
import `in`.`as`.kutukiassignmentapp.utils.common.IS_USER_LOGGED_IN
import `in`.`as`.kutukiassignmentapp.utils.rx.SchedulerProvider
import android.content.SharedPreferences
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Akshay Sharma on 31-03-2022.
 */
class RegisterViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
   val sharedPreferences: SharedPreferences
) : BaseViewModel(
    schedulerProvider, compositeDisposable
) {
    fun saveUserLogin(toSaveUserLogin : Boolean) {
        sharedPreferences.edit().putBoolean(IS_USER_LOGGED_IN, toSaveUserLogin).apply()
    }

    fun getUserLogin() = sharedPreferences.getBoolean(IS_USER_LOGGED_IN, false)
}
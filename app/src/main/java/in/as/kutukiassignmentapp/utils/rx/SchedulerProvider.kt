package `in`.`as`.kutukiassignmentapp.utils.rx

import javax.inject.Singleton
import io.reactivex.Scheduler


/**
 * Created by Akshay Sharma on 30-03-2022.
 */
@Singleton
interface SchedulerProvider {

    fun computation(): Scheduler

    fun io(): Scheduler

    fun ui(): Scheduler
}
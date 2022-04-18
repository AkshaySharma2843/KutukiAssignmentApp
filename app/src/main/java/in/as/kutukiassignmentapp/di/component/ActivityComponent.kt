package `in`.`as`.kutukiassignmentapp.di.component

import `in`.`as`.kutukiassignmentapp.di.ActivityScope
import `in`.`as`.kutukiassignmentapp.di.module.ActivityModule
import `in`.`as`.kutukiassignmentapp.ui.main.MainActivity
import dagger.Component

/**
 * Created by Akshay Sharma on 30-03-2022.
 */
@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {
    fun inject(activity : MainActivity)
}

package `in`.`as`.kutukiassignmentapp.di.component

import `in`.`as`.kutukiassignmentapp.di.FragmentScope
import `in`.`as`.kutukiassignmentapp.di.module.FragmentModule
import `in`.`as`.kutukiassignmentapp.ui.dashboard.doubts.DoubtsFragment
import `in`.`as`.kutukiassignmentapp.ui.dashboard.home.ui.HomeFragment
import `in`.`as`.kutukiassignmentapp.ui.dashboard.practice.PracticeFragment
import `in`.`as`.kutukiassignmentapp.ui.dashboard.profile.ProfileFragment
import `in`.`as`.kutukiassignmentapp.ui.dashboard.store.StoreFragment
import dagger.Component

/**
 * Created by Akshay Sharma on 30-03-2022.
 */

@FragmentScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [FragmentModule::class]
)
interface FragmentComponent {

    fun inject(home: HomeFragment)
    fun inject(doubts:DoubtsFragment)
    fun inject(practice: PracticeFragment)
    fun inject(profile: ProfileFragment)
    fun inject(store: StoreFragment)



}
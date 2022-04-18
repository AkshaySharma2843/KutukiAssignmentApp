
package `in`.`as`.kutukiassignmentapp.di.component

import `in`.`as`.kutukiassignmentapp.di.FragmentScope
import `in`.`as`.kutukiassignmentapp.di.module.FragmentModule
import `in`.`as`.kutukiassignmentapp.ui.category.CategoryFragment
import `in`.`as`.kutukiassignmentapp.ui.content.ContentFragment
import `in`.`as`.kutukiassignmentapp.ui.login.LoginFragment
import `in`.`as`.kutukiassignmentapp.ui.register.RegisterFragment
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

    fun inject(login : LoginFragment)
    fun inject(registration : RegisterFragment)
    fun inject(categoryFragment: CategoryFragment)
    fun inject(contentFragment : ContentFragment)

}
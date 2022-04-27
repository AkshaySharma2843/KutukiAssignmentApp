package `in`.`as`.kutukiassignmentapp.ui.dashboard.profile

import `in`.`as`.kutukiassignmentapp.databinding.FragmentProfileBinding
import `in`.`as`.kutukiassignmentapp.di.component.FragmentComponent
import `in`.`as`.kutukiassignmentapp.ui.base.BaseFragment

/**
 * Created by Akshay Sharma on 19-04-2022.
 */
class ProfileFragment : BaseFragment<ProfileViewModel,FragmentProfileBinding>(FragmentProfileBinding::inflate) {
    override fun setupView() {

    }

    override fun injectDependencies(fragmentComponent: FragmentComponent) = fragmentComponent.inject(this)

}
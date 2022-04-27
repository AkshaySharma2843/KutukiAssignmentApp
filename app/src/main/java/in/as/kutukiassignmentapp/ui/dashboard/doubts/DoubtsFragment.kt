package `in`.`as`.kutukiassignmentapp.ui.dashboard.doubts

import `in`.`as`.kutukiassignmentapp.databinding.FragmentDoubtsBinding
import `in`.`as`.kutukiassignmentapp.di.component.FragmentComponent
import `in`.`as`.kutukiassignmentapp.ui.base.BaseFragment

/**
 * Created by Akshay Sharma on 19-04-2022.
 */
class DoubtsFragment : BaseFragment<DoubtsViewModel,FragmentDoubtsBinding>(FragmentDoubtsBinding::inflate) {

    override fun setupView() {
    }

    override fun injectDependencies(fragmentComponent: FragmentComponent) = fragmentComponent.inject(this)
}
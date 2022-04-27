package `in`.`as`.kutukiassignmentapp.ui.dashboard.practice

import `in`.`as`.kutukiassignmentapp.databinding.FragmentPracticeBinding
import `in`.`as`.kutukiassignmentapp.di.component.FragmentComponent
import `in`.`as`.kutukiassignmentapp.ui.base.BaseFragment

/**
 * Created by Akshay Sharma on 19-04-2022.
 */
class PracticeFragment : BaseFragment<PracticeViewModel,FragmentPracticeBinding>(FragmentPracticeBinding::inflate) {
    override fun setupView() {
    }

    override fun injectDependencies(fragmentComponent: FragmentComponent) = fragmentComponent.inject(this)

}
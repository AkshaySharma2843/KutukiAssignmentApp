package `in`.`as`.kutukiassignmentapp.ui.dashboard.store

import `in`.`as`.kutukiassignmentapp.databinding.FragmentStoreBinding
import `in`.`as`.kutukiassignmentapp.di.component.FragmentComponent
import `in`.`as`.kutukiassignmentapp.ui.base.BaseFragment

/**
 * Created by Akshay Sharma on 19-04-2022.
 */
class StoreFragment : BaseFragment<StoreViewModel,FragmentStoreBinding>(FragmentStoreBinding::inflate){
    override fun setupView() {

    }

    override fun injectDependencies(fragmentComponent: FragmentComponent) = fragmentComponent.inject(this)

}
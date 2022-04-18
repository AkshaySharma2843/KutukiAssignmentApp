package `in`.`as`.kutukiassignmentapp.ui.base

import `in`.`as`.kutukiassignmentapp.KutukiApplication
import `in`.`as`.kutukiassignmentapp.di.component.DaggerFragmentComponent
import `in`.`as`.kutukiassignmentapp.di.component.FragmentComponent
import `in`.`as`.kutukiassignmentapp.di.module.FragmentModule
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import javax.inject.Inject

/**
 * Created by Akshay Sharma on 30-03-2022.
 */
private typealias FragmentViewBindingInflater<VB> = (
    inflater: LayoutInflater,
    parent: ViewGroup?,
    attachToParent: Boolean
) -> VB

abstract class BaseFragment<VM : BaseViewModel, VB : ViewBinding>(
    private val bindingInflater: FragmentViewBindingInflater<VB>
) : Fragment() {

    @Inject
    lateinit var viewModel : VM

    private var _binding : VB? = null
    val binding : VB
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies(buildFragmentComponent())
        super.onCreate(savedInstanceState)
    }
    private fun buildFragmentComponent() =
        DaggerFragmentComponent
            .builder()
            .applicationComponent((requireContext().applicationContext as KutukiApplication).applicationComponent)
            .fragmentModule(FragmentModule(this))
            .build()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater.invoke(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }


    abstract fun setupView()
    protected abstract fun injectDependencies(fragmentComponent: FragmentComponent)

    @CallSuper
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package `in`.`as`.kutukiassignmentapp.ui.base

import `in`.`as`.kutukiassignmentapp.KutukiApplication
import `in`.`as`.kutukiassignmentapp.di.component.ActivityComponent
import `in`.`as`.kutukiassignmentapp.di.component.DaggerActivityComponent
import `in`.`as`.kutukiassignmentapp.di.module.ActivityModule
import android.os.Bundle
import android.view.LayoutInflater
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import javax.inject.Inject

/**
 * Created by Akshay Sharma on 30-03-2022.
 */
private typealias ActivityViewBindingInflater<VB> = (inflater: LayoutInflater) -> VB

abstract class BaseActivity<VM: BaseViewModel, VB : ViewBinding>(
    private val bindingInflater : ActivityViewBindingInflater<VB>
) : AppCompatActivity() {

    @Inject
    lateinit var viewModel: VM

    lateinit var binding: VB

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies(buildActivityComponent())
        super.onCreate(savedInstanceState)
        binding = bindingInflater.invoke(layoutInflater)
        setContentView(binding.root)
        setupView(savedInstanceState)
    }


    private fun buildActivityComponent() =
        DaggerActivityComponent
            .builder()
            .applicationComponent((application as KutukiApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build()

    protected abstract fun injectDependencies(activityComponent: ActivityComponent)
    protected abstract fun setupView(savedInstanceState: Bundle?)




}
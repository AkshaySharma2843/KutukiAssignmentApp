package `in`.`as`.kutukiassignmentapp.ui.main

import `in`.`as`.kutukiassignmentapp.databinding.ActivityMainBinding
import `in`.`as`.kutukiassignmentapp.di.component.ActivityComponent
import `in`.`as`.kutukiassignmentapp.ui.base.BaseActivity
import android.os.Bundle

class MainActivity : BaseActivity<MainViewModel,ActivityMainBinding>(ActivityMainBinding::inflate){

    override fun injectDependencies(activityComponent: ActivityComponent)  = activityComponent.inject(this)

    override fun setupView(savedInstanceState: Bundle?) {

    }


}
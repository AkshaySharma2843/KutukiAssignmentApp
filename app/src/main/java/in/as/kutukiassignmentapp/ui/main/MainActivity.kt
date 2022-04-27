package `in`.`as`.kutukiassignmentapp.ui.main

import `in`.`as`.kutukiassignmentapp.databinding.ActivityMainBinding
import `in`.`as`.kutukiassignmentapp.di.component.ActivityComponent
import `in`.`as`.kutukiassignmentapp.ui.base.BaseActivity
import `in`.`as`.kutukiassignmentapp.ui.dashboard.DashBoardActivity
import android.content.Intent
import android.os.Bundle
import android.os.Handler

class MainActivity : BaseActivity<MainViewModel,ActivityMainBinding>(ActivityMainBinding::inflate){

    override fun injectDependencies(activityComponent: ActivityComponent)  = activityComponent.inject(this)

    override fun setupView(savedInstanceState: Bundle?) {
        Handler().postDelayed({
            val intent = Intent(this,DashBoardActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        },5000)

    }


}
package `in`.`as`.kutukiassignmentapp.ui.dashboard

import `in`.`as`.kutukiassignmentapp.R
import `in`.`as`.kutukiassignmentapp.databinding.ActivityDashboardBinding
import `in`.`as`.kutukiassignmentapp.di.component.ActivityComponent
import `in`.`as`.kutukiassignmentapp.ui.base.BaseActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * Created by Akshay Sharma on 19-04-2022.
 */
class DashBoardActivity : BaseActivity<DashBoardViewModel,ActivityDashboardBinding>(ActivityDashboardBinding::inflate) {







    override fun injectDependencies(activityComponent: ActivityComponent) = activityComponent.inject(this)

    override fun setupView(savedInstanceState: Bundle?) {
        val navController = this.findNavController(R.id.nav_host_fragment)
        val navView : BottomNavigationView = findViewById(R.id.bottomNavigationView)
        NavigationUI.setupWithNavController(navView,navController)
    }

}
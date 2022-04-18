package `in`.`as`.kutukiassignmentapp.ui.login

import `in`.`as`.kutukiassignmentapp.databinding.FragmentLoginBinding
import `in`.`as`.kutukiassignmentapp.di.component.FragmentComponent
import `in`.`as`.kutukiassignmentapp.ui.base.BaseFragment
import `in`.`as`.kutukiassignmentapp.utils.common.goTo
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.text.TextUtils
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.firebase.auth.FirebaseAuth


class LoginFragment : BaseFragment<LoginViewModel,FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    private lateinit var mAuth: FirebaseAuth


    override fun setupView() {
        checkUserLogin()
        mAuth = FirebaseAuth.getInstance()
        changeOrientationAndLock()
        binding.btnRegister.setOnClickListener {
            goTo(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
        }
        binding.btnLogIn.setOnClickListener {
            loginUser()
        }

    }

    private fun checkUserLogin() {
        if(viewModel.getUserLogin()){
            goTo(LoginFragmentDirections.actionLoginFragmentToCategoryFragment())
        }
    }

    private fun loginUser() {
        val email = binding.edEmail.text.toString()
        val password = binding.edPassword.text.toString()

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(
                context,
                "Please enter email...",
                Toast.LENGTH_LONG
            ).show()
            return
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(
                context,
                "Please enter password!",
                Toast.LENGTH_LONG
            ).show()
            return
        }

        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    viewModel.saveUserLogin(true)
                    Toast.makeText(context,
                        "Login successful!",
                        Toast.LENGTH_LONG
                    ).show()
                    goTo(LoginFragmentDirections.actionLoginFragmentToCategoryFragment())
                } else {
                    Toast.makeText(
                        context,
                        "Login failed! Please try again later",
                        Toast.LENGTH_LONG
                    ).show()

                }
            }
    }


    private fun changeOrientationAndLock() {
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    }



    override fun injectDependencies(fragmentComponent: FragmentComponent) = fragmentComponent.inject(this)

}
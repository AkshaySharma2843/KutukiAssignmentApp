package `in`.`as`.kutukiassignmentapp.ui.register

import `in`.`as`.kutukiassignmentapp.R
import `in`.`as`.kutukiassignmentapp.databinding.FragmentRegisterBinding
import `in`.`as`.kutukiassignmentapp.di.component.FragmentComponent
import `in`.`as`.kutukiassignmentapp.ui.base.BaseFragment
import `in`.`as`.kutukiassignmentapp.utils.common.goTo
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.firebase.auth.FirebaseAuth


class RegisterFragment : BaseFragment<RegisterViewModel,FragmentRegisterBinding>(FragmentRegisterBinding::inflate){

    private lateinit var mAuth: FirebaseAuth


    override fun setupView() {
        mAuth = FirebaseAuth.getInstance()
        changeOrientationAndLock()
        binding.btnRegister.setOnClickListener {
            registerUser()

        }


    }

    private fun registerUser() {
        val email = binding.edEmailAddress.text.toString()
        val password = binding.edPassword.text.toString()
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(context, "Please enter email...", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(context, "Please enter password!", Toast.LENGTH_LONG).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                viewModel.saveUserLogin(true)
                if (task.isSuccessful) {
                    Toast.makeText(context,
                        "Login successful!",
                        Toast.LENGTH_LONG
                    ).show()
                    goTo(RegisterFragmentDirections.actionRegisterFragmentToCategoryFragment())
                } else {
                    Toast.makeText(
                        context,
                        "Registration failed! If you are not register please register",
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
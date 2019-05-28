package com.example.tracktruck.fragments


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tracktruck.services.*
import com.example.tracktruck.R
import com.example.tracktruck.activities.MainActivity
import com.example.tracktruck.activities.OwnerRegisterActivity
import com.example.tracktruck.activities.UserRegisterActivity
import kotlinx.android.synthetic.main.fragment_user_login.*

class UserLoginFragment : Fragment() {

    var authService = AuthenticationService()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_login, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        logineEmployeeBtn.setOnClickListener {
                view->
            loginUser(view)
        }

        RegisterText.setOnClickListener{
            view->register(view)

        }
    }

    fun loginUser(view: View){
        authService.logUser(view.context, userUserTxt.editText?.text.toString(), userPassTxt.editText?.text.toString())
        if (DataServiceU.isLogged){
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(context,"Inicio sesión exitosamente", Toast.LENGTH_LONG).show()
        }
    }

    fun register(view: View){
        val intent = Intent(context,UserRegisterActivity::class.java)
        startActivity(intent)
    }
}

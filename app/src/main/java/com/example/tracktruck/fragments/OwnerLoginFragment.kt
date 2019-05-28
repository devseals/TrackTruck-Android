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
import com.example.tracktruck.activities.AdministrativeActivity
import com.example.tracktruck.activities.MainActivity
import com.example.tracktruck.activities.OwnerRegisterActivity
import com.example.tracktruck.activities.UserRegisterActivity
import com.example.tracktruck.services.AuthenticationService
import kotlinx.android.synthetic.main.fragment_owner_login.*

class OwnerLoginFragment : Fragment() {

    val authServ = AuthenticationService()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_owner_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        logineEmployeeBtn.setOnClickListener {
                view->logOwner(view)
        }

        RegisterText.setOnClickListener{
                view->register(view)

        }
    }

    fun logOwner(view: View){
        authServ.logOwner(view.context, ownerUserTxt?.editText?.text.toString(), ownerPassTxt?.editText?.text.toString())
        if(DataServiceO.isLogged) {
            startActivity(Intent(view.context, AdministrativeActivity::class.java))
            Toast.makeText(context,"Inicio sesión exitosamente", Toast.LENGTH_LONG).show()
        }
    }
    fun register(view: View){
        val intent = Intent(context, OwnerRegisterActivity::class.java)
        startActivity(intent)

    }
}


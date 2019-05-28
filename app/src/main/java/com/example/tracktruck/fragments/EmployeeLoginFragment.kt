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
import com.example.tracktruck.activities.CreateSaleActivity
import com.example.tracktruck.activities.MainActivity
import com.example.tracktruck.services.AuthenticationService
import kotlinx.android.synthetic.main.fragment_employee_login.*

class EmployeeLoginFragment : Fragment() {

    val authServ = AuthenticationService()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_employee_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        logineEmployeeBtn.setOnClickListener {
                ret->loginEmployee(view)
        }
    }

    fun loginEmployee(view: View){
        authServ.logEmployee(view.context,
            employeeUserTxt?.editText?.text.toString(),
            employeePassTxt?.editText?.text.toString())
        if(DataServiceE.isLogged) {
            startActivity(Intent(view.context, CreateSaleActivity::class.java))
            Toast.makeText(context,"Inicio sesión exitosamente", Toast.LENGTH_LONG).show()
        }
    }

}

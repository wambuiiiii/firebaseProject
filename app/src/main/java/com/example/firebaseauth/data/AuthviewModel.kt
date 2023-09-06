package com.example.firebaseauth.data

import android.content.Context
import android.widget.Toast
import androidx.navigation.NavController
import com.example.firebase_auth.navigation.ROUTE_LOGIN
import com.example.firebase_auth.navigation.ROUTE_REGISTER
import com.google.firebase.auth.FirebaseAuth

class AuthviewModel(var navController: NavController,var context: Context){
    var mAuth:FirebaseAuth
    init {
        mAuth= FirebaseAuth.getInstance()
    }
    fun signup(email:String,pass:String,confpass:String) {
        if (email.isEmpty() || pass.isBlank() || confpass.isBlank()) {
            Toast.makeText(context, "Please email and password cannot be blank", Toast.LENGTH_LONG)
                .show()
            return
        } else if (pass != confpass) {
            Toast.makeText(context, "Password do not match", Toast.LENGTH_LONG).show()
            return
        } else {
            mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(context, "Registered sucessfully", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(context, "${it.exception!!.message}", Toast.LENGTH_LONG).show()
                }
            }

        }

    }
//    if you want the code to take you to anther page use navigation...navcontroller
    fun login(email: String, pass: String){
        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener {
         if(it.isSuccessful)  {
             Toast.makeText(context,"logged in",Toast.LENGTH_LONG).show()
             navController.navigate(ROUTE_REGISTER)
//             takes you to diff page
         }else{
             Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
         }
        }

    }
    fun logout(){
        mAuth.signOut()
        navController.navigate(ROUTE_LOGIN)
    }
//    Function to check if user is logged in
    fun loggedin():Boolean{
        return mAuth.currentUser!=null
    }
}

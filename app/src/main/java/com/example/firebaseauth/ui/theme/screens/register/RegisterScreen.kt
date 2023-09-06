package com.example.firebase_auth.ui.theme.screens.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.firebase_auth.navigation.ROUTE_LOGIN
import com.example.firebaseauth.data.AuthviewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController:NavHostController) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var pass by remember { mutableStateOf(TextFieldValue("")) }
    var confpass by remember { mutableStateOf(TextFieldValue("")) }
    var context= LocalContext.current
    Column (
        modifier= Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(
            text = "Register Here!",
            color = Color.Cyan,
            fontFamily = FontFamily.Cursive,
            fontSize = 40.sp
        )

        Spacer(modifier= Modifier.height(19.dp))

        OutlinedTextField(
            value = email ,
            label = { Text(text = "Enter Email Address")},
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            onValueChange = {
                email=it
            }
        )

        Spacer(modifier= Modifier.height(19.dp))

        OutlinedTextField(
            value = pass ,
            label = { Text(text = "Enter Password")},
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            onValueChange = {
                pass=it
            }
        )

        Spacer(modifier= Modifier.height(19.dp))

        OutlinedTextField(
            value = pass ,
            label = { Text(text = "Confirm Password")},
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            onValueChange = {
                confpass=it
            }
        )

        Spacer(modifier= Modifier.height(19.dp))

        Button(onClick = {
            var myregister= AuthviewModel(navController, context)
            myregister.signup(email.text.trim(),pass.text.trim(),confpass.text.trim())
                         },modifier = Modifier.fillMaxWidth())
        {
            Text(text = "Register")


        }

        Spacer(modifier= Modifier.height(19.dp))

        Button(onClick = {
            navController.navigate(ROUTE_LOGIN)
                         },
            modifier = Modifier.fillMaxWidth())
        {
            Text(text = "Already have an account? Click to LogIn")


        }

    }

}
@Preview
@Composable
fun RegisterPreview() {
    RegisterScreen(rememberNavController())

}

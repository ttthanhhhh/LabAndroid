package com.example.giuaki

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable("register") { RegisterScreen(navController) }
    }
}


@Composable
fun LoginScreen(navController: NavHostController) {

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Image(painter = painterResource(id = R.drawable.welcome_icon), contentDescription = "Login image")
        modifierLocalOf { Modifier.size(200.dp) }
        Text(text = "Welcome back!!", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        
        Spacer(modifier = Modifier.height(10.dp))
        
        Text(text = "Login in your account")

        Spacer(modifier = Modifier.height(16.dp))
        
        OutlinedTextField(value = email, onValueChange = {
            email = it
        }, label =   {
            Text(text = "Email adress")
        })

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = password, onValueChange = {
            password = it
        }, label = {
            Text(text = "Password")},
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password))

        Spacer(modifier = Modifier.height(16.dp))
        
        Button(onClick = {  }) {
            Text(text = "Login")
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(text = "Or sign in with")

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(40.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Image(painter = painterResource(id = R.drawable.fb_icon),
                contentDescription = "Facebook",
                modifier = Modifier
                    .size(45.dp)
                    .clickable {
                        //Facebook click
                    })

            Image(painter = painterResource(id = R.drawable.gg_icon),
                contentDescription = "Google",
                modifier = Modifier
                    .size(45.dp)
                    .clickable {
                        //Google click
                    })

            Image(painter = painterResource(id = R.drawable.tt_icon),
                contentDescription = "Twitter",
                modifier = Modifier
                    .size(45.dp)
                    .clickable {
                        //Twitter click
                    })

        }

        Spacer(modifier = Modifier.height(32.dp))
        
        Text(text = "Do not have an account?")
        Spacer(modifier = Modifier.height(12.dp))

        Text(text = "Sign Up", modifier = Modifier.clickable {
            navController.navigate("register")
        })
    }
}
@Composable
fun RegisterScreen(navController: NavHostController) {

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var retypepwd by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.b_icon), contentDescription = "SignUp image")
        modifierLocalOf { Modifier.size(200.dp) }


        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(value = email, onValueChange = {
            email = it
        }, label =   {
            Text(text = "Email adress")
        })

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = password, onValueChange = {
            password = it
        }, label =   {
            Text(text = "Password")},
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = retypepwd, onValueChange = {
            retypepwd = it
        }, label =   {
            Text(text = "Retype your password")},
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {  }) {
            Text(text = "Sign Up")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Already Register")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Sign in", modifier = Modifier.clickable {
            navController.navigate("login")
        })

    }
}









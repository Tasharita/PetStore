package com.example.petstore.ui.theme.screens.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.petstore.R
import com.example.petstore.navigation.LOGIN_URL
import com.example.petstore.ui.theme.grey1
import com.example.petstore.ui.theme.hotpink
import com.example.petstore.data.AuthViewModel
import com.example.petstore.navigation.SIGNUP_URL


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen(navController:NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
            .paint(painterResource(id = R.drawable.greenbackground), contentScale = ContentScale.FillBounds),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box {
            Column {


                Image(painter = painterResource(
                    id = R.drawable.greenicon1),
                    contentDescription = "",
                    modifier = Modifier
                        .size(170.dp)
                        .padding(30.dp))


                Text(
                    text = "PetStore",
                    fontSize = 60.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Cursive,
                    color = Color.Black
                )
            }

        }


        Spacer(modifier = Modifier.height(30.dp))

        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var name by remember { mutableStateOf("") }

        TextField(value = name,
            onValueChange = {name = it},
            placeholder = { Text(text = "Username") },
            leadingIcon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = grey1,
                focusedIndicatorColor = grey1,
                unfocusedIndicatorColor = grey1,
                cursorColor = Color.LightGray
            ),
            shape = RoundedCornerShape(5.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))


        TextField(value = email,
            onValueChange = {email = it},
            placeholder = { Text(text = "Email Address") },
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = grey1,
                focusedIndicatorColor = grey1,
                unfocusedIndicatorColor = grey1,
                cursorColor = Color.LightGray
            ),
            shape = RoundedCornerShape(5.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))


        TextField(value = password,
            onValueChange = {password = it},
            placeholder = { Text(text = "Password") },
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            visualTransformation = PasswordVisualTransformation(),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = grey1,
                focusedIndicatorColor = grey1,
                unfocusedIndicatorColor = grey1,
                cursorColor = Color.LightGray
            ),
            shape = RoundedCornerShape(5.dp)

        )

        Spacer(modifier = Modifier.height(30.dp))
        val context = LocalContext.current
        val authViewModel = AuthViewModel(navController, context)



        Box(modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
            Button(onClick = { authViewModel.signup(name, email, password) },
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(hotpink),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp)
            ) {
                Text(text = "Signup")
            }
        }



        Spacer(modifier = Modifier.height(30.dp))



        androidx.compose.material3.Text(
            text = "Already have an account? Login",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { navController.navigate(LOGIN_URL) },
            textAlign = TextAlign.Center,
            color = Color.LightGray)

    }
}

@Composable
@Preview(showBackground = true)
fun SignupScreenPreview(){

        SignupScreen(navController = rememberNavController())

}
package com.example.petstore.ui.theme.screens.upload

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.petstore.data.VeterinarianViewModel
import com.example.petstore.models.Veterinarian
import com.example.petstore.navigation.UPLOAD_URL
import com.example.petstore.ui.theme.bgreen
import com.example.petstore.ui.theme.hotpink


@Composable
fun ViewScreen(navController:NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        var context = LocalContext.current
        var vetRepository = VeterinarianViewModel(navController, context)


        val emptyVeterinarianState = remember { mutableStateOf(Veterinarian("","","","","")) }
        var emptyVeterinarianListState = remember { mutableStateListOf<Veterinarian>() }

        var vets = vetRepository.allVeterinarians(emptyVeterinarianState, emptyVeterinarianListState)


        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "All veterinarians",
                fontSize = 40.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Black,
                fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(){
                items(vets){
                    VeterinarianItem(
                        name = it.name,
                        age = it.age,
                        number = it.number,
                        id = it.id,
                        navController = navController,
                        vetRepository = vetRepository,
                        veterinarianImage = it.imageUrl
                    )
                }
            }
        }
    }
}


@Composable
fun VeterinarianItem(name:String, age:String, number:String, id:String,
                navController:NavHostController,
                vetRepository:VeterinarianViewModel, veterinarianImage:String) {

    Column(modifier = Modifier.fillMaxWidth() , horizontalAlignment = Alignment.CenterHorizontally) {

        val context = LocalContext.current




            Text(text = "Name: "+ name)
            Text(text = "Age: " +age)
            Text(text = "Phone number: " +number)
            Image(
                painter = rememberAsyncImagePainter(veterinarianImage),
                contentDescription = null,
                modifier = Modifier.size(250.dp)
            )

            Spacer(modifier = Modifier.height(3.dp))

            Text(text = "Hi there!How may I help you?")

            Spacer(modifier = Modifier.height(3.dp))

            Row {


                Button(
                    onClick = {
                        vetRepository.deleteVeterinarian(id)
                    },
                    colors = ButtonDefaults.buttonColors(hotpink)
                ) {
                    Text(text = "Delete")
                }

                Spacer(modifier = Modifier.width(10.dp))

                Button(
                    onClick = {
                        navController.navigate(UPLOAD_URL)
                    },
                    colors = ButtonDefaults.buttonColors(hotpink)
                ) {
                    Text(text = "Update")
                }

                Spacer(modifier = Modifier.width(10.dp))




            }

    }
    Spacer(modifier = Modifier.height(30.dp))
}

@Composable
@Preview(showBackground = true)
fun ViewScreenPreview(){

        ViewScreen(navController = rememberNavController())

}


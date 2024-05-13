package com.example.petstore.ui.theme.screens.upload

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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.petstore.data.VeterinarianViewModel
import com.example.petstore.models.Veterinarian


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
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Red)

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

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = name)
        Text(text = age)
        Text(text = number)
        Image(
            painter = rememberAsyncImagePainter(veterinarianImage),
            contentDescription = null,
            modifier = Modifier.size(250.dp)
        )
        Row {


            Button(onClick = {
                vetRepository.deleteVeterinarian(id)
            }) {
                Text(text = "Delete")
            }

            Spacer(modifier = Modifier.width(30.dp))

            Button(onClick = {
                //navController.navigate(ROUTE_UPDATE_VET+"/$id")
            }) {
                Text(text = "Update")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ViewScreenPreview(){

        ViewScreen(navController = rememberNavController())

}


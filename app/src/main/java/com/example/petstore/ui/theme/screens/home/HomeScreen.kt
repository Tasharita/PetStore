package com.example.petstore.ui.theme.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.petstore.R
import com.example.petstore.navigation.HOME_URL
import com.example.petstore.navigation.UPLOAD_URL
import com.example.petstore.navigation.VIEW_URL
import com.example.petstore.ui.theme.grey1
import com.example.petstore.ui.theme.hotpink


@Composable
fun HomeScreen(navController:NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(painterResource(id = R.drawable.greenbackground), contentScale = ContentScale.FillBounds),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {

        Box {
            Column {


                Image(painter = painterResource(
                    id = R.drawable.greenicon1),
                    contentDescription = "login icon",
                    modifier = Modifier
                        .size(170.dp)
                        .padding(30.dp))


                Text(
                    text = "PetStore",
                    fontSize = 60.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Cursive,
                    color = Color.Black)
            }

        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = {navController.navigate(UPLOAD_URL)},
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(hotpink),
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .padding(10.dp)
        ) {

            Text(text = "Upload Details")


        }
        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = {navController.navigate(VIEW_URL)},
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(hotpink),
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .padding(10.dp)
        ) {

            Text(text = "View Details")


        }









    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){

        HomeScreen(navController = rememberNavController())

}
package com.example.petstore.ui.theme.screens.dashboard


import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.core.net.toUri
import com.example.petstore.R
import com.example.petstore.data.AuthViewModel
import com.example.petstore.navigation.ACCESSORIES_URL
import com.example.petstore.navigation.BIRDS_URL
import com.example.petstore.navigation.CATS_URL
import com.example.petstore.navigation.DOGS_URL
import com.example.petstore.navigation.FISH_URL
import com.example.petstore.navigation.RABBITS_URL
import com.example.petstore.ui.theme.babypink
import com.example.petstore.ui.theme.hotpink


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavHostController) {

    Column (modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())){

        val context = LocalContext.current
        val authViewModel = AuthViewModel(navController, context)


        //topappbar
        TopAppBar(
            title = { Text(
                text = "PetStore",
                color = Color.LightGray,
                fontSize = 20.sp)},
            colors = TopAppBarDefaults.mediumTopAppBarColors(hotpink),
            actions = {
                IconButton(onClick = {
                    val callIntent= Intent(Intent.ACTION_DIAL)
                    callIntent.data="tel:0732849696".toUri()
                    context.startActivity(callIntent)

                }) {
                    Icon(
                        imageVector = Icons.Default.Call,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
                IconButton(onClick = {
                    val shareIntent = Intent(Intent.ACTION_SEND)
                    shareIntent.type = "text/plain"
                    shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("tasharita.neema@gmail.com"))
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Order for a pet")
                    shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello.")
                    context.startActivity(shareIntent)

                }) {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "",
                        tint = Color.White
                    )
                }

            }
        )
        //end of topappbar

        Spacer(modifier = Modifier.height(30.dp))

        Row (modifier = Modifier.padding(start = 20.dp)){

            Column {
                Text(text = "PetStore", fontSize = 45.sp, color = hotpink, fontWeight = FontWeight.ExtraBold, fontFamily = FontFamily.Serif)
                Text(text = "Your pet Your choice", fontSize = 15.sp)
            }

            Spacer(modifier = Modifier.width(80.dp))

            Image(
                painter = painterResource(id = R.drawable.cat),
                contentDescription ="" ,
                modifier = Modifier
                    .size(150.dp)
                    )

        }
        //end of row

        Spacer(modifier = Modifier.height(30.dp))

        Column (modifier = Modifier.padding(start = 20.dp)){

            Row {
                Card(modifier = Modifier
                    .clickable {
                        navController.navigate(CATS_URL)
                    }
                    .size(width = 170.dp, height = 150.dp)
                    .padding(5.dp),
                    ) {
                    Column {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            Image(
                                painter = painterResource(id = R.drawable.catsicon ),
                                contentDescription ="" ,
                                modifier = Modifier
                                    .size(70.dp),
                                contentScale = ContentScale.FillHeight)
                        }

                    }
                }
                Spacer(modifier = Modifier.width(20.dp))

                Card(modifier = Modifier
                    .size(width = 170.dp, height = 150.dp)
                    .clickable {
                        navController.navigate(DOGS_URL)
                    }
                    .padding(5.dp)
                ) {
                    Column {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            Image(
                                painter = painterResource(id = R.drawable.dogicon),
                                contentDescription ="" ,
                                modifier = Modifier
                                    .size(70.dp),
                                contentScale = ContentScale.Fit)
                        }

                    }
                }


            }
            //end of row

            Spacer(modifier = Modifier.height(30.dp))

            Row {
                Card(modifier = Modifier
                    .size(width = 170.dp, height = 150.dp)
                    .clickable {
                        navController.navigate(BIRDS_URL)
                    }
                    .padding(5.dp)
                ) {
                    Column {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            Image(
                                painter = painterResource(id = R.drawable.birdsicon),
                                contentDescription ="" ,
                                modifier = Modifier
                                    .size(70.dp),
                                contentScale = ContentScale.Crop)
                        }

                    }
                }
                Spacer(modifier = Modifier.width(20.dp))

                Card(modifier = Modifier
                    .size(width = 170.dp, height = 150.dp)
                    .clickable {
                        navController.navigate(FISH_URL)
                    }
                    .padding(5.dp)) {
                    Column {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            Image(
                                painter = painterResource(id = R.drawable.fishicon),
                                contentDescription ="" ,
                                modifier = Modifier
                                    .size(70.dp),
                                contentScale = ContentScale.Crop)
                        }

                    }
                }


            }
            //end of row

            Spacer(modifier = Modifier.height(30.dp))



            Row {
                Card(modifier = Modifier
                    .clickable {
                        navController.navigate(RABBITS_URL)
                    }
                    .size(
                        width = 170.dp, height = 150.dp
                    )
                    .padding(5.dp)) {
                    Column {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            Image(
                                painter = painterResource(id = R.drawable.rabbitsicon),
                                contentDescription ="" ,
                                modifier = Modifier
                                    .size(70.dp),
                                contentScale = ContentScale.Crop)
                        }

                    }
                }
                Spacer(modifier = Modifier.width(20.dp))

                Card(modifier = Modifier
                    .size(width = 170.dp, height = 150.dp)
                    .clickable {
                        navController.navigate(ACCESSORIES_URL)
                    }
                    .padding(5.dp)) {
                    Column {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            Image(
                                painter = painterResource(id = R.drawable.cart),
                                contentDescription ="" ,
                                modifier = Modifier
                                    .size(70.dp),
                                contentScale = ContentScale.Crop)
                        }

                    }
                }


            }
            //end of row


        }



    }

}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {

    DashboardScreen(rememberNavController())


}
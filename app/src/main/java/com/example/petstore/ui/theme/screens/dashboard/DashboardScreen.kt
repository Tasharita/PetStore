package com.example.petstore.ui.theme.screens.dashboard


import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.core.net.toUri
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.petstore.R
import com.example.petstore.data.AuthViewModel
import com.example.petstore.navigation.ACCESSORIES_URL
import com.example.petstore.navigation.BIRDS_URL
import com.example.petstore.navigation.CATS_URL
import com.example.petstore.navigation.DOGS_URL
import com.example.petstore.navigation.FEED_URL
import com.example.petstore.navigation.FISH_URL
import com.example.petstore.navigation.HOME_URL
import com.example.petstore.navigation.RABBITS_URL
import com.example.petstore.ui.theme.babyblue
import com.example.petstore.ui.theme.babypink
import com.example.petstore.ui.theme.bgreen
import com.example.petstore.ui.theme.cream
import com.example.petstore.ui.theme.grey1
import com.example.petstore.ui.theme.hotpink
import com.example.petstore.ui.theme.lightgreen
import com.example.petstore.ui.theme.orange
import com.example.petstore.ui.theme.purple


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {

        val context = LocalContext.current
        val authViewModel = AuthViewModel(navController, context)



            //topappbar
            TopAppBar(
                title = {
                    Text(
                        text = "PetStore",
                        color = Color.LightGray,
                        fontSize = 20.sp
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(hotpink),
                actions = {
                    IconButton(onClick = {
                        val callIntent = Intent(Intent.ACTION_DIAL)
                        callIntent.data = "tel:0732849696".toUri()
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
                        shareIntent.putExtra(
                            Intent.EXTRA_EMAIL,
                            arrayOf("tasharita.neema@gmail.com")
                        )
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

        Spacer(modifier = Modifier.height(10.dp))





                Text(
                    text = "Welcome",
                    fontSize = 45.sp,
                    color = hotpink,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily.Serif,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(start= 60.dp)
                )
                Text(text = "Make a new friend.",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Cursive,
                    modifier = Modifier
                        .padding(start= 100.dp)
                )









            //end of row


        Spacer(modifier = Modifier.height(10.dp))

        Column(modifier = Modifier.padding(start = 10.dp, end = 10.dp)) {

            //card 1

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(10.dp)
                    .clickable {
                        navController.navigate(CATS_URL)
                    },
                colors = CardDefaults.cardColors(bgreen)
            ) {

                Row {
                    Image(
                        painter = painterResource(id = R.drawable.catimage),
                        contentDescription = "",
                        modifier = Modifier
                            .size(60.dp)
                            .padding(start = 10.dp, top = 10.dp)
                            .clip(shape = CircleShape),
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    Column {
                        androidx.compose.material3.Text(
                            text = "Cat-Store",
                            fontWeight = FontWeight.Bold,
                            fontSize = 22.sp,
                            modifier = Modifier.fillMaxHeight()
                        )

                    }

                }
            }

            //end of card 1

            //card 2

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(10.dp)
                    .clickable {
                        navController.navigate(DOGS_URL)
                    },
                colors = CardDefaults.cardColors(bgreen)
            ) {

                Row {
                    Image(
                        painter = painterResource(id = R.drawable.dogimage),
                        contentDescription = "",
                        modifier = Modifier
                            .size(60.dp)
                            .padding(start = 10.dp, top = 10.dp)
                            .clip(shape = CircleShape),
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    Column {
                        androidx.compose.material3.Text(
                            text = "Dog-Store",
                            fontWeight = FontWeight.Bold,
                            fontSize = 22.sp,
                            modifier = Modifier.fillMaxHeight()
                        )

                    }

                }
            }

            //end of card 2

            //card 3

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(10.dp)
                    .clickable {
                        navController.navigate(BIRDS_URL)
                    },
                colors = CardDefaults.cardColors(bgreen)
            ) {

                Row {
                    Image(
                        painter = painterResource(id = R.drawable.birdimage),
                        contentDescription = "",
                        modifier = Modifier
                            .size(60.dp)
                            .padding(start = 10.dp, top = 10.dp)
                            .clip(shape = CircleShape),
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    Column {
                        androidx.compose.material3.Text(
                            text = "Bird-Store",
                            fontWeight = FontWeight.Bold,
                            fontSize = 22.sp,
                            modifier = Modifier.fillMaxHeight()
                        )

                    }

                }
            }

            //end of card 3

            //card 4

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(10.dp)
                    .clickable {
                        navController.navigate(FISH_URL)
                    },
                colors = CardDefaults.cardColors(bgreen)
            ) {

                Row {
                    Image(
                        painter = painterResource(id = R.drawable.fishimage),
                        contentDescription = "",
                        modifier = Modifier
                            .size(60.dp)
                            .padding(start = 10.dp, top = 10.dp)
                            .clip(shape = CircleShape),
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    Column {
                        androidx.compose.material3.Text(
                            text = "Fish-Store",
                            fontWeight = FontWeight.Bold,
                            fontSize = 22.sp,
                            modifier = Modifier.fillMaxHeight()
                        )

                    }

                }
            }

            //end of card 4

            //card 5

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(10.dp)
                    .clickable {
                        navController.navigate(RABBITS_URL)
                    },
                colors = CardDefaults.cardColors(bgreen)
            ) {

                Row {
                    Image(
                        painter = painterResource(id = R.drawable.rabbitimage),
                        contentDescription = "",
                        modifier = Modifier
                            .size(60.dp)
                            .padding(start = 10.dp, top = 10.dp)
                            .clip(shape = CircleShape),
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    Column {
                        androidx.compose.material3.Text(
                            text = "Rabbit-Store",
                            fontWeight = FontWeight.Bold,
                            fontSize = 22.sp,
                            modifier = Modifier.fillMaxHeight()
                        )

                    }

                }
            }

            //end of card 5

            //card 6

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(10.dp)
                    .clickable {
                        navController.navigate(FEED_URL)
                    },
                colors = CardDefaults.cardColors(bgreen)
            ) {

                Row {
                    Image(
                        painter = painterResource(id = R.drawable.bravo),
                        contentDescription = "",
                        modifier = Modifier
                            .size(60.dp)
                            .padding(start = 10.dp, top = 10.dp)
                            .clip(shape = CircleShape),
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    Column {
                        androidx.compose.material3.Text(
                            text = "Feeds",
                            fontWeight = FontWeight.Bold,
                            fontSize = 22.sp,
                            modifier = Modifier.fillMaxHeight()
                        )

                    }

                }
            }

            //end of card 6

            //card 7

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(10.dp)
                    .clickable {
                        navController.navigate(ACCESSORIES_URL)
                    },
                colors = CardDefaults.cardColors(bgreen)
            ) {

                Row {
                    Image(
                        painter = painterResource(id = R.drawable.doghouse),
                        contentDescription = "",
                        modifier = Modifier
                            .size(60.dp)
                            .padding(start = 10.dp, top = 10.dp)
                            .clip(shape = CircleShape),
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    Column {
                        androidx.compose.material3.Text(
                            text = "Accessories",
                            fontWeight = FontWeight.Bold,
                            fontSize = 22.sp,
                            modifier = Modifier.fillMaxHeight()
                        )

                    }

                }
            }

            //end of card 7
            
            Button(onClick = {navController.navigate(HOME_URL)},
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(grey1),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(10.dp)
            ) {

                Text(text = "I am a veterinarian")

                
            }


        }
    }
}











@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {

    DashboardScreen(rememberNavController())


}
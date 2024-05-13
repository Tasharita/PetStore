package com.example.petstore.ui.theme.screens.accessories

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.petstore.R
import com.example.petstore.data.AuthViewModel
import com.example.petstore.navigation.DASHBOARD_URL
import com.example.petstore.navigation.DOGS_URL

import com.example.petstore.navigation.FEED_URL
import com.example.petstore.navigation.SIGNUP_URL
import com.example.petstore.ui.theme.cream
import com.example.petstore.ui.theme.grey1
import com.example.petstore.ui.theme.hotpink
import com.example.petstore.ui.theme.orange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccessoriesScreen(navController:NavHostController){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val context = LocalContext.current
        val authViewModel = AuthViewModel(navController, context)

        TopAppBar(title = { Text(text = "Accessories") },
            colors = TopAppBarDefaults.mediumTopAppBarColors(grey1),
            navigationIcon = {
                IconButton(onClick = { navController.navigate(DASHBOARD_URL) }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "",
                        tint = Color.Black
                    )
                }
            },
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

            })


        Spacer(modifier = Modifier.height(10.dp))

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(start = 5.dp)
        ) {
            //ROW1
            Row(modifier = Modifier.fillMaxWidth()) {

                Card(modifier = Modifier
                    .height(205.dp)
                    .width(170.dp)) {

                    Column {
                        Box (
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp),
                            contentAlignment = Alignment.Center)
                        {
                            Image(painter = painterResource(id = R.drawable.aquarium),
                                contentDescription ="",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop)
                        }

                        Spacer(modifier = Modifier.height(3.dp))

                        Text(
                            text = "Aquarium",
                            fontSize = 25.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(3.dp))

                        Text(text = "Ksh. 3208",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth())

                        Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

                            TextButton(onClick = { val simToolKitLaunchIntent =
                                context.packageManager.getLaunchIntentForPackage("com.android.stk")
                                simToolKitLaunchIntent?.let { context.startActivity(it)} },
                            ) {
                                Text(text = "Pay", color = grey1)
                            }

                            TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                                callIntent.data="tel:0732849696".toUri()
                                context.startActivity(callIntent) },
                            ) {
                                Text(text = "Call", color = grey1)
                            }

                        }
                    }

                }

                //END OF CARD 1

                Spacer(modifier = Modifier.width(10.dp))

                Card(modifier = Modifier
                    .height(205.dp)
                    .width(170.dp)) {

                    Column {
                        Box (
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp),
                            contentAlignment = Alignment.Center)
                        {
                            Image(painter = painterResource(id = R.drawable.balltoys),
                                contentDescription ="",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop)
                        }


                        Spacer(modifier = Modifier.height(3.dp))

                        Text(
                            text = "Ball toys",
                            fontSize = 25.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(3.dp))

                        Text(text = "Ksh. 600",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth())

                        Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

                            TextButton(onClick = { val simToolKitLaunchIntent =
                                context.packageManager.getLaunchIntentForPackage("com.android.stk")
                                simToolKitLaunchIntent?.let { context.startActivity(it)} },
                            ) {
                                Text(text = "Pay", color = grey1)
                            }

                            TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                                callIntent.data="tel:0732849696".toUri()
                                context.startActivity(callIntent) },
                            ) {
                                Text(text = "Call", color = grey1)
                            }

                        }
                    }

                }

                //END OF CARD 2
            }
            //end of row1

            Spacer(modifier = Modifier.height(10.dp))

            //ROW2
            Row(modifier = Modifier.fillMaxWidth()) {

                Card(modifier = Modifier
                    .height(205.dp)
                    .width(170.dp)) {

                    Column {
                        Box (
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp),
                            contentAlignment = Alignment.Center)
                        {
                            Image(painter = painterResource(id = R.drawable.cattoy),
                                contentDescription ="",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop)
                        }

                        Spacer(modifier = Modifier.height(3.dp))

                        Text(
                            text = "Cat toy",
                            fontSize = 25.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(3.dp))

                        Text(text = "Ksh. 255",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth())

                        Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

                            TextButton(onClick = { val simToolKitLaunchIntent =
                                context.packageManager.getLaunchIntentForPackage("com.android.stk")
                                simToolKitLaunchIntent?.let { context.startActivity(it)} },
                            ) {
                                Text(text = "Pay", color = grey1)
                            }

                            TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                                callIntent.data="tel:0732849696".toUri()
                                context.startActivity(callIntent) },
                            ) {
                                Text(text = "Call", color = grey1)
                            }

                        }
                    }

                }

                //END OF CARD 1

                Spacer(modifier = Modifier.width(10.dp))

                Card(modifier = Modifier
                    .height(205.dp)
                    .width(170.dp)) {

                    Column {
                        Box (
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp),
                            contentAlignment = Alignment.Center)
                        {
                            Image(painter = painterResource(id = R.drawable.chewtoy),
                                contentDescription ="",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop)
                        }


                        Spacer(modifier = Modifier.height(3.dp))

                        Text(
                            text = "Chew toy",
                            fontSize = 25.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(3.dp))

                        Text(text = "Ksh. 448",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth())

                        Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

                            TextButton(onClick = { val simToolKitLaunchIntent =
                                context.packageManager.getLaunchIntentForPackage("com.android.stk")
                                simToolKitLaunchIntent?.let { context.startActivity(it)} },
                            ) {
                                Text(text = "Pay", color = grey1)
                            }

                            TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                                callIntent.data="tel:0732849696".toUri()
                                context.startActivity(callIntent) },
                            ) {
                                Text(text = "Call", color = grey1)
                            }

                        }
                    }

                }

                //END OF CARD 2
            }
            //end of row2

            Spacer(modifier = Modifier.height(10.dp))

            //ROW3
            Row(modifier = Modifier.fillMaxWidth()) {

                Card(modifier = Modifier
                    .height(205.dp)
                    .width(170.dp)) {

                    Column {
                        Box (
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp),
                            contentAlignment = Alignment.Center)
                        {
                            Image(painter = painterResource(id = R.drawable.dogshampoo),
                                contentDescription ="",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop)
                        }

                        Spacer(modifier = Modifier.height(3.dp))

                        Text(
                            text = "Dog shampoo",
                            fontSize = 25.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(3.dp))

                        Text(text = "Ksh. 700",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth())

                        Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

                            TextButton(onClick = { val simToolKitLaunchIntent =
                                context.packageManager.getLaunchIntentForPackage("com.android.stk")
                                simToolKitLaunchIntent?.let { context.startActivity(it)} },
                            ) {
                                Text(text = "Pay", color = grey1)
                            }

                            TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                                callIntent.data="tel:0732849696".toUri()
                                context.startActivity(callIntent) },
                            ) {
                                Text(text = "Call", color = grey1)
                            }

                        }
                    }

                }

                //END OF CARD 1

                Spacer(modifier = Modifier.width(10.dp))

                Card(modifier = Modifier
                    .height(205.dp)
                    .width(170.dp)) {

                    Column {
                        Box (
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp),
                            contentAlignment = Alignment.Center)
                        {
                            Image(painter = painterResource(id = R.drawable.fishtank),
                                contentDescription ="",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop)
                        }


                        Spacer(modifier = Modifier.height(3.dp))

                        Text(
                            text = "Fish tank",
                            fontSize = 25.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(3.dp))

                        Text(text = "Ksh. 1090",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth())

                        Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

                            TextButton(onClick = { val simToolKitLaunchIntent =
                                context.packageManager.getLaunchIntentForPackage("com.android.stk")
                                simToolKitLaunchIntent?.let { context.startActivity(it)} },
                            ) {
                                Text(text = "Pay", color = grey1)
                            }

                            TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                                callIntent.data="tel:0732849696".toUri()
                                context.startActivity(callIntent) },
                            ) {
                                Text(text = "Call", color = grey1)
                            }

                        }
                    }

                }

                //END OF CARD 2
            }
            //end of row3

            Spacer(modifier = Modifier.height(10.dp))

            //ROW4
            Row(modifier = Modifier.fillMaxWidth()) {

                Card(modifier = Modifier
                    .height(205.dp)
                    .width(170.dp)) {

                    Column {
                        Box (
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp),
                            contentAlignment = Alignment.Center)
                        {
                            Image(painter = painterResource(id = R.drawable.petbowl),
                                contentDescription ="",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop)
                        }

                        Spacer(modifier = Modifier.height(3.dp))

                        Text(
                            text = "Pet bowl",
                            fontSize = 25.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(3.dp))

                        Text(text = "Ksh. 380",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth())

                        Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

                            TextButton(onClick = { val simToolKitLaunchIntent =
                                context.packageManager.getLaunchIntentForPackage("com.android.stk")
                                simToolKitLaunchIntent?.let { context.startActivity(it)} },
                            ) {
                                Text(text = "Pay", color = grey1)
                            }

                            TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                                callIntent.data="tel:0732849696".toUri()
                                context.startActivity(callIntent) },
                            ) {
                                Text(text = "Call", color = grey1)
                            }

                        }
                    }

                }

                //END OF CARD 1

                Spacer(modifier = Modifier.width(10.dp))

                Card(modifier = Modifier
                    .height(205.dp)
                    .width(170.dp)) {

                    Column {
                        Box (
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp),
                            contentAlignment = Alignment.Center)
                        {
                            Image(painter = painterResource(id = R.drawable.rabbithome),
                                contentDescription ="",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop)
                        }


                        Spacer(modifier = Modifier.height(3.dp))

                        Text(
                            text = "Rabbit home",
                            fontSize = 25.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(3.dp))

                        Text(text = "Ksh. 20000",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth())

                        Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

                            TextButton(onClick = { val simToolKitLaunchIntent =
                                context.packageManager.getLaunchIntentForPackage("com.android.stk")
                                simToolKitLaunchIntent?.let { context.startActivity(it)} },
                            ) {
                                Text(text = "Pay", color = grey1)
                            }

                            TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                                callIntent.data="tel:0732849696".toUri()
                                context.startActivity(callIntent) },
                            ) {
                                Text(text = "Call", color = grey1)
                            }

                        }
                    }

                }

                //END OF CARD 2
            }
            //end of row4

            Spacer(modifier = Modifier.height(10.dp))

            //ROW5
            Row(modifier = Modifier.fillMaxWidth()) {

                Card(modifier = Modifier
                    .height(205.dp)
                    .width(170.dp)) {

                    Column {
                        Box (
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp),
                            contentAlignment = Alignment.Center)
                        {
                            Image(painter = painterResource(id = R.drawable.rabbittoys),
                                contentDescription ="",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop)
                        }

                        Spacer(modifier = Modifier.height(3.dp))

                        Text(
                            text = "Rabbit toys",
                            fontSize = 25.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(3.dp))

                        Text(text = "Ksh. 6000",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth())

                        Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

                            TextButton(onClick = { val simToolKitLaunchIntent =
                                context.packageManager.getLaunchIntentForPackage("com.android.stk")
                                simToolKitLaunchIntent?.let { context.startActivity(it)} },
                            ) {
                                Text(text = "Pay", color = grey1)
                            }

                            TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                                callIntent.data="tel:0732849696".toUri()
                                context.startActivity(callIntent) },
                            ) {
                                Text(text = "Call", color = grey1)
                            }

                        }
                    }

                }

                //END OF CARD 1

                Spacer(modifier = Modifier.width(10.dp))

                Card(modifier = Modifier
                    .height(205.dp)
                    .width(170.dp)) {

                    Column {
                        Box (
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp),
                            contentAlignment = Alignment.Center)
                        {
                            Image(painter = painterResource(id = R.drawable.petplate),
                                contentDescription ="",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop)
                        }


                        Spacer(modifier = Modifier.height(3.dp))

                        Text(
                            text = "Pet plate",
                            fontSize = 25.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(3.dp))

                        Text(text = "Ksh. 260",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth())

                        Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

                            TextButton(onClick = { val simToolKitLaunchIntent =
                                context.packageManager.getLaunchIntentForPackage("com.android.stk")
                                simToolKitLaunchIntent?.let { context.startActivity(it)} },
                            ) {
                                Text(text = "Pay", color = grey1)
                            }

                            TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                                callIntent.data="tel:0732849696".toUri()
                                context.startActivity(callIntent) },
                            ) {
                                Text(text = "Call", color = grey1)
                            }

                        }
                    }

                }

                //END OF CARD 2
            }
            //end of row5

            Spacer(modifier = Modifier.height(10.dp))

            //ROW6
            Row(modifier = Modifier.fillMaxWidth()) {

                Card(modifier = Modifier
                    .height(205.dp)
                    .width(170.dp)) {

                    Column {
                        Box (
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp),
                            contentAlignment = Alignment.Center)
                        {
                            Image(painter = painterResource(id = R.drawable.floatingbetta),
                                contentDescription ="",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop)
                        }

                        Spacer(modifier = Modifier.height(3.dp))

                        Text(
                            text = "Floating betta",
                            fontSize = 25.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(3.dp))

                        Text(text = "Ksh. 3000",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth())

                        Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

                            TextButton(onClick = { val simToolKitLaunchIntent =
                                context.packageManager.getLaunchIntentForPackage("com.android.stk")
                                simToolKitLaunchIntent?.let { context.startActivity(it)} },
                            ) {
                                Text(text = "Pay", color = grey1)
                            }

                            TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                                callIntent.data="tel:0732849696".toUri()
                                context.startActivity(callIntent) },
                            ) {
                                Text(text = "Call", color = grey1)
                            }

                        }
                    }

                }

                //END OF CARD 1

                Spacer(modifier = Modifier.width(10.dp))

                Card(modifier = Modifier
                    .height(205.dp)
                    .width(170.dp)) {

                    Column {
                        Box (
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp),
                            contentAlignment = Alignment.Center)
                        {
                            Image(painter = painterResource(id = R.drawable.petbed),
                                contentDescription ="",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop)
                        }


                        Spacer(modifier = Modifier.height(3.dp))

                        Text(
                            text = "Pet bed",
                            fontSize = 25.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(3.dp))

                        Text(text = "Ksh. 2000",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth())

                        Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

                            TextButton(onClick = { val simToolKitLaunchIntent =
                                context.packageManager.getLaunchIntentForPackage("com.android.stk")
                                simToolKitLaunchIntent?.let { context.startActivity(it)} },
                            ) {
                                Text(text = "Pay", color = grey1)
                            }

                            TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                                callIntent.data="tel:0732849696".toUri()
                                context.startActivity(callIntent) },
                            ) {
                                Text(text = "Call", color = grey1)
                            }

                        }
                    }

                }

                //END OF CARD 2
            }
            //end of row6






        }
    }
}

@Composable
@Preview(showBackground = true)
fun AccessoriesScreenPreview(){

    AccessoriesScreen(navController = rememberNavController())

}

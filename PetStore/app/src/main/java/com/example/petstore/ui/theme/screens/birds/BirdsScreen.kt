package com.example.petstore.ui.theme.screens.birds

import android.content.Intent
import android.widget.Toast
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
import com.example.petstore.ui.theme.babypink
import com.example.petstore.ui.theme.green
import com.example.petstore.ui.theme.lightgreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BirdsScreen(navController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val context = LocalContext.current
        val authViewModel = AuthViewModel(navController, context)

        TopAppBar(title = { Text(text = "Bird-Store") },
            colors = TopAppBarDefaults.mediumTopAppBarColors(lightgreen),
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

            })


        Box (modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
            contentAlignment = Alignment.BottomStart){

            Image(painter = painterResource(id = R.drawable.birdimage),
                contentDescription = "",
                modifier = Modifier
                    .clickable {
                        Toast
                            .makeText(
                                context, "Birds", Toast.LENGTH_SHORT
                            )
                            .show()

                    }
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column {
                Text(text = "BIRD-STORE",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = lightgreen,
                    textAlign = TextAlign.Right
                )
                Text(text = "Pick your Favorite bird", fontSize = 20.sp, color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "Parrot"
            ,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )


        //row1

        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {


            Card(modifier = Modifier
                .height(225.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.par1),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Abby",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "Age: 9 months",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 2000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row(modifier = Modifier.fillMaxWidth()) {

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = green)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = green)
                        }

                    }
                }

            }

            //END OF CARD 1

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(225.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.par2),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Paul",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "Age: 2 years",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 2000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth()){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = green)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = green)
                        }

                    }
                }

            }

            //END OF CARD 2

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(225.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.par3),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Mayla",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "Age: 4 months",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 2000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth()){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = green)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = green)
                        }

                    }
                }

            }

            //END OF CARD 3

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(225.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.par4),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Anna",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "Age: 6 months",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 2000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth()){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = green)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = green)
                        }

                    }
                }

            }

            //END OF CARD 4

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(225.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.par5),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Tim",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "Age: 6 months",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 2000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row(modifier = Modifier.fillMaxWidth()) {

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = green)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = green)
                        }

                    }
                }

            }

            //END OF CARD 5

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(225.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.par6),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Trizzah",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "Age: 4 months",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 2000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth()){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = green)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = green)
                        }

                    }
                }

            }

            //END OF CARD 6
        }
        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "Diamond Dove"
            ,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )


        //row2

        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {


            Card(modifier = Modifier
                .height(225.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.dove1),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Daisy",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "Age: 8 months",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 2000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth()){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = green)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = green)
                        }

                    }
                }

            }

            //END OF CARD 1

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(225.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.dove2),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Dyla",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "Age: 1 year",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 2000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth()){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = green)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = green)
                        }

                    }
                }

            }

            //END OF CARD 2

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(225.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.dove3),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Lynne",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "Age: 1 month",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 2000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth()){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = green)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = green)
                        }

                    }
                }

            }

            //END OF CARD 3

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(225.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.dove4),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Lala",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "Age: 3 years",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 2000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth()){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = green)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = green)
                        }

                    }
                }

            }

            //END OF CARD 4

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(225.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.dove5),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Rita",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "Age: 2 years",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 2000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row(modifier = Modifier.fillMaxWidth()) {

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = green)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = green)
                        }

                    }
                }

            }

            //END OF CARD 5

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(225.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.dove6),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Talie",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "Age: 11 months",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 2000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth()){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = green)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = green)
                        }

                    }
                }

            }

            //END OF CARD 6
        }

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "Finches"
            ,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )

        //row3

        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {


            Card(modifier = Modifier
                .height(225.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.finch1),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Adrian",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "Age: 5 months",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 2000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row(modifier = Modifier.fillMaxWidth()) {

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = green)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = green)
                        }

                    }
                }

            }

            //END OF CARD 1

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(225.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.finch2),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Fin",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "Age: 3 months",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 2000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth()){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = green)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = green)
                        }

                    }
                }

            }

            //END OF CARD 2

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(225.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.finch3),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Trina",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "Age: 2 months",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 2000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row(modifier = Modifier.fillMaxWidth()) {

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = green)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = green)
                        }

                    }
                }

            }

            //END OF CARD 3

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(225.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.finch4),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Terry",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "Age: 4 months",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 2000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row(modifier = Modifier.fillMaxWidth()) {

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = green)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = green)
                        }

                    }
                }

            }

            //END OF CARD 4

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(225.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.finch5),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Lily",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "Age: 1 year",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 2000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth()){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = green)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = green)
                        }

                    }
                }

            }

            //END OF CARD 5

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(225.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.finch6),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Marcos",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "Age: 2 years",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 2000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth()){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = green)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = green)
                        }

                    }
                }

            }

            //END OF CARD 6
        }

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "Conures"
            ,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )



        //row3

        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {


            Card(modifier = Modifier
                .height(225.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.con1),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Ray",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "Age: 5 months",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 2000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row(modifier = Modifier.fillMaxWidth()) {

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = green)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = green)
                        }

                    }
                }

            }

            //END OF CARD 1

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(225.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.con2),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Kenzie",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "Age: 2 years",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 2000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth()){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = green)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = green)
                        }

                    }
                }

            }

            //END OF CARD 2

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(225.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.con3),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Trish",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "Age: 3 years",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 2000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row(modifier = Modifier.fillMaxWidth()) {

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = green)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = green)
                        }

                    }
                }

            }

            //END OF CARD 3

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(225.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.con4),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Jay",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "Age: 1 year",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 2000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row(modifier = Modifier.fillMaxWidth()) {

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = green)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = green)
                        }

                    }
                }

            }

            //END OF CARD 4

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(225.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.con5),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Glory",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "Age: 2 years",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 2000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth()){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = green)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = green)
                        }

                    }
                }

            }

            //END OF CARD 5

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(225.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.con6),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Myles",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "Age: 1 year",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 2000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth()){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = green)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = green)
                        }

                    }
                }

            }

            //END OF CARD 6
        }






    }
}

@Composable
@Preview(showBackground = true)
fun BirdsScreenPreview(){

    BirdsScreen(navController = rememberNavController())

}


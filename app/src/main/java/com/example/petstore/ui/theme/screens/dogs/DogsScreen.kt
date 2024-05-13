package com.example.petstore.ui.theme.screens.dogs

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
import androidx.compose.foundation.layout.padding
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
import com.example.petstore.ui.theme.babyblue
import com.example.petstore.ui.theme.babypink

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DogsScreen(navController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val context = LocalContext.current
        val authViewModel = AuthViewModel(navController, context)

        TopAppBar(title = { Text(text = "Dog-Store") },
            colors = TopAppBarDefaults.mediumTopAppBarColors(babyblue),
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

            Image(painter = painterResource(id = R.drawable.dogimage),
                contentDescription = "",
                modifier = Modifier
                    .clickable {
                        Toast
                            .makeText(
                                context, "Dogs", Toast.LENGTH_SHORT
                            )
                            .show()

                    }
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column {
                Text(text = "DOG-STORE",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = babyblue,
                    textAlign = TextAlign.Right
                )
                Text(text = "Pick your Favorite Dog", fontSize = 20.sp, color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "Japanese Spitz"
            ,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
        Text(
            text = "(Life-span: 12 - 14 years)"
            ,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        //row1

        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {


            Card(modifier = Modifier
                .height(226.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.spitz1),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Drexie",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "Age: 4 month",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 5000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babyblue)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babyblue)
                        }

                    }
                }

            }

            //END OF CARD 1

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(226.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.spitz2),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Neo",
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

                    Text(text = "Ksh. 6500",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babyblue)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babyblue)
                        }

                    }
                }

            }

            //END OF CARD 2

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(226.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.spitz3),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Spots",
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

                    Text(text = "Ksh. 5500",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babyblue)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babyblue)
                        }

                    }
                }

            }

            //END OF CARD 3

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(226.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.spitz4),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Mike",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "Age: 2 month",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 5000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babyblue)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babyblue)
                        }

                    }
                }

            }

            //END OF CARD 4

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(226.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.spitz5),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Aliyah",
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

                    Text(text = "Ksh. 5000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babyblue)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babyblue)
                        }

                    }
                }

            }

            //END OF CARD 5

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(226.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.spitz6),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Cliffe",
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

                    Text(text = "Ksh. 5500",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babyblue)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babyblue)
                        }

                    }
                }

            }

            //END OF CARD 6
        }
        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "Pomeranian dog"
            ,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
        Text(
            text = "(Life-span: 12 - 16 years)"
            ,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        //row2

        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {


            Card(modifier = Modifier
                .height(226.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.pom1),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Louis",
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

                    Text(text = "Ksh. 5000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babyblue)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babyblue)
                        }

                    }
                }

            }

            //END OF CARD 1

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(226.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.pom2),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Kemmy",
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

                    Text(text = "Ksh. 7000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babyblue)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babyblue)
                        }

                    }
                }

            }

            //END OF CARD 2

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(226.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.pom3),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Rey",
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

                    Text(text = "Ksh. 5000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babyblue)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babyblue)
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
                        Image(painter = painterResource(id = R.drawable.pom4),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Rex",
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

                    Text(text = "Ksh. 5500",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babyblue)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babyblue)
                        }

                    }
                }

            }

            //END OF CARD 4

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(226.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.pom5),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Tom",
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

                    Text(text = "Ksh. 5500",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babyblue)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babyblue)
                        }

                    }
                }

            }

            //END OF CARD 5

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(226.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.pom6),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Timmy",
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

                    Text(text = "Ksh. 6000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babyblue)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babyblue)
                        }

                    }
                }

            }

            //END OF CARD 6
        }

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "Maltese"
            ,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
        Text(
            text = "(Life-span: 12 - 15 years)"
            ,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        //row3

        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {


            Card(modifier = Modifier
                .height(226.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.malt1),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Val",
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

                    Text(text = "Ksh. 5000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babyblue)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babyblue)
                        }

                    }
                }

            }

            //END OF CARD 1

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(226.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.malt2),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Giddy",
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

                    Text(text = "Ksh. 5500",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babyblue)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babyblue)
                        }

                    }
                }

            }

            //END OF CARD 2

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(226.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.malt3),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Tiana",
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

                    Text(text = "Ksh. 7000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babyblue)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babyblue)
                        }

                    }
                }

            }

            //END OF CARD 3

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(226.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.malt4),
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
                        text = "Age: 5 months",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 7000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babyblue)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babyblue)
                        }

                    }
                }

            }

            //END OF CARD 4

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(226.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.malt5),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Lizzy",
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

                    Text(text = "Ksh. 16000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babyblue)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babyblue)
                        }

                    }
                }

            }

            //END OF CARD 5

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(226.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.malt6),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Mandy",
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

                    Text(text = "Ksh. 5700",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babyblue)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babyblue)
                        }

                    }
                }

            }

            //END OF CARD 6
        }

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "German Shepherd"
            ,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
        Text(
            text = "(Life-span: 9 - 13 years)"
            ,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )


        //row3

        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {


            Card(modifier = Modifier
                .height(226.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.german1),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Rex",
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

                    Text(text = "Ksh. 6500",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babyblue)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babyblue)
                        }

                    }
                }

            }

            //END OF CARD 1

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(226.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.german2),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Maxy",
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

                    Text(text = "Ksh. 18000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babyblue)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babyblue)
                        }

                    }
                }

            }

            //END OF CARD 2

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(226.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.german3),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Tosh",
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

                    Text(text = "Ksh. 15000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babyblue)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babyblue)
                        }

                    }
                }

            }

            //END OF CARD 3

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(226.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.german4),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Millie",
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

                    Text(text = "Ksh. 8000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babyblue)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babyblue)
                        }

                    }
                }

            }

            //END OF CARD 4

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(226.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.german5),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Pete",
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

                    Text(text = "Ksh. 6000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babyblue)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babyblue)
                        }

                    }
                }

            }

            //END OF CARD 5

            Spacer(modifier = Modifier.width(5.dp))

            Card(modifier = Modifier
                .height(226.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.german6),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Spike",
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

                    Text(text = "Ksh. 7000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babyblue)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babyblue)
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
fun DogsScreenPreview(){

    DogsScreen(navController = rememberNavController())

}


package com.example.petstore.ui.theme.screens.cats

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
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
import com.example.petstore.navigation.DOGS_URL
import com.example.petstore.ui.theme.babypink

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatsScreen(navController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val context = LocalContext.current
        val authViewModel = AuthViewModel(navController, context)

        TopAppBar(title = { Text(text = "Cat-Store")},
            colors = TopAppBarDefaults.mediumTopAppBarColors(babypink),
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

            Image(painter = painterResource(id =R.drawable.catimage),
                contentDescription = "",
                modifier = Modifier
                    .clickable {
                        Toast
                            .makeText(
                                context, "Cats", Toast.LENGTH_SHORT
                            )
                            .show()

                    }
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column {
                Text(text = "CAT-STORE",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = babypink,
                    textAlign = TextAlign.Right
                )
                Text(text = "Pick your Favorite Cat", fontSize = 20.sp, color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "Maine Coon"
            ,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
        Text(
            text = "(Life-span: 10 - 13 years)"
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
                        Image(painter = painterResource(id = R.drawable.coon1),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Angie",
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

                    Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babypink)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babypink)
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
                        Image(painter = painterResource(id = R.drawable.coon2),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Pixie",
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

                    Text(text = "Ksh. 2000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babypink)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babypink)
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
                        Image(painter = painterResource(id = R.drawable.coon3),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Maya",
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

                    Text(text = "Ksh. 2000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babypink)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babypink)
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
                        Image(painter = painterResource(id = R.drawable.coon4),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Raph",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "Age: 3 month",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 2000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babypink)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babypink)
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
                        Image(painter = painterResource(id = R.drawable.coon5),
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
                        text = "Age: 6 month",
                        fontSize = 15.sp,
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
                            Text(text = "Pay", color = babypink)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babypink)
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
                        Image(painter = painterResource(id = R.drawable.coon6),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Trixie",
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

                    Row (modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babypink)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babypink)
                        }

                    }
                }

            }

            //END OF CARD 6
        }
        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "Ragdoll"
            ,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
        Text(
            text = "(Life-span: 12 - 17 years)"
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
                        Image(painter = painterResource(id = R.drawable.rag1),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Cole",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "Age: 5 month",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 2000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babypink)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babypink)
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
                        Image(painter = painterResource(id = R.drawable.rag2),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Dyleen",
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

                    Row (modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babypink)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babypink)
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
                        Image(painter = painterResource(id = R.drawable.rag3),
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

                    Row (modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babypink)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babypink)
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
                        Image(painter = painterResource(id = R.drawable.rag4),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Alvy",
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

                    Row (modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babypink)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babypink)
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
                        Image(painter = painterResource(id = R.drawable.rag5),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Tonny",
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

                    Text(text = "Ksh. 2000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babypink)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babypink)
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
                        Image(painter = painterResource(id = R.drawable.rag6),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Talia",
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

                    Row (modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babypink)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babypink)
                        }

                    }
                }

            }

            //END OF CARD 6
        }

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "Orange Cat"
            ,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
        Text(
            text = "(Life-span: 15 - 20 years)"
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
                        Image(painter = painterResource(id = R.drawable.orange1),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Vinny",
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

                    Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babypink)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babypink)
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
                        Image(painter = painterResource(id = R.drawable.orange2),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Gift",
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

                    Row (modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babypink)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babypink)
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
                        Image(painter = painterResource(id = R.drawable.orange3),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Trent",
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

                    Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babypink)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babypink)
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
                        Image(painter = painterResource(id = R.drawable.orange4),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Tina",
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

                    Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babypink)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babypink)
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
                        Image(painter = painterResource(id = R.drawable.orange5),
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

                    Row (modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babypink)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babypink)
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
                        Image(painter = painterResource(id = R.drawable.orange6),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Marie",
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

                    Row (modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babypink)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babypink)
                        }

                    }
                }

            }

            //END OF CARD 6
        }

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "Pixie Bob"
            ,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
        Text(
            text = "(Life-span: 13 - 15 years)"
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
                        Image(painter = painterResource(id = R.drawable.bob1),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Vania",
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

                    Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babypink)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babypink)
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
                        Image(painter = painterResource(id = R.drawable.bob2),
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
                        text = "Age: 2 months",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 2000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babypink)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babypink)
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
                        Image(painter = painterResource(id = R.drawable.bob3),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Tish",
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

                    Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babypink)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babypink)
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
                        Image(painter = painterResource(id = R.drawable.bob4),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Juma",
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

                    Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babypink)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babypink)
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
                        Image(painter = painterResource(id = R.drawable.bob5),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Ponte",
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

                    Row (modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babypink)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babypink)
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
                        Image(painter = painterResource(id = R.drawable.bob6),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Milly",
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

                    Row (modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)){

                        TextButton(onClick = { val simToolKitLaunchIntent =
                            context.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { context.startActivity(it)} },
                        ) {
                            Text(text = "Pay", color = babypink)
                        }

                        TextButton(onClick = { val callIntent= Intent(Intent.ACTION_DIAL)
                            callIntent.data="tel:0732849696".toUri()
                            context.startActivity(callIntent) },
                        ) {
                            Text(text = "Call", color = babypink)
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
fun CatsScreenPreview(){

    CatsScreen(navController = rememberNavController())

}


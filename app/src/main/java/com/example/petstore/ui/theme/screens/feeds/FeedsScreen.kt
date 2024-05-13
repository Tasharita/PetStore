package com.example.petstore.ui.theme.screens.feeds

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
import androidx.compose.ui.draw.paint
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
import com.example.petstore.ui.theme.cream
import com.example.petstore.ui.theme.green
import com.example.petstore.ui.theme.grey1
import com.example.petstore.ui.theme.lightgreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeedsScreen(navController: NavHostController){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val context = LocalContext.current
        val authViewModel = AuthViewModel(navController, context)

        TopAppBar(title = { Text(text = "Feeds") },
            colors = TopAppBarDefaults.mediumTopAppBarColors(cream),
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



        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "Cat feeds"
            ,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )


        //row1

        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {


            Card(
                modifier = Modifier
                    .height(205.dp)
                    .width(150.dp)
            ) {

                Column {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center
                    )
                    {
                        Image(
                            painter = painterResource(id = R.drawable.optimalbalance),
                            contentDescription = "",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "O.Balance",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(
                        text = "Ksh. 11000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

                        TextButton(
                            onClick = {
                                val simToolKitLaunchIntent =
                                    context.packageManager.getLaunchIntentForPackage("com.android.stk")
                                simToolKitLaunchIntent?.let { context.startActivity(it) }
                            },
                        ) {
                            Text(text = "Pay", color = green)
                        }

                        TextButton(
                            onClick = {
                                val callIntent = Intent(Intent.ACTION_DIAL)
                                callIntent.data = "tel:0732849696".toUri()
                                context.startActivity(callIntent)
                            },
                        ) {
                            Text(text = "Call", color = green)
                        }

                    }
                }

            }

            //END OF CARD 1

            Spacer(modifier = Modifier.width(5.dp))

            Card(
                modifier = Modifier
                    .height(205.dp)
                    .width(150.dp)
            ) {

                Column {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center
                    )
                    {
                        Image(
                            painter = painterResource(id = R.drawable.proteinfeeds),
                            contentDescription = "",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Protein",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))

                    Text(
                        text = "Ksh. 15000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

                        TextButton(
                            onClick = {
                                val simToolKitLaunchIntent =
                                    context.packageManager.getLaunchIntentForPackage("com.android.stk")
                                simToolKitLaunchIntent?.let { context.startActivity(it) }
                            },
                        ) {
                            Text(text = "Pay", color = green)
                        }

                        TextButton(
                            onClick = {
                                val callIntent = Intent(Intent.ACTION_DIAL)
                                callIntent.data = "tel:0732849696".toUri()
                                context.startActivity(callIntent)
                            },
                        ) {
                            Text(text = "Call", color = green)
                        }

                    }
                }

            }

            //END OF CARD 2

            Spacer(modifier = Modifier.width(5.dp))

            Card(
                modifier = Modifier
                    .height(205.dp)
                    .width(150.dp)
            ) {

                Column {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center
                    )
                    {
                        Image(
                            painter = painterResource(id = R.drawable.redmills),
                            contentDescription = "",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Redmills",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))


                    Text(
                        text = "Ksh. 16000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

                        TextButton(
                            onClick = {
                                val simToolKitLaunchIntent =
                                    context.packageManager.getLaunchIntentForPackage("com.android.stk")
                                simToolKitLaunchIntent?.let { context.startActivity(it) }
                            },
                        ) {
                            Text(text = "Pay", color = green)
                        }

                        TextButton(
                            onClick = {
                                val callIntent = Intent(Intent.ACTION_DIAL)
                                callIntent.data = "tel:0732849696".toUri()
                                context.startActivity(callIntent)
                            },
                        ) {
                            Text(text = "Call", color = green)
                        }

                    }
                }

            }

            //END OF CARD 3

            Spacer(modifier = Modifier.width(5.dp))

            Card(
                modifier = Modifier
                    .height(205.dp)
                    .width(150.dp)
            ) {

                Column {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center
                    )
                    {
                        Image(
                            painter = painterResource(id = R.drawable.tastefuls),
                            contentDescription = "",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Tastefuls",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(3.dp))



                    Text(
                        text = "Ksh. 22000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

                        TextButton(
                            onClick = {
                                val simToolKitLaunchIntent =
                                    context.packageManager.getLaunchIntentForPackage("com.android.stk")
                                simToolKitLaunchIntent?.let { context.startActivity(it) }
                            },
                        ) {
                            Text(text = "Pay", color = green)
                        }

                        TextButton(
                            onClick = {
                                val callIntent = Intent(Intent.ACTION_DIAL)
                                callIntent.data = "tel:0732849696".toUri()
                                context.startActivity(callIntent)
                            },
                        ) {
                            Text(text = "Call", color = green)
                        }

                    }
                }

            }

            //END OF CARD 4

            Spacer(modifier = Modifier.width(5.dp))

            Card(
                modifier = Modifier
                    .height(205.dp)
                    .width(150.dp)
            ) {

                Column {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center
                    )
                    {
                        Image(
                            painter = painterResource(id = R.drawable.proline),
                            contentDescription = "",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Pro.line",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(
                        text = "Ksh. 21000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

                        TextButton(
                            onClick = {
                                val simToolKitLaunchIntent =
                                    context.packageManager.getLaunchIntentForPackage("com.android.stk")
                                simToolKitLaunchIntent?.let { context.startActivity(it) }
                            },
                        ) {
                            Text(text = "Pay", color = green)
                        }

                        TextButton(
                            onClick = {
                                val callIntent = Intent(Intent.ACTION_DIAL)
                                callIntent.data = "tel:0732849696".toUri()
                                context.startActivity(callIntent)
                            },
                        ) {
                            Text(text = "Call", color = green)
                        }

                    }
                }

            }

            //END OF CARD 5

            Spacer(modifier = Modifier.width(5.dp))

        }

        Text(
            text = "Dog feeds"
            ,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )


        //row2

        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {


            Card(modifier = Modifier
                .height(205.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.bravo),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Bravo",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 26000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)){

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
                .height(205.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.grainzero),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Grain.zero",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 14000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)){

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
                .height(205.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.loop),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Loop",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 19000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)){

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
                .height(205.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.pedigree),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Pedigree",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 27000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)){

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
                .height(205.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.spectrum),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Spectrum",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 17000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

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


        }

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "Birds"
            ,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )

        //row3

        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {


            Card(modifier = Modifier
                .height(205.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.kaytee),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Kaytee",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 19000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

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
                .height(205.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.nigerseed),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Niger.seed",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 27000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)){

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
                .height(205.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.nutrameal),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Nutrameal",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 24000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

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
                .height(205.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.rio),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Rio",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 12000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

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
                .height(205.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.wagners),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Wagners",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 19000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)){

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


        }

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "Fish feeds"
            ,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )



        //row3

        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {


            Card(modifier = Modifier
                .height(205.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.biogran),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Bio.gran",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 21000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

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
                .height(205.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.intan),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Intan",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 20000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)){

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
                .height(205.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.optimum),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Optimum",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 18000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

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
                .height(205.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.tetra),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Granules",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 27000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

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
                .height(205.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.tetracolour),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Tetra.color",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 13000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row (modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)){

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


        }

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "Rabbit feeds"
            ,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )



        //row3

        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {


            Card(modifier = Modifier
                .height(205.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.bonnie),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Bonnie",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 18000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

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
                .height(205.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.marltons),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Marltons",
                        fontSize = 25.sp,
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
                .height(205.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.oxbow),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Oxbow",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 10000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

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
                .height(205.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.showrite),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Showrite",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = "Ksh. 18000",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())

                    Row(modifier = Modifier.fillMaxWidth() .padding(start = 20.dp)) {

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
                .height(205.dp)
                .width(150.dp)) {

                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center)
                    {
                        Image(painter = painterResource(id = R.drawable.sunseed),
                            contentDescription ="",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Sunseed",
                        fontSize = 25.sp,
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


        }






    }
}

@Composable
@Preview(showBackground = true)
fun FeedsScreenPreview(){

    FeedsScreen(navController = rememberNavController())

}
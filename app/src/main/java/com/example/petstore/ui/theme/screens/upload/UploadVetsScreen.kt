package com.example.petstore.ui.theme.screens.upload

import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.petstore.data.VeterinarianViewModel
import com.example.petstore.ui.theme.hotpink


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UploadScreen(navController:NavHostController){
    Column(
        modifier = Modifier.fillMaxSize()
            ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Add Veterinarian",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive
        )

        var vetName by remember { mutableStateOf("") }
        var vetage by remember { mutableStateOf("") }
        var vetnumber by remember { mutableStateOf("") }
        val context = LocalContext.current

        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(
            value = vetName,
            onValueChange = { vetName = it },
            label = { Text(text = "Veterinarian name *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),

        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = vetage,
            onValueChange = { vetage = it },
            label = { Text(text = "Veterinarian age *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = vetnumber,
            onValueChange = { vetnumber = it },
            label = { Text(text = "Veterinarian number *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))



        //---------------------IMAGE PICKER START-----------------------------------//

        var modifier = Modifier
        ImagePicker(modifier,context, navController, vetName.trim(), vetage.trim(), vetnumber.trim())

        //---------------------IMAGE PICKER END-----------------------------------//



    }
}


@Composable
fun ImagePicker(modifier: Modifier = Modifier, context: Context,navController: NavHostController, name:String, age:String, number:String) {
    var hasImage by remember { mutableStateOf(false) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            hasImage = uri != null
            imageUri = uri
        }
    )

    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        if (hasImage && imageUri != null) {
            val bitmap = MediaStore.Images.Media.
            getBitmap(context.contentResolver,imageUri)
            Image(bitmap = bitmap.asImageBitmap(), contentDescription = "Selected image")
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp)
                ,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(
                onClick = {
                    imagePicker.launch("image/*")
                },colors = ButtonDefaults.buttonColors(hotpink)
            ) {
                Text(
                    text = "Select Image"
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                //-----------WRITE THE UPLOAD LOGIC HERE---------------//
                var vetRepository = VeterinarianViewModel(navController,context)
                vetRepository.uploadVeterinarian(name, age, number,imageUri!!)




            },
                colors = ButtonDefaults.buttonColors(hotpink)) {
                Text(text = "Upload")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun UploadScreenPreview(){

    UploadScreen(navController = rememberNavController())

}


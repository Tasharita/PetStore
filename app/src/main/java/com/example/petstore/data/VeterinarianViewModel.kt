package com.example.petstore.data

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.example.petstore.data.AuthViewModel
import com.example.petstore.models.Veterinarian
import com.example.petstore.navigation.LOGIN_URL
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

class VeterinarianViewModel(var navController:NavHostController, var context: Context) {
    var authViewModel: AuthViewModel
    var progress:ProgressDialog
    init {
        authViewModel = AuthViewModel(navController, context)
        if (!authViewModel.isLoggedIn()){
            navController.navigate(LOGIN_URL)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }

    fun uploadVeterinarian(name:String, age:String, number:String, filePath:Uri){
        val veterinarianId = System.currentTimeMillis().toString()
        val storageRef = FirebaseStorage.getInstance().getReference()
            .child("Veterinarian/$veterinarianId")
        progress.show()
        storageRef.putFile(filePath).addOnCompleteListener{
            progress.dismiss()
            if (it.isSuccessful){
                // Save data to db
                storageRef.downloadUrl.addOnSuccessListener {
                    var imageUrl = it.toString()
                    var veterinarian = Veterinarian(name,age,number,imageUrl,veterinarianId)
                    var databaseRef = FirebaseDatabase.getInstance().getReference()
                        .child("Veterinarian/$veterinarianId")
                    databaseRef.setValue(veterinarian).addOnCompleteListener {
                        if (it.isSuccessful){
                            Toast.makeText(this.context, "Success", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this.context, "Error", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }else{
                Toast.makeText(this.context, "Upload error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun allVeterinarians(
        veterinarian:MutableState<Veterinarian>,
        veterinarians:SnapshotStateList<Veterinarian>):SnapshotStateList<Veterinarian>{
        progress.show()
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Veterinarians")
        ref.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                veterinarians.clear()
                for (snap in snapshot.children){
                    var retrievedVeterinarian = snap.getValue(Veterinarian::class.java)
                    veterinarian.value = retrievedVeterinarian!!
                    veterinarians.add(retrievedVeterinarian)
                }
                progress.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
            }
        })
        return veterinarians
    }

    fun deleteVeterinarian(veterinarianId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Veterinarian/$veterinarianId")
        ref.removeValue()
        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }
}

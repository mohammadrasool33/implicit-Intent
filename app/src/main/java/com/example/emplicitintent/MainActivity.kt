package com.example.emplicitintent

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var image: ImageView // Declare image here without initializing

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Set the content view first

        image = findViewById(R.id.imageView) // Initialize here after setContentView
        val button: Button = findViewById(R.id.button) // Initialize the button

        button.setOnClickListener {
            Intent(Intent.ACTION_GET_CONTENT).also{
                it.type="image/*"
                startActivityForResult(it,0)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode==Activity.RESULT_OK && requestCode==0){
            var data=data?.data
            image.setImageURI(data)
        }
    }


}

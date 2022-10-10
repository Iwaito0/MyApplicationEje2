package com.example.myapplication

import android.app.Activity
import android.opengl.GLES30
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewDebug
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val biding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
        }

        biding.recycler.adapter = PersonasAdapter(
            listOf(
                Persona("https://loremflickr.com/240/320?lock=1","Pedro Jurado","987123456","pjurado@gmail.com"),
                Persona("https://loremflickr.com/240/320?lock=2","Pepe Perez","987121256","ppe@gmail.com"),
                Persona("https://loremflickr.com/240/320?lock=3","Antonio Gomez","934643456","aoox@gmail.com"),
        )
        ){ persona ->
            Toast.makeText(this@MainActivity,persona.nombre, Toast.LENGTH_SHORT).show()

        }


    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("MainActivity","onDestroy")
    }
}

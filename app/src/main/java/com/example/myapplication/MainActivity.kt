package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
                Ubicacion("https://loremflickr.com/1500/850?lock=1","Canal de Amsterdam"),
                Ubicacion("https://loremflickr.com/1500/850?lock=2","Playa cerdeña"),
                Ubicacion("https://loremflickr.com/1500/850?lock=3","Canal Brujas"),
                Ubicacion("https://loremflickr.com/1500/850?lock=4","Notre Dame"),
                Ubicacion("https://loremflickr.com/1500/850?lock=7","No se que 1s"),
                Ubicacion("https://loremflickr.com/1500/850?lock=6","No se que 2"),
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

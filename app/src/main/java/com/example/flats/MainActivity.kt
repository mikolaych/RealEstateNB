package com.example.flats

import android.app.Instrumentation.ActivityResult
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flats.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val adapter = HomeAdapter()
    private var editLauncher: ActivityResultLauncher<Intent>? = null

   override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        init()
       editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
           if (it.resultCode == RESULT_OK) {
               adapter.addHome(it.data?.getSerializableExtra("home") as HomeModel)
           }
       }

    }

    private fun init(){
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity, 3) //Настройка вида recyclerView
            rcView.adapter = adapter

            addHomeBtn.setOnClickListener {
                editLauncher?.launch(Intent(this@MainActivity, EditActivity::class.java))

            }

        }

    }


   }
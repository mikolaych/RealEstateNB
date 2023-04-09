package com.example.flats

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.flats.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    lateinit var binnding:ActivityEditBinding

    private var counter = 0


    private val imageIdList = listOf(
        R.drawable.cottage,
        R.drawable.appartment
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        binnding = ActivityEditBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binnding.root)


        btnInit()
    }

    private fun btnInit() = with(binnding) {
        btnChangeImage.setOnClickListener {
            counter++
            if (counter > imageIdList.size - 1) counter = 0
            image.setImageResource(imageIdList[counter])

        }

        btnAddHome.setOnClickListener{
            var home = HomeModel(imageIdList[counter], tittle.text.toString(), description.text.toString(), price.text.toString())
            val editIntent = Intent().apply {
                putExtra("home", home)
            }
            setResult(RESULT_OK, editIntent)
            finish()

        }
    }


}
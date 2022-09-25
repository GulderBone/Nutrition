package com.gulderbone.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gulderbone.presentation.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO delete - it is just for testing purposes
//        runBlocking {
//            val product = productRepository.getProductByBarcode("04963406")
//            println(product)
//        }
    }
}
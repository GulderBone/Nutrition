package com.gulderbone.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NutritionMainActivity : AppCompatActivity() {

//    @Inject
//    lateinit var productRepository: ProductRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nutrition_main)

        // TODO delete - it is just for testing purposes
//        runBlocking {
//            val product = productRepository.getProductByBarcode("04963406")
//            println(product)
//        }
    }
}
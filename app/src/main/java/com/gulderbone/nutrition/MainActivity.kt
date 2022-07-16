package com.gulderbone.nutrition

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gulderbone.data.service.ProductService
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var productService: ProductService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        runBlocking {
            val product = productService.getProductByBarcode("04963406")
            println(product)
        }
    }
}
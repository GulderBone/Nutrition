package com.gulderbone.nutrition

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gulderbone.data.repository.ProductRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var productRepository: ProductRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO delete - it is just for testing purposes
        runBlocking {
            val product = productRepository.getProductByBarcode("04963406")
            println(product)
        }
    }
}
package com.gulderbone.presentation.main

import androidx.lifecycle.ViewModel
import com.gulderbone.domain.feature.interactor.GetProductByBarcodeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class MainViewModel @Inject constructor(
    private val getProductByBarcodeUseCase: GetProductByBarcodeUseCase,
) : ViewModel() {

    init {
        println("henlo")
    }

    fun getProductName(barcode: String) {

//        getProductByBarcodeUseCase.run(barcode)
    }
}
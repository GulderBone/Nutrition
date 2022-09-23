package com.gulderbone.presentation.nutritionmain

import androidx.lifecycle.ViewModel
import com.gulderbone.domain.feature.interactor.GetProductByBarcodeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NutritionMainViewModel @Inject constructor(
    private val getProductByBarcodeUseCase: GetProductByBarcodeUseCase,
) : ViewModel() {

    fun getProductName(barcode: String) {

//        getProductByBarcodeUseCase.run(barcode)
    }
}
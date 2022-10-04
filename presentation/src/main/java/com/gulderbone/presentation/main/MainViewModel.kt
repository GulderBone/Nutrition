package com.gulderbone.presentation.main

import android.Manifest
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gulderbone.domain.feature.interactor.GetProductByBarcodeUseCase
import com.gulderbone.presentation.R
import com.gulderbone.presentation.main.effect.MainEffect
import com.gulderbone.presentation.main.effect.MainEffect.CheckPermission
import com.gulderbone.presentation.main.effect.MainEffect.PermissionNotGranted
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

@HiltViewModel
internal class MainViewModel @Inject constructor(
    private val getProductByBarcodeUseCase: GetProductByBarcodeUseCase,
) : ViewModel() {


    private val _effect: Channel<MainEffect> = Channel()
    val effect: Flow<MainEffect> = _effect.receiveAsFlow()

    private var isCameraPermissionGranted = false

    fun onScanBarcodeClicked() {
        viewModelScope.launch(Dispatchers.Main) {
            _effect.send(CheckPermission)
        }
    }

    fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray) {
        if (requestCode == REQUEST_CAMERA) {
            if (grantResults.contains(PackageManager.PERMISSION_GRANTED)) {
                isCameraPermissionGranted = true
                showCamera()
            } else {
                effect
            }
        }
    }

    private fun showCamera() {
        // TODO: Router to navigate to fragment or just show camera
        println("show camera")
    }

    fun onEffectReceived(
        effect: MainEffect,
        appCompatActivity: AppCompatActivity,
    ) {
        when (effect) {
            is CheckPermission -> {
                val permissionGranted = appCompatActivity.isPermissionGranted(permission = Manifest.permission.CAMERA)
                if (!permissionGranted) {
                    appCompatActivity.requestPermission(
                        permission = Manifest.permission.CAMERA,
                        requestId = REQUEST_CAMERA,
                    )
                } else {
                    showCamera()
                }
            }
            is PermissionNotGranted -> {
                Toast.makeText(appCompatActivity.baseContext, R.string.camera_permissions_not_granted, Toast.LENGTH_LONG).show()
            }
        }
    }

    fun AppCompatActivity.isPermissionGranted(permission: String) =
        ActivityCompat.checkSelfPermission(baseContext, permission) == PackageManager.PERMISSION_GRANTED

    fun AppCompatActivity.requestPermission(permission: String, requestId: Int) =
        ActivityCompat.requestPermissions(this, arrayOf(permission), requestId)

    fun IntArray.contains(num: Int): Boolean = any { it == num }

    fun getProductName(barcode: String) {

//        getProductByBarcodeUseCase.run(barcode)
    }

    companion object {
        private const val REQUEST_CAMERA = 0
    }
}
package com.gulderbone.presentation.main

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.gulderbone.presentation.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onScanCodeClicked()
    }

    fun onScanCodeClicked() {
        if (!isPermissionGranted(Manifest.permission.CAMERA)) {
            requestPermission(
                permission = Manifest.permission.CAMERA,
                requestId = REQUEST_CAMERA,
            )
        } else {
            // show camera
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        if (requestCode == REQUEST_CAMERA) {
            if (grantResults.contains(PackageManager.PERMISSION_GRANTED)) {
                onScanCodeClicked()
            } else {
                Toast.makeText(this,  R.string.camera_permissions_not_granted, Toast.LENGTH_LONG).show()
            }
        }
    }

    fun AppCompatActivity.isPermissionGranted(permission: String) =
        ActivityCompat.checkSelfPermission(baseContext, permission) == PackageManager.PERMISSION_GRANTED

    fun AppCompatActivity.requestPermission(permission: String, requestId: Int) =
        ActivityCompat.requestPermissions(this, arrayOf(permission), requestId)

    fun IntArray.contains(num: Int): Boolean = any { it == num }

    companion object {
        private const val REQUEST_CAMERA = 0
    }
}

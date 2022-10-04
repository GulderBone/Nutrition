package com.gulderbone.presentation.camera_preview.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.common.util.concurrent.ListenableFuture
import com.gulderbone.presentation.R
import com.gulderbone.presentation.databinding.FragmentCameraPreviewBinding
import com.gulderbone.presentation.viewbinding.viewBinding

internal class CameraPreviewFragment : Fragment(R.layout.fragment_camera_preview) {

    private val binding by viewBinding(FragmentCameraPreviewBinding::bind)

    private lateinit var cameraProviderFuture : ListenableFuture<ProcessCameraProvider>

    override fun onAttach(context: Context) {
        super.onAttach(context)
        cameraProviderFuture = ProcessCameraProvider.getInstance(context)
        startCamera(context)
    }

    private fun startCamera(context: Context) {

        cameraProviderFuture.addListener({
            // Used to bind the lifecycle of cameras to the lifecycle owner
            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()


            // Preview
            val preview = Preview.Builder()
                .build()
                .also {
                    it.setSurfaceProvider(binding.cameraPreviewView.surfaceProvider)
                }

            // Select back camera as a default
            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

            try {
                // Unbind use cases before rebinding
                cameraProvider.unbindAll()

                // Bind use cases to camera
                cameraProvider.bindToLifecycle(
                    this, cameraSelector, preview)

            } catch(exc: Exception) {
                Log.e("DAMIAN", "Use case binding failed", exc)
            }

        }, ContextCompat.getMainExecutor(context))
    }
}
package com.gulderbone.presentation.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.gulderbone.presentation.R
import com.gulderbone.presentation.databinding.FragmentMainBinding
import com.gulderbone.presentation.util.extentions.observe
import com.gulderbone.presentation.viewbinding.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding by viewBinding(FragmentMainBinding::bind)
    private val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setObservers()
        setListeners()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        viewModel.onRequestPermissionsResult(requestCode, grantResults)
    }

    private fun setObservers() = with(viewModel) {
        effect.observe(viewLifecycleOwner) {
            onEffectReceived(
                effect = it,
                appCompatActivity = activity as AppCompatActivity
            )
        }
    }

    private fun setListeners() {
        with(binding) {
            scanBarcode.setOnClickListener { viewModel.onScanBarcodeClicked() }
        }
    }
}
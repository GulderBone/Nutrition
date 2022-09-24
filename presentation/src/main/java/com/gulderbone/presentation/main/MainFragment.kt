package com.gulderbone.presentation.main

import androidx.fragment.app.Fragment
import com.gulderbone.presentation.R
import com.gulderbone.presentation.databinding.FragmentNutritionMainBinding
import com.gulderbone.presentation.viewbinding.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_nutrition_main) {

    private val binding by viewBinding(FragmentNutritionMainBinding::bind)

}
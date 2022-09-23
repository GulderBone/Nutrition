package com.gulderbone.presentation.nutritionmain

import androidx.fragment.app.Fragment
import com.gulderbone.presentation.R
import com.gulderbone.presentation.databinding.FragmentNutritionMainBinding
import com.gulderbone.presentation.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NutritionMainFragment : Fragment(R.layout.fragment_nutrition_main) {

    private val binding by viewBinding(FragmentNutritionMainBinding::bind)

}
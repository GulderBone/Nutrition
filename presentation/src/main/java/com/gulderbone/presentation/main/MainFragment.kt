package com.gulderbone.presentation.main

import androidx.fragment.app.Fragment
import com.gulderbone.presentation.R
import com.gulderbone.presentation.databinding.FragmentMainBinding
import com.gulderbone.presentation.viewbinding.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding by viewBinding(FragmentMainBinding::bind)

}
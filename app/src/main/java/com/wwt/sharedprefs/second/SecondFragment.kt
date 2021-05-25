package com.wwt.sharedprefs.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wwt.sharedprefs.databinding.FragmentSecondBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SecondFragment : Fragment() {
    private val model: SecondViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentSecondBinding.inflate(inflater, container, false).apply {
        lifecycleOwner = viewLifecycleOwner
        viewModel = model
    }.root
}

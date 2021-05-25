package com.wwt.sharedprefs.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wwt.sharedprefs.databinding.FragmentFirstBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FirstFragment : Fragment() {
    private val model: FirstViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentFirstBinding.inflate(inflater, container, false).apply {
        lifecycleOwner = viewLifecycleOwner
        viewModel = model
    }.root
}

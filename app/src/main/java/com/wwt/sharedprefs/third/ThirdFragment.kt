package com.wwt.sharedprefs.third

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.wwt.sharedprefs.databinding.FragmentThirdBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ThirdFragment : Fragment() {
    private val fragmentArgs: ThirdFragmentArgs by navArgs()
    private val model: ThirdViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentThirdBinding.inflate(inflater, container, false).apply {
        lifecycleOwner = viewLifecycleOwner
        viewModel = model.apply {
            enteredName.value = fragmentArgs.name
        }
    }.root
}

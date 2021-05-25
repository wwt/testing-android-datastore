package com.wwt.sharedprefs.third

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController

class ThirdViewModel : ViewModel() {
    val enteredName: MutableLiveData<String> = MutableLiveData()

    fun restartWorkflow(v: View) = v.findNavController().navigate(
        ThirdFragmentDirections.actionThirdFragmentToFirstFragment()
    )
}
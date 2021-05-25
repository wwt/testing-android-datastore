package com.wwt.sharedprefs.third

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val thirdModule = module {
    viewModel {
        ThirdViewModel()
    }
}
package com.wwt.sharedprefs.second

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val secondModule = module {
    viewModel {
        SecondViewModel(
            dataStore = get(),
            returningUserKey = get(named("returning-user"))
        )
    }
}
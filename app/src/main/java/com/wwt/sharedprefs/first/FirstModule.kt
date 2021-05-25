package com.wwt.sharedprefs.first

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val firstModule = module {
    viewModel {
        FirstViewModel(
            dataStore = get(),
            returningUserKey = get(named("returning-user"))
        )
    }
}
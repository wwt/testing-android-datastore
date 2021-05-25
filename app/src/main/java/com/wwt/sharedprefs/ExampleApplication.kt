package com.wwt.sharedprefs

import android.app.Application
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStoreFile
import com.wwt.sharedprefs.first.firstModule
import com.wwt.sharedprefs.second.secondModule
import com.wwt.sharedprefs.third.thirdModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module

@Suppress("unused")
class ExampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ExampleApplication)

            modules(
                preferencesModule,
                firstModule,
                secondModule,
                thirdModule
            )
        }
    }
}

private val preferencesModule = module {
    factory(named("returning-user")) {
        stringPreferencesKey("returning-user")
    }

    single {
        PreferenceDataStoreFactory.create {
            androidContext().preferencesDataStoreFile("my-preferences")
        }
    }
}
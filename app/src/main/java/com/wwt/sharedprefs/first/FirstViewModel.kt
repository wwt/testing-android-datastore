package com.wwt.sharedprefs.first

import android.view.View
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.navigation.findNavController
import kotlinx.coroutines.flow.collect

class FirstViewModel(
    private val dataStore: DataStore<Preferences>,
    private val returningUserKey: Preferences.Key<String>
) : ViewModel() {
    val greeting: LiveData<String> = liveData {
        dataStore.data.collect {
            val user: String? = it[returningUserKey]
            val displayName = if (user.isNullOrEmpty()) DEFAULT_MESSAGE else "Welcome back $user!"
            emit(displayName)
        }
    }

    fun moveToSecond(v: View) = v.findNavController()
        .navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment())

    companion object {
        const val DEFAULT_MESSAGE = "Hello there and welcome!"
    }
}
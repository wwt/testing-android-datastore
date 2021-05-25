package com.wwt.sharedprefs.second

import android.view.View
import androidx.annotation.VisibleForTesting
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import kotlinx.coroutines.launch

class SecondViewModel(
    private val dataStore: DataStore<Preferences>,
    private val returningUserKey: Preferences.Key<String>
) : ViewModel() {
    val nameField: MutableLiveData<String> = MutableLiveData()

    fun returnToFirst(v: View) = v.findNavController().navigate(
        SecondFragmentDirections.actionSecondFragmentToFirstFragment()
    )

    fun moveToThird(v: View) {
        viewModelScope.launch {
            saveName(nameField.value)
            v.findNavController().navigate(
                SecondFragmentDirections.actionSecondFragmentToThirdFragment(nameField.value)
            )
        }
    }

    @VisibleForTesting
    suspend fun saveName(name: String?) {
        dataStore.edit {
            if (name.isNullOrEmpty()) {
                it.remove(returningUserKey)
            } else {
                it[returningUserKey] = name
            }
        }
    }
}
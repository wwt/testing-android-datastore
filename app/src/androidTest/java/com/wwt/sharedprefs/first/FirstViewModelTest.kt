package com.wwt.sharedprefs.first

import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.wwt.sharedprefs.DataStoreTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class FirstViewModelTest : DataStoreTest() {
    private val returningUserName = UUID.randomUUID().toString()
    private val testKey: Preferences.Key<String> = stringPreferencesKey("test-key")

    @Test
    fun defaultMessageDisplayedWhenNoPreferenceAvailable() = coTest {
        val testObject = FirstViewModel(dataStore, testKey)

        testObject.greeting.observeForever { value ->
            assertEquals("Hello there and welcome!", value)
        }
    }

    @Test
    fun storedNameIsUsedWhenAvailable() = coTest {
        dataStore.edit { preferences ->
            preferences[testKey] = returningUserName
        }

        val testObject = FirstViewModel(dataStore, testKey)

        testObject.greeting.observeForever { value ->
            assertEquals("Welcome back $returningUserName!", value)
        }
    }
}

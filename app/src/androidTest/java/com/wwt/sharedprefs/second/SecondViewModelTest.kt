package com.wwt.sharedprefs.second

import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.wwt.sharedprefs.DataStoreTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class SecondViewModelTest : DataStoreTest() {
    private val returningUserName = UUID.randomUUID().toString()
    private val testKey: Preferences.Key<String> = stringPreferencesKey("test-key")

    @Test
    fun saveName() = coTest {
        val testObject = SecondViewModel(dataStore, testKey)

        testObject.saveName(returningUserName)

        assertEquals(returningUserName, testKey.findCurrentValue())
    }

    @Test
    fun saveNameOverridesPreviousValue() = coTest {
        val previousName = UUID.randomUUID().toString()
        dataStore.edit { preferences ->
            preferences[testKey] = previousName
        }
        val testObject = SecondViewModel(dataStore, testKey)
        assertEquals(previousName, testKey.findCurrentValue())

        testObject.saveName(returningUserName)

        assertEquals(returningUserName, testKey.findCurrentValue())
    }

    @Test
    fun savingAnEmptyNameRemovesThePreference() = coTest {
        dataStore.edit { preferences ->
            preferences[testKey] = returningUserName
        }
        val testObject = SecondViewModel(dataStore, testKey)

        testObject.saveName("")

        assertNull(testKey.findCurrentValue())
    }

    @Test
    fun savingNullNameRemovesThePreference() = coTest {
        dataStore.edit { preferences ->
            preferences[testKey] = returningUserName
        }
        val testObject = SecondViewModel(dataStore, testKey)

        testObject.saveName(null)

        assertNull(testKey.findCurrentValue())
    }

    suspend fun <T> Preferences.Key<T>.findCurrentValue() =
        dataStore.data.first()[this]
}

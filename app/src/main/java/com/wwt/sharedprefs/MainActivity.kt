package com.wwt.sharedprefs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import com.wwt.sharedprefs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
            setSupportActionBar(toolbar)
        }.also {
            binding = it
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.action_settings -> showPlaceholderMessage("Launch the settings screen!")
        else -> super.onOptionsItemSelected(item)
    }

    private fun showPlaceholderMessage(message: String): Boolean {
        Snackbar.make(
                binding?.root!!,
                message,
                Snackbar.LENGTH_LONG
        ).setAction("Action", null).show()
        return true
    }
}
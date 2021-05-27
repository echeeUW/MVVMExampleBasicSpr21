package edu.uw.echee.mvvmexamplebasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import edu.uw.echee.mvvmexamplebasic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(root) }
        with(binding) {

            btnAddEmail.setOnClickListener {  }
            btnDeleteEmail.setOnClickListener {  }

        }
    }

    private fun getColorRes(@ColorRes colorId: Int) = ContextCompat.getColor(this, colorId)
}

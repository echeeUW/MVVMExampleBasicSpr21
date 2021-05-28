package edu.uw.echee.mvvmexamplebasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import edu.uw.echee.mvvmexamplebasic.databinding.ActivityMainBinding
import edu.uw.echee.mvvmexamplebasic.viewmodel.GmailViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val gmailViewModel by viewModels<GmailViewModel>()

    private fun observeChangesFromViewModel() {
        // Listening for updates
        gmailViewModel.numOfEmails.onEach { numOfEmails ->
            binding.tvCount.text = numOfEmails.toString()
        }.launchIn(lifecycleScope)

        gmailViewModel.isLuckyNumber.onEach { isLucky ->
            binding.tvTitle.setTextColor(getColorRes(if (isLucky) R.color.black else R.color.red))
        }.launchIn(lifecycleScope)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(root) }
        observeChangesFromViewModel()
        // View that notifies the ViewModel
        with(binding) {
            btnAddEmail.setOnClickListener {
                gmailViewModel.onAddEmail()
            }
            btnDeleteEmail.setOnClickListener {
                gmailViewModel.onDeleteEmail()
            }
        }
    }

    private fun getColorRes(@ColorRes colorId: Int) = ContextCompat.getColor(this, colorId)
}

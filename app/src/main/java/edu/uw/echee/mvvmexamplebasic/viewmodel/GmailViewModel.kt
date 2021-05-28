package edu.uw.echee.mvvmexamplebasic.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class GmailViewModel: ViewModel() {

    var numOfEmails = MutableStateFlow<Int>(0)
    var isLuckyNumber = MutableStateFlow<Boolean>(false)

    init {
        isLuckyNumber.value = (numOfEmails.value != 13)
    }

    fun onAddEmail() {
        numOfEmails.value = numOfEmails.value + 1
        isLuckyNumber.value = (numOfEmails.value != 13)
    }

    fun onDeleteEmail() {
        numOfEmails.value = numOfEmails.value - 1
        isLuckyNumber.value = (numOfEmails.value != 13)
    }

}

package com.missclick.gameninja.ui.firstScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.missclick.gameninja.App
import com.missclick.gameninja.rep.IRep
import javax.inject.Inject

class FirstScreenViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    @Inject
    lateinit var rep: IRep

    init {
        App.appComponent.inject(this)
    }
}
package com.missclick.gameninja.ui.gameScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.missclick.gameninja.App
import com.missclick.gameninja.data.models.EndModel
import com.missclick.gameninja.rep.IRep
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GameScreenViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is gallery Fragment"
    }
    val text: LiveData<String> = _text

    @Inject
    lateinit var rep: IRep

    init {
        App.appComponent.inject(this)
    }

}
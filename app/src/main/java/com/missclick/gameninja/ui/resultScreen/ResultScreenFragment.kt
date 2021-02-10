package com.missclick.gameninja.ui.resultScreen

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.missclick.gameninja.R
import com.missclick.gameninja.data.models.EndModel

class ResultScreenFragment : Fragment() {

    private lateinit var resultScreenViewModel: ResultScreenViewModel
    private var end : EndModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            end = it.getSerializable("end") as EndModel?
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        resultScreenViewModel =
                ViewModelProvider(this).get(ResultScreenViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_result_screen, container, false)
        //val textView: TextView = root.findViewById(R.id.text_slideshow)
        resultScreenViewModel.text.observe(viewLifecycleOwner, Observer {
            //textView.text = it
        })
        return root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val failsText = view.findViewById<TextView>(R.id.text_fails)
        failsText.text = "Ошибок: " + end!!.fails.toString()
        val restartBtn = view.findViewById<Button>(R.id.btn_restart)
        restartBtn.setOnClickListener {
            findNavController().navigate(R.id.nav_game_screen)
        }
    }
    companion object {
        fun newInstance(end : EndModel):Bundle{
            return Bundle().apply {
                putSerializable("end", end)
            }
        }
    }
}
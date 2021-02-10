package com.missclick.gameninja.ui.firstScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.missclick.gameninja.R

class FirstScreenFragment : Fragment() {

    private lateinit var firstScreenViewModel: FirstScreenViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        firstScreenViewModel =
                ViewModelProvider(this).get(FirstScreenViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_first_screen, container, false)
        //val textView: TextView = root.findViewById(R.id.text_home)
        firstScreenViewModel.text.observe(viewLifecycleOwner, Observer {
            //textView.text = it
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val startBtn : Button = view.findViewById(R.id.start_btn)
        val exitBtn : Button = view.findViewById(R.id.exit_btn)
        startBtn.setOnClickListener {
            findNavController().navigate(R.id.nav_game_screen)
        }
        exitBtn.setOnClickListener {
            activity?.moveTaskToBack(true)
        }
        val rec = view.findViewById<ImageView>(R.id.recordsBtn)
        rec.setOnClickListener {
            findNavController().navigate(R.id.nav_record_screen)
        }
    }
}
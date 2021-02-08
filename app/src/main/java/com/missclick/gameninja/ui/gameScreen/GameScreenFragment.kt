package com.missclick.gameninja.ui.gameScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.missclick.gameninja.R

class GameScreenFragment : Fragment() {

    private lateinit var gameScreenViewModel: GameScreenViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        gameScreenViewModel =
                ViewModelProvider(this).get(GameScreenViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_game_screen, container, false)
        //val textView: TextView = root.findViewById(R.id.text_gallery)
        gameScreenViewModel.text.observe(viewLifecycleOwner, Observer {
            //textView.text = it
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val positions = mutableListOf<ImageView>()
        val pos0 : ImageView = view.findViewById(R.id.pos1_btn)
        val pos1 : ImageView = view.findViewById(R.id.pos2_btn)
        val pos2 : ImageView = view.findViewById(R.id.pos3_btn)
        val pos3 : ImageView = view.findViewById(R.id.pos4_btn)
        val pos4 : ImageView = view.findViewById(R.id.pos5_btn)
        val pos5 : ImageView = view.findViewById(R.id.pos6_btn)
        val pos6 : ImageView = view.findViewById(R.id.pos7_btn)
        val pos7 : ImageView = view.findViewById(R.id.pos8_btn)
        val pos8 : ImageView = view.findViewById(R.id.pos9_btn)
        val pos9 : ImageView = view.findViewById(R.id.pos10_btn)
        val pos10 : ImageView = view.findViewById(R.id.pos11_btn)
        val pos11 : ImageView = view.findViewById(R.id.pos12_btn)

        positions.add(pos0)
        positions.add(pos1)
        positions.add(pos2)
        positions.add(pos3)
        positions.add(pos4)
        positions.add(pos5)
        positions.add(pos6)
        positions.add(pos7)
        positions.add(pos8)
        positions.add(pos9)
        positions.add(pos10)
        positions.add(pos11)

        val score = 0

    }
}
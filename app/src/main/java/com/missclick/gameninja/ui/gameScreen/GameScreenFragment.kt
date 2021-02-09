package com.missclick.gameninja.ui.gameScreen

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.missclick.gameninja.R
import java.util.concurrent.TimeUnit


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

        val positionsImage = mutableListOf<ImageView>()
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

        positionsImage.add(pos0)
        positionsImage.add(pos1)
        positionsImage.add(pos2)
        positionsImage.add(pos3)
        positionsImage.add(pos4)
        positionsImage.add(pos5)
        positionsImage.add(pos6)
        positionsImage.add(pos7)
        positionsImage.add(pos8)
        positionsImage.add(pos9)
        positionsImage.add(pos10)
        positionsImage.add(pos11)

        var positions = listOf(1,1,2,2,3,3,4,4,5,5,6,6)
        positions = positions.shuffled()
        Log.e("List",positions.toString())
        var isOpened = -1
        var fails = 0
        var pairs = 6
        for (i in 0..11){
            positionsImage[i].setOnClickListener {
                if (isOpened == -1 || isOpened == i){
                    isOpened = i
                    positionsImage[i].setImageResource(getResource(number = positions[i]))
                }
                else{
                    positionsImage[i].setImageResource(getResource(number = positions[i]))
                    Handler().postDelayed(
                            {
                                if (positions[isOpened] != positions[i]){
                                    fails += 1
                                    Log.e(isOpened.toString(),i.toString())
                                    positionsImage[i].setImageResource(getResource(number = 0))
                                    positionsImage[isOpened].setImageResource(getResource(number = 0))
                                    isOpened = -1
                                }
                                else{
                                    positionsImage[i].visibility = View.INVISIBLE
                                    positionsImage[isOpened].visibility = View.INVISIBLE
                                    isOpened = -1
                                    pairs -= 1
                                    if (pairs == 0) findNavController().navigate(R.id.nav_result_screen)
                                }
                            },
                            1000 // value in milliseconds
                    )

                }
            }
        }
    }

    private fun getResource(number : Int): Int {
        if (number == 1) return R.drawable.one
        if (number == 2) return R.drawable.two
        if (number == 3) return R.drawable.third
        if (number == 4) return R.drawable.four
        if (number == 5) return R.drawable.fifth
        if (number == 6) return R.drawable.six
        return  R.drawable.back
    }
}
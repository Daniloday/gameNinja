package com.missclick.gameninja.ui.recordsScreen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.missclick.gameninja.MainActivity
import com.missclick.gameninja.R
import com.missclick.gameninja.adapt.RecycleAdapter
import com.missclick.gameninja.adapt.SectionsPagerAdapter
import com.missclick.gameninja.data.models.EndModel

class RecordsScreenFragment : Fragment() {

    companion object {
        fun newInstance() = RecordsScreenFragment()
    }

    private lateinit var viewModel: RecordsScreenViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.records_screen_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RecordsScreenViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val btn1 = view.findViewById<Button>(R.id.but_1)
        val recycle = view.findViewById<RecyclerView>(R.id.recycleView)
        val f : MutableList<EndModel> = mutableListOf()
        recycle.adapter = RecycleAdapter(
            f as MutableList<EndModel>,
            object : RecycleAdapter.Callback {
                override fun onItemClicked(item: EndModel) {

                }
            }
        )
        recycle.layoutManager = LinearLayoutManager(activity as MainActivity)
        val btn2 = view.findViewById<Button>(R.id.but_2)
        btn1.setOnClickListener {
            viewModel.saveResult1()
        }
        val btn3 = view.findViewById<Button>(R.id.but_3)

        btn3.setOnClickListener {
            viewModel.saveResult2()
        }

        val btn4 = view.findViewById<Button>(R.id.but_4)


        btn2.setOnClickListener {
            viewModel.saveResult3()
        }

        btn4.setOnClickListener {
            viewModel.saveResult4()
        }

        val sectionsPagerAdapter =
            SectionsPagerAdapter(
                childFragmentManager,
                1
            )
        val vl = view.findViewById<ViewPager>(R.id.vp)
        //vl.adapter = sectionsPagerAdapter


    }

}
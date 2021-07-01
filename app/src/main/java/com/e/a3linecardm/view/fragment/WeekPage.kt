package com.e.a3linecardm.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.e.a3linecardm.R


class WeekPage : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_week_page, container, false)
        contentView(view)
        return view
    }

    private fun contentView(view: View){

    }

    companion object {

        @JvmStatic
        fun newInstance() =
            WeekPage().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
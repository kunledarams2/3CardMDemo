package com.e.a3linecardm.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.e.a3linecardm.R
import com.e.a3linecardm.view.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class PageTabHost : FragmentTitle() {

    private lateinit var pagerAdapter: ViewPagerAdapter
    private lateinit var pager2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
       val view = inflater.inflate(R.layout.fragment_page_tab_host, container, false)
        contentView(view)
        return view
    }

    private fun contentView(view: View){

        val fragments = ArrayList<Fragment>()

        fragments.add(TodayPage.newInstance())
        fragments.add(WeekPage.newInstance())

        val tabLayout : TabLayout = view.findViewById(R.id.tab_layout)
        pager2 = view.findViewById(R.id.view_pager)

        pagerAdapter = ViewPagerAdapter(this, fragments)
        pager2.adapter = pagerAdapter

        TabLayoutMediator(tabLayout, pager2) { tab, position ->

            when(position){
                0->{tab.text = "Today"
                    tab.icon =  resources.getDrawable(R.drawable.ic_baseline_calendar_today_24)
               }
                1->{tab.text = "Weekly"
                    tab.icon =  resources.getDrawable(R.drawable.ic_baseline_calendar_today_24)}
                else ->{ tab.text ="Share"
                    tab.icon =  resources.getDrawable(R.drawable.ic_baseline_share_24)}
            }

        }.attach()

    }

    companion object {

        @JvmStatic
        fun newInstance() =
                PageTabHost().apply {
                    arguments = Bundle().apply {

                    }
                }
    }
}
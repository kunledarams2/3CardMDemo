package com.e.a3linecardm.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.e.a3linecardm.R
import com.e.a3linecardm.view.callback.FragmentChanger
import com.e.a3linecardm.view.fragment.FragmentTitle
import com.e.a3linecardm.view.fragment.PageTabHost

class MainActivity : AppCompatActivity(), FragmentChanger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentChanger(PageTabHost.newInstance())
    }

    override fun fragmentChanger(fragmentTitle: FragmentTitle) {
        supportFragmentManager.beginTransaction().replace(R.id.frame, fragmentTitle).commit()
    }
}
package com.example.fabinails.Adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.fabinails.fragments.Adesivo
import com.example.fabinails.fragments.Agendar
import com.example.fabinails.fragments.Esmalte
import com.example.fabinails.fragments.Trabalho

internal class MyAdapter(var context: Context, fm: FragmentManager, var TotalTabs: Int) :
    FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return TotalTabs
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                Trabalho()
            }

            1 -> {
                Adesivo()
            }

            2 -> {
                Esmalte()
            }

            3 -> {
                Agendar()
            }
            else -> getItem(position)
        }
    }

}
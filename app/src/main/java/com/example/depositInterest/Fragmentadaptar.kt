package com.example.depositInterest

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class Fragmentadaptar (fm:FragmentManager, life:Lifecycle) :FragmentStateAdapter(fm,life) {

      override fun getItemCount() = 4


    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                FragmentInstalment()
            }
            1 -> {
                FragmentInterest()}
            2 -> {
                FragmentCompound()
            }
            3 -> {
                FragmentDeposit()
            }
            else -> {
                FragmentInstalment()
            }
        }

    }
}
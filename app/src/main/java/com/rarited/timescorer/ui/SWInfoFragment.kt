package com.rarited.timescorer.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rarited.timescorer.databinding.FragmentSwInfoBinding


class SWInfoFragment : Fragment() {
    private lateinit var b: FragmentSwInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        b = FragmentSwInfoBinding.inflate(layoutInflater)
        return b.root
    }
}
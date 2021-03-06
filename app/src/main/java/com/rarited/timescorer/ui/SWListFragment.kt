package com.rarited.timescorer.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.rarited.timescorer.R
import com.rarited.timescorer.data.TSListAdapter
import com.rarited.timescorer.databinding.FragmentSwListBinding

class SWListFragment : Fragment() {
    private lateinit var b: FragmentSwListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        b = FragmentSwListBinding.inflate(layoutInflater)
        return b.root
    }

    override fun onResume() {
        super.onResume()
        val recyclerView = b.stopwatchesRecyclerView
        val adapter = TSListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        b.swapFragment.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(R.id.dataContainer, SWInfoFragment()).commit()
        }
    }
}
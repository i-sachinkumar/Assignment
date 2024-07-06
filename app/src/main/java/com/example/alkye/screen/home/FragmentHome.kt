package com.example.alkye.screen.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alkye.R
import com.example.alkye.databinding.FragmentHomeBinding
import com.example.alkye.screen.adapter.FooterHorizontalRecyclerAdapter
import com.example.alkye.screen.adapter.HorizontalRecyclerAdapter
import com.example.alkye.screen.adapter.VerticalRecyclerAdapter

class FragmentHome : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel : ViewModelHome

    private lateinit var horizontalAdapter: HorizontalRecyclerAdapter
    private lateinit var verticalAdapter: VerticalRecyclerAdapter
    private lateinit var footerHorizontalRecyclerAdapter: FooterHorizontalRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container,  false)
        viewModel = ViewModelProvider(this)[ViewModelHome::class.java]

        binding.horizontalRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.footerHorizontalRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.verticalRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        horizontalAdapter = HorizontalRecyclerAdapter(viewModel.horizontalList)
        verticalAdapter = VerticalRecyclerAdapter(viewModel.verticalList)
        footerHorizontalRecyclerAdapter = FooterHorizontalRecyclerAdapter(viewModel.footerList)


        binding.horizontalRecyclerView.adapter = horizontalAdapter
        binding.verticalRecyclerView.adapter = verticalAdapter
        binding.footerHorizontalRecyclerView.adapter = footerHorizontalRecyclerAdapter


        binding.viewAll.setOnClickListener {
            viewModel.showAllVerticalList()
            verticalAdapter.notifyItemRangeInserted(5, 15)
            binding.viewAll.visibility = View.GONE
        }

        return binding.root
    }
}
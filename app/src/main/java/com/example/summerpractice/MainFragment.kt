package com.example.summerpractice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.summerpractice.databinding.FragmentMainBinding
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

class MainFragment : Fragment(R.layout.fragment_main) {
    private var binding: FragmentMainBinding? = null
    private var adapter : CountryAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)
        initAdapter()
    }

    private fun initAdapter() {
        adapter = CountryAdapter(
            list = CountryRepository.list,
            glide = Glide.with(this),
            onItemClick = { country ->
                val bundle = Bundle()
                bundle.putInt(getString(R.string.id_tag), country.id)
                findNavController().navigate(
                    R.id.action_mainFragment_to_infoFragment, bundle)
            }
        )
        binding?.rvCountry?.adapter = adapter
    }
}
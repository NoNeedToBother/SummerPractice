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
        val NAME_TAG = "NAME"
        val CAPITAL_TAG = "CAPITAL"
        val POPULATION_TAG = "POPULATION"
        val DESC_TAG = "DESC"
        val URL_TAG = "URL"
        adapter = CountryAdapter(
            list = CountryRepository.list,
            glide = Glide.with(this),
            onItemClick = { country ->
                val bundle = Bundle()
                bundle.putString(NAME_TAG, country.name)
                bundle.putString(CAPITAL_TAG, country.capital)
                bundle.putInt(POPULATION_TAG, country.population)
                bundle.putString(DESC_TAG, country.description)
                bundle.putString(URL_TAG, country.url)
                findNavController().navigate(
                    R.id.action_mainFragment_to_infoFragment, bundle)
            }
        )
        binding?.rvCountry?.adapter = adapter
        //binding?.rvCountry?.layoutManager = GridLayoutManager(requireContext(), 2)
    }

    fun View.showSnackbar(
        text: String,
        @BaseTransientBottomBar.Duration duration: Int = Snackbar.LENGTH_LONG
    ) = Snackbar.make(this, text, duration).show()
}
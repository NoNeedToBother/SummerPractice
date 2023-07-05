package com.example.summerpractice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.summerpractice.databinding.FragmentInfoBinding

class InfoFragment : Fragment(R.layout.fragment_info) {
    private var binding: FragmentInfoBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.getInt(getString(R.string.id_tag))
        val list = CountryRepository.list

        var index : Int? = null
        var country : Country? = null

        for (i in list.indices) {
            if (id?.equals(list[i].id) == true) {
                index = i
            }
        }
        index?.let { country = list[it]}

        val BASE_CAPITAL = getString(R.string.base_capital)
        val BASE_POPULATION = getString(R.string.base_population)
        val BASE_DESC = getString(R.string.base_desc)

        binding = FragmentInfoBinding.bind(view)

        binding?.run {
            countryName.text = country?.name
            capital.text = BASE_CAPITAL.plus(country?.capital)
            population.text = BASE_POPULATION.plus(country?.population.toString())
            description.text = BASE_DESC.plus(country?.description)
            val urlRes = country?.url

            context?.let {
                Glide.with(it)
                    .load(urlRes)
                    .placeholder(R.drawable.ic_action_name)
                    .error(R.drawable.ic_action_name)
                    .into(ivFlag)
                backButton.setOnClickListener {
                    findNavController().navigate(
                        R.id.action_infoFragment_to_mainFragment
                    )
                }
            }
        }
    }
}
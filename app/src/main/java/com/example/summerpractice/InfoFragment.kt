package com.example.summerpractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.summerpractice.databinding.FragmentInfoBinding

class InfoFragment : Fragment(R.layout.fragment_info) {
    private val NAME_TAG = "NAME"
    private val CAPITAL_TAG = "CAPITAL"
    private val POPULATION_TAG = "POPULATION"
    private val DESC_TAG = "DESC"
    private val URL_TAG = "URL"

    private var binding: FragmentInfoBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        val nameRes = arguments?.getString(NAME_TAG)
        val capitalName = arguments?.getString(CAPITAL_TAG)
        val populationRes = arguments?.getInt(POPULATION_TAG)
        val descRes = arguments?.getString(DESC_TAG)
        val urlRes = arguments?.getString(URL_TAG)

        val BASE_CAPITAL = "Столица: "
        val BASE_POPULATION = "Население: "
        val BASE_DESC = "Описание: "

        binding = FragmentInfoBinding.bind(view)

        binding?.run {
            countryName.text = nameRes
            capital.text = BASE_CAPITAL + capitalName
            population.text = BASE_POPULATION + populationRes.toString()
            description.text = BASE_DESC + descRes

            Glide.with(this@InfoFragment)
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
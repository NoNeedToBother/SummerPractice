package com.example.summerpractice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.summerpractice.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main){
    private var binding: FragmentMainBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)
        binding?.run {
            button.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("CLASS_NAME", "MainFragment")
                findNavController().navigate(
                    R.id.action_mainFragment_to_snackbarFragment, bundle)
            }
        }
    }

}
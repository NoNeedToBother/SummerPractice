package com.example.summerpractice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.summerpractice.databinding.FragmentSettingsBinding
import com.example.summerpractice.databinding.FragmentSnackbarBinding
import com.google.android.material.snackbar.Snackbar

class SnackbarFragment : Fragment(R.layout.fragment_snackbar) {

    private var binding : FragmentSnackbarBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSnackbarBinding.bind(view)
        val className = arguments?.getString("CLASS_NAME")
        binding?.run {
            if (className != null) {
                Snackbar.make(root, className, Snackbar.LENGTH_LONG).show()
                findNavController().navigate(R.id.action_snackbarFragment_to_mainFragment)
            }
        }

    }

}
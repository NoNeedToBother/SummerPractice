package com.example.summerpractice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.summerpractice.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment(R.layout.fragment_settings) {
    private var binding: FragmentSettingsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSettingsBinding.bind(view)
        binding?.run {
            button.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("CLASS_NAME", "SettingsFragment")
                findNavController().navigate(
                    R.id.action_settingsFragment_to_snackbarFragment, bundle)
            }
        }
    }
}
package com.example.summerpractice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.summerpractice.databinding.FragmentNotesBinding

class NotesFragment : Fragment(R.layout.fragment_notes) {
    private var binding: FragmentNotesBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNotesBinding.bind(view)
        binding?.run {
            button.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("CLASS_NAME", "NotesFragment")
                findNavController().navigate(
                    R.id.action_notesFragment_to_snackbarFragment, bundle)
            }
        }
    }
}
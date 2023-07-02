package com.example.summerpractice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.summerpractice.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment(R.layout.fragment_gallery) {
    private var binding: FragmentGalleryBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGalleryBinding.bind(view)
        binding?.run {
            button.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("CLASS_NAME", "GalleryFragment")
                findNavController().navigate(
                    R.id.action_galleryFragment_to_snackbarFragment, bundle)
            }
        }
    }
}
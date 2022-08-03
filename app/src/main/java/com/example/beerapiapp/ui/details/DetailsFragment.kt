package com.example.beerapiapp.ui.details

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import coil.load
import com.bumptech.glide.Glide
import com.example.beerapiapp.R
import com.example.beerapiapp.databinding.DetailsFragmentBinding
import com.example.beerapiapp.domain.Beer

class DetailsFragment : Fragment() {

    private lateinit var _binding: DetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = DetailsFragmentBinding.inflate(layoutInflater)

        _binding.tvName.text = this.requireArguments().getString("name")
        _binding.tvTagline.text = this.requireArguments().getString("tagline")
        _binding.tvDescription.text = this.requireArguments().getString("description")

        activity?.let {
            Glide.with(it.applicationContext)
                .load(this.requireArguments().getString("image_url"))
                .into(_binding.ivBeerImage)
        }

        return _binding.root
    }

}
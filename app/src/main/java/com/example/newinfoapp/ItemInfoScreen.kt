package com.example.newinfoapp

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.newinfoapp.databinding.ItemInfoScreenBinding

class ItemInfoScreen : Fragment(R.layout.item_info_screen) {

    private val binding by viewBinding(ItemInfoScreenBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.getInt("id")
        if (id != null) {
            val data = DataManager.getItem(id)
            if (data != null) {

                Glide.with(requireContext())
                    .load(data.img2)
                    .into(binding.image)
               // binding.image.setImageResource(data.img2)
                binding.name.text = data.name
                binding.information.text = data.fullDescription
            }
        }

        binding.back.setOnClickListener{
            Log.d("TTT", "it is working")
             parentFragmentManager.popBackStack()
        }

    }
}
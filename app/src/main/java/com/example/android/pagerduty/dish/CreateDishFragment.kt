package com.example.android.pagerduty.dish

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment
import com.example.android.pagerduty.R
import com.example.android.pagerduty.databinding.FragmentCreateDishBinding

class CreateDishFragment :Fragment(){
    private lateinit var binding: FragmentCreateDishBinding
    private val viewModel: DishListViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_create_dish,container,false)
        binding.saveButton.setOnClickListener {
            var name = binding.nameBox.text.toString()
            var desc = binding.descriptionBox.text.toString()
            viewModel.addDish(name,desc)
            val action= CreateDishFragmentDirections.actionCreateDishFragment2ToDishListFragment()
            NavHostFragment.findNavController(this).navigate(action)
        }
        binding.cancelButton.setOnClickListener{
            binding.nameBox.text.clear()
            binding.descriptionBox.text.clear()
            val action= CreateDishFragmentDirections.actionCreateDishFragment2ToDishListFragment()
            NavHostFragment.findNavController(this).navigate(action)
        }

        return binding.root

    }
}
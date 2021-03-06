package com.example.android.pagerduty

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.android.pagerduty.databinding.FragmentWelcomeScreenBinding

class WelcomeFragment : Fragment() {
    private lateinit var binding : FragmentWelcomeScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_welcome_screen,container,false);
        binding.welcomeGoButton.setOnClickListener{
            val action= WelcomeFragmentDirections.actionWelcomeFragmentToDishListFragment()
            NavHostFragment.findNavController(this).navigate(action)
        }
        return binding.root
    }
}
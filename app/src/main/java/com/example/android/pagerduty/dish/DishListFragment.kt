package com.example.android.pagerduty.dish

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import com.example.android.pagerduty.R
import com.example.android.pagerduty.databinding.FragmentDishListBinding


class DishListFragment : Fragment() {
    private lateinit var binding: FragmentDishListBinding
    private val viewModel: DishListViewModel by activityViewModels()
    private val adapter= DishListAdapter(DishListAdapter.OnClickListener{
        viewModel.deleteDish(it);
    })
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel._dishlist.observe(viewLifecycleOwner, Observer {
            it.apply {
                adapter.submitList(this)
            }
        })
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_dish_list, container, false)
        viewModel._dishlist.observe(viewLifecycleOwner, Observer {
            adapter.notifyDataSetChanged()
        })
        binding.createDishButton.setOnClickListener{
            val action=DishListFragmentDirections.actionDishListFragmentToCreateDishFragment2()
            NavHostFragment.findNavController(this).navigate(action)
        }

        binding.dishRecycler.adapter=adapter
        return binding.root

    }
}
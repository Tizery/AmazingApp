package com.example.amazingapp.ui.picture

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.amazingapp.R
import com.example.amazingapp.databinding.BottomNavigationLayoutBinding
import com.example.amazingapp.ui.animations.AnimationsFragment
import com.example.amazingapp.ui.animations.ObjectAnimatorFragment
import com.example.amazingapp.ui.animations.TapAnimationsFragment
import com.example.amazingapp.ui.coordinator.CoordinatorFragment
import com.example.amazingapp.ui.recycler.RecyclerFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class BottomNavigationDrawerFragment : BottomSheetDialogFragment() {

    private var _binding: BottomNavigationLayoutBinding? = null
    val binding: BottomNavigationLayoutBinding
        get() {
            return _binding!!
        }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.navigationView.setNavigationItemSelectedListener { menuItem ->

            when (menuItem.itemId) {
                R.id.navigation_one -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .addToBackStack(null)
                        .replace(
                            R.id.container,
                            CoordinatorFragment.newInstance()
                        ).commit()
                }
                R.id.navigation_two -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .addToBackStack(null)
                        .replace(
                            R.id.container,
                            AnimationsFragment.newInstance()
                        ).commit()
                }
                R.id.navigation_three -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .addToBackStack(null)
                        .replace(
                            R.id.container,
                            TapAnimationsFragment.newInstance()
                        ).commit()
                }
                R.id.navigation_four -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .addToBackStack(null)
                        .replace(
                            R.id.container,
                            ObjectAnimatorFragment.newInstance()
                        ).commit()
                }
                R.id.navigation_five -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .addToBackStack(null)
                        .replace(
                            R.id.container,
                            RecyclerFragment.newInstance()
                        ).commit()
                }
            }
            dismiss()
            true
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomNavigationLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }
}

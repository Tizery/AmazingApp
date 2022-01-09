package com.example.amazingapp.ui.coordinator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.Fragment
import com.example.amazingapp.R
import com.example.amazingapp.databinding.FragmentCoordinatorBinding

class CoordinatorFragment : Fragment() {


    private var _binding: FragmentCoordinatorBinding? = null
    val binding: FragmentCoordinatorBinding
        get() {
            return _binding!!
        }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCoordinatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nestedBehavior= NestedBehavior()
        (binding.nested.layoutParams as CoordinatorLayout.LayoutParams).behavior = nestedBehavior
        binding.myButton.setOnClickListener {
            Toast.makeText(context, "Hello!", Toast.LENGTH_SHORT).show() }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            CoordinatorFragment()
    }
}
package com.example.amazingapp.ui.api

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.amazingapp.R
import com.example.amazingapp.databinding.FragmentEarthBinding


class EarthFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_earth,container,false)
    }


//    private var _binding: FragmentEarthBinding? = null
//    val binding: FragmentEarthBinding
//        get() {
//            return _binding!!
//        }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        _binding = null
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        _binding = FragmentEarthBinding.inflate(inflater, container, false)
//        return binding.root
//    }
}
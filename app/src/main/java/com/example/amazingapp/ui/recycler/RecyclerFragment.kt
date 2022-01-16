package com.example.amazingapp.ui.recycler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.amazingapp.databinding.FragmentRecyclerBinding

class RecyclerFragment : Fragment() {

    private var _binding: FragmentRecyclerBinding? = null
    val binding: FragmentRecyclerBinding
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
        _binding = FragmentRecyclerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = arrayListOf(
            Data("Earth", type = TYPE_EARTH) to false,
            Data("Mars", "", type = TYPE_MARS) to false
        )
        data.add(0, Data("Заголовок", type = TYPE_HEADER) to false)


        val adapter = RecyclerFragmentAdapter(data,
            object : MyCallback {
                override fun onClick(position: Int) {
                    Toast.makeText(
                        requireContext(),
                        "Всё работает! Это ${data[position].first.someText}",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            })
        binding.recyclerView.adapter = adapter
        binding.recyclerFragmentFAB.setOnClickListener {
            adapter.appendItem()
        }
        ItemTouchHelper(ItemTouchHelperCallback(adapter)).attachToRecyclerView(binding.recyclerView)

    }

    companion object {
        @JvmStatic
        fun newInstance() = RecyclerFragment()
    }
}
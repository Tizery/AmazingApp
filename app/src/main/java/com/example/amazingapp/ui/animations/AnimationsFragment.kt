package com.example.amazingapp.ui.animations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnticipateOvershootInterpolator
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import com.example.amazingapp.R
import com.example.amazingapp.databinding.FragmentAnimationsBinding


class AnimationsFragment : Fragment() {

    var show = false

    private var _binding: FragmentAnimationsBinding? = null
    val binding: FragmentAnimationsBinding
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
        _binding = FragmentAnimationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.root.setOnClickListener {
            if (show) hideComponents() else showComponents()
        }
    }

    private fun showComponents() {
        show = true

        val constraintSet = ConstraintSet()
        constraintSet.clone(requireContext(), R.layout.fragment_animations_end)

        val transition = android.transition.ChangeBounds()
        transition.interpolator = AnticipateOvershootInterpolator(6f)
        transition.duration = 1000

        android.transition.TransitionManager.beginDelayedTransition(binding.root, transition)
        constraintSet.applyTo(binding.root)
    }

    private fun hideComponents() {
        show = false

        val constraintSet = ConstraintSet()
        constraintSet.clone(requireContext(), R.layout.fragment_animations)

        val transition = android.transition.ChangeBounds()
        transition.interpolator = AnticipateOvershootInterpolator(6f)
        transition.duration = 1000

        android.transition.TransitionManager.beginDelayedTransition(binding.root, transition)
        constraintSet.applyTo(binding.root)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            AnimationsFragment()
    }
}
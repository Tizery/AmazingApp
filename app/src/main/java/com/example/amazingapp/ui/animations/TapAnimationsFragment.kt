package com.example.amazingapp.ui.animations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.transition.ChangeBounds
import androidx.transition.ChangeImageTransform
import androidx.transition.TransitionManager
import androidx.transition.TransitionSet
import com.example.amazingapp.databinding.FragmentAnimationsTapBinding

class TapAnimationsFragment : Fragment() {

    var isExpand = false

    private var _binding: FragmentAnimationsTapBinding? = null
    val binding: FragmentAnimationsTapBinding
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
        _binding = FragmentAnimationsTapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageViewEarth.setOnClickListener {
            /*if (isExpand) hideComponents() else showComponents()*/
            isExpand = !isExpand
            val params = binding.imageViewEarth.layoutParams as FrameLayout.LayoutParams
            val transitionSet = TransitionSet()
            val transitionCB = ChangeBounds()
            val transitionImage = ChangeImageTransform()

            transitionCB.duration = 1000
            transitionImage.duration = 1000
            transitionSet.addTransition(transitionCB)
            transitionSet.addTransition(transitionImage)
            TransitionManager.beginDelayedTransition(binding.root, transitionSet)

            if (isExpand) {
                binding.imageViewEarth.scaleType = ImageView.ScaleType.CENTER_CROP
                params.height = FrameLayout.LayoutParams.MATCH_PARENT
            } else {
                binding.imageViewEarth.scaleType = ImageView.ScaleType.CENTER_INSIDE
                params.height = FrameLayout.LayoutParams.WRAP_CONTENT
            }
        }
    }

   /* private fun showComponents() {
        isExpand = true

        val params = binding.imageViewEarth.layoutParams as FrameLayout.LayoutParams
        val transitionSet = TransitionSet()
        val transitionCB = ChangeBounds()
        val transitionImage = ChangeImageTransform()

        transitionCB.duration = 1500
        transitionImage.duration = 1500
        transitionSet.addTransition(transitionCB)
        transitionSet.addTransition(transitionImage)
        TransitionManager.beginDelayedTransition(binding.root, transitionSet)

        binding.imageViewEarth.scaleType = ImageView.ScaleType.CENTER_CROP
        params.height = FrameLayout.LayoutParams.MATCH_PARENT
    }*/

    /*private fun hideComponents() {
        isExpand = false

        val params = binding.imageViewEarth.layoutParams as FrameLayout.LayoutParams
        val transitionSet = TransitionSet()
        val transitionCB = ChangeBounds()
        val transitionImage = ChangeImageTransform()

        transitionCB.duration = 1500
        transitionImage.duration = 1500
        transitionSet.addTransition(transitionCB)
        transitionSet.addTransition(transitionImage)
        TransitionManager.beginDelayedTransition(binding.root, transitionSet)

        binding.imageViewEarth.scaleType = ImageView.ScaleType.CENTER_INSIDE
        params.height = FrameLayout.LayoutParams.WRAP_CONTENT
    }*/

    companion object {
        @JvmStatic
        fun newInstance() =
            TapAnimationsFragment()
    }
}
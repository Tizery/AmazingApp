package com.example.amazingapp.ui.animations

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.amazingapp.databinding.FragmentAnimatorObjectBinding

private const val duration = 500L

class ObjectAnimatorFragment : Fragment() {

    var isExpanded = false

    private var _binding: FragmentAnimatorObjectBinding? = null
    val binding: FragmentAnimatorObjectBinding
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
        _binding = FragmentAnimatorObjectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.transparentBackground.alpha = 0f
        binding.optionOneContainer.alpha = 0f
        binding.optionOneContainer.isClickable = false
        binding.optionTwoContainer.alpha = 0f
        binding.optionTwoContainer.isClickable = false

        binding.fab.setOnClickListener {
            if (isExpanded) {
                isExpanded = false
                ObjectAnimator.ofFloat(binding.plusImageview, "rotation", 360f, 0f)
                    .setDuration(duration).start()
                ObjectAnimator.ofFloat(binding.optionOneContainer, "translationX", 0f)
                    .setDuration(duration).start()
                ObjectAnimator.ofFloat(binding.optionTwoContainer, "translationX", 0f)
                    .setDuration(duration).start()
                binding.optionOneContainer.animate()
                    .alpha(0f)
                    .setDuration(duration)
                    .setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator?) {
                            super.onAnimationEnd(animation)
                            binding.optionOneContainer.isClickable = false
                        }
                    })
                binding.optionTwoContainer.animate()
                    .alpha(0f)
                    .setDuration(duration)
                    .setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator?) {
                            super.onAnimationEnd(animation)
                            binding.optionTwoContainer.isClickable = false
                        }
                    })
                binding.transparentBackground.animate()
                    .alpha(0f)
                    .setDuration(duration)
            } else {
                isExpanded = true
                ObjectAnimator.ofFloat(binding.plusImageview, "rotation", 0f, 360f)
                    .setDuration(duration).start()
                ObjectAnimator.ofFloat(binding.optionOneContainer, "translationX", -600f)
                    .setDuration(duration).start()
                ObjectAnimator.ofFloat(binding.optionTwoContainer, "translationX", -300f)
                    .setDuration(duration).start()
                binding.optionOneContainer.animate()
                    .alpha(1f)
                    .setDuration(duration)
                    .setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator?) {
                            super.onAnimationEnd(animation)
                            binding.optionOneContainer.isClickable = true
                        }
                    })
                binding.optionTwoContainer.animate()
                    .alpha(1f)
                    .setDuration(duration)
                    .setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator?) {
                            super.onAnimationEnd(animation)
                            binding.optionTwoContainer.isClickable = true
                        }
                    })

                binding.transparentBackground.animate()
                    .alpha(0.8f)
                    .setDuration(0)
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ObjectAnimatorFragment()
    }
}
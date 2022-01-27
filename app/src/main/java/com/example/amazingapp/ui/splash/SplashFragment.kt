package com.example.amazingapp.ui.splash

import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.fragment.app.Fragment
import com.example.amazingapp.R
import com.example.amazingapp.databinding.FragmentSplashBinding
import com.example.amazingapp.ui.picture.PictureOfTheDayFragment

class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    val binding: FragmentSplashBinding
        get() {
            return _binding!!
        }

    private val handler: Handler by lazy {
        Handler(Looper.getMainLooper())
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        handler.removeCallbacksAndMessages(null)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*binding.imageView.animate().rotationBy(1080f).setInterpolator(
            LinearInterpolator()
        ).duration = 3000*/

        val animator = ObjectAnimator.ofFloat(binding.imageView, View.SCALE_X, -1f);
        animator.duration = 500
        animator.repeatCount = 5
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.start()

        handler.postDelayed(Runnable {
            if (savedInstanceState == null) {
                requireActivity().supportFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(
                        R.id.container,
                        PictureOfTheDayFragment.newInstance()
                    ).commit()
            }
        }, 2000)
    }

    companion object {
        @JvmStatic
        fun newInstance() = SplashFragment()
    }
}
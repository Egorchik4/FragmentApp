package com.example.fragmentapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentapp.databinding.FragmentBBinding

class FragmentB : Fragment() {

	private lateinit var binding: FragmentBBinding

	companion object {

		const val FRAGMENT_B_TAG = "FRAGMENT_B_TAG"
		const val MESSAGE = "Hello Fragment C"

		fun newInstance() = FragmentB()
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
		binding = FragmentBBinding.inflate(inflater)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		binding.buttonToA.setOnClickListener {
			(requireActivity() as? FragmentNavigationListener)?.navigateToFragmentA()
		}

		binding.buttonToC.setOnClickListener {
			(requireActivity() as? FragmentNavigationListener)?.navigateToFragmentC(MESSAGE)
		}
	}
}
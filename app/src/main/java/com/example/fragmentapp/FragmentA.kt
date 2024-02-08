package com.example.fragmentapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentapp.databinding.FragmentABinding

class FragmentA : Fragment() {

	private lateinit var binding: FragmentABinding

	companion object {

		const val FRAGMENT_A_TAG = "FRAGMENT_A_TAG"

		fun newInstance() = FragmentA()

	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
		binding = FragmentABinding.inflate(inflater)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		Log.e("eee", "ViewCreated A")
		binding.buttonToB.setOnClickListener {
			(requireActivity() as? FragmentNavigationListener)?.navigateToFragmentB()
		}
	}
}
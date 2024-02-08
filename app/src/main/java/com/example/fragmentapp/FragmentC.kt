package com.example.fragmentapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentapp.databinding.FragmentCBinding

class FragmentC : Fragment() {

	private lateinit var binding: FragmentCBinding
	private var param1: String? = null

	companion object {

		const val PARAM_FRAGMENT_C = "PARAM_FRAGMENT_C"
		const val FRAGMENT_C_TAG = "FRAGMENT_C_TAG"

		fun newInstance(text: String) =
			FragmentC().apply {
				arguments = Bundle().apply {
					putString(PARAM_FRAGMENT_C, text)
				}
			}
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		arguments?.let {
			param1 = it.getString(PARAM_FRAGMENT_C)
		}
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
		binding = FragmentCBinding.inflate(inflater)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		Log.e("eee", "ViewCreated C")
		binding.textMessage.text = param1
		binding.buttonToD.setOnClickListener {
			(requireActivity() as? FragmentNavigationListener)?.navigateToFragmentD()
		}

		binding.buttonToA.setOnClickListener {
			(requireActivity() as? FragmentNavigationListener)?.navigateToFragmentA()
		}
	}
}
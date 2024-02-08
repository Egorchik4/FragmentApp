package com.example.fragmentapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentapp.databinding.FragmentDBinding

class FragmentD : Fragment() {

	private lateinit var binding: FragmentDBinding

	companion object {

		const val FRAGMENT_D_TAG = "FRAGMENT_D_TAG"
		fun newInstance() = FragmentD()
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
		binding = FragmentDBinding.inflate(inflater)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		Log.e("eee", "ViewCreated D")
		binding.buttonToB.setOnClickListener {
			(requireActivity() as? FragmentNavigationListener)?.navigateToFragmentB()
		}
	}
}
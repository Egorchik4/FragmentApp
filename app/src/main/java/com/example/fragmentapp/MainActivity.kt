package com.example.fragmentapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.fragmentapp.FragmentA.Companion.FRAGMENT_A_TAG
import com.example.fragmentapp.FragmentB.Companion.FRAGMENT_B_TAG
import com.example.fragmentapp.FragmentC.Companion.FRAGMENT_C_TAG
import com.example.fragmentapp.FragmentD.Companion.FRAGMENT_D_TAG
import com.example.fragmentapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), FragmentNavigationListener {

	private lateinit var binding: ActivityMainBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
		if (supportFragmentManager.backStackEntryCount == 0) {
			navigateToFragmentA()
		}
	}

	override fun navigateToFragmentA() {
		if (supportFragmentManager.findFragmentByTag(FRAGMENT_A_TAG) == null) {
			supportFragmentManager.commit {
				replace(R.id.fragmentContainer, FragmentA.newInstance(), FRAGMENT_A_TAG)
				addToBackStack(FRAGMENT_A_TAG)
			}
		} else {
			supportFragmentManager.popBackStack(FRAGMENT_A_TAG, 0)
		}
	}

	override fun navigateToFragmentB() {
		if (supportFragmentManager.findFragmentByTag(FRAGMENT_B_TAG) == null) {
			supportFragmentManager.commit {
				replace(R.id.fragmentContainer, FragmentB.newInstance(), FRAGMENT_B_TAG)
				addToBackStack(FRAGMENT_B_TAG)
			}
		} else {
			supportFragmentManager.popBackStack(FRAGMENT_B_TAG, 0)
		}
	}

	override fun navigateToFragmentC(textMessage: String) {
		supportFragmentManager.commit {
			replace(R.id.fragmentContainer, FragmentC.newInstance(textMessage), FRAGMENT_C_TAG)
			addToBackStack(FRAGMENT_C_TAG)
		}
	}

	override fun navigateToFragmentD() {
		supportFragmentManager.commit {
			replace(R.id.fragmentContainer, FragmentD.newInstance(), FRAGMENT_D_TAG)
			addToBackStack(FRAGMENT_D_TAG)
		}
	}
}
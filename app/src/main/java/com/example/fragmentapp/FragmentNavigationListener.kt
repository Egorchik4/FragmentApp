package com.example.fragmentapp

interface FragmentNavigationListener {

	fun navigateToFragmentA()

	fun navigateToFragmentB()

	fun navigateToFragmentC(textMessage: String)

	fun navigateToFragmentD()
}
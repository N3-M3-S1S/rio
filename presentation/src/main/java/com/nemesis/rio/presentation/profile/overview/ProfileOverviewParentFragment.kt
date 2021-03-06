package com.nemesis.rio.presentation.profile.overview

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.nemesis.rio.domain.profile.Profile
import com.nemesis.rio.presentation.R
import com.nemesis.rio.presentation.databinding.FragmentProfileOverviewBinding
import com.nemesis.rio.presentation.utils.extensions.fragmentRetainedScope
import org.koin.android.ext.android.inject
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.parameter.parametersOf
import org.koin.core.scope.Scope

abstract class ProfileOverviewParentFragment<P : Profile> :
    Fragment(R.layout.fragment_profile_overview), AndroidScopeComponent, MenuProvider {
    private val viewBinding by viewBinding<FragmentProfileOverviewBinding>()
    private val childFragmentsNavigator: ProfileOverviewChildFragmentsNavigator by inject()
    private lateinit var toolbarTitle: String
    protected lateinit var viewModel: ProfileOverviewViewModel<P>
        private set

    override val scope: Scope by fragmentRetainedScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        childFragmentsNavigator.setup(
            childFragmentManager,
            R.id.profile_overview_child_fragment_container
        )
        val profile = getProfileFromArguments(requireArguments())
        viewModel = getViewModel { parametersOf(profile) }
        toolbarTitle = profile.name
    }

    protected abstract fun getProfileFromArguments(arguments: Bundle): P

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupViewBinding()
        setupBottomNavigation()
        setupToolbarMenu()
    }

    private fun setupViewBinding() {
        with(viewBinding) {
            lifecycleOwner = viewLifecycleOwner
            viewModel = this@ProfileOverviewParentFragment.viewModel
        }
    }

    private fun setupBottomNavigation() {
        with(viewBinding.profileOverviewBottomNavigation) {
            inflateMenu(childFragmentsNavigator.bottomNavigationMenuId)
            setOnItemSelectedListener { menuItem ->
                childFragmentsNavigator.showChildFragmentForBottomNavigationMenuOptionId(menuItem.itemId)
                true
            }
        }
    }

    private fun setupToolbarMenu() {
        requireActivity().addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.STARTED)
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.fragment_profile_overview_toolbar_menu, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        if (menuItem.itemId == R.id.profile_overview_open_in_browser) {
            viewModel.onOpenProfileInBrowserClicked()
            return true
        }
        return false
    }

    override fun onStart() {
        super.onStart()
        if (childFragmentManager.fragments.isEmpty()) {
            showChildFragmentForSelectedMenuItem()
        }
    }

    override fun onResume() {
        super.onResume()
        requireActivity().title = toolbarTitle
    }

    private fun showChildFragmentForSelectedMenuItem() {
        val selectedMenuItemId = viewBinding.profileOverviewBottomNavigation.selectedItemId
        childFragmentsNavigator.showChildFragmentForBottomNavigationMenuOptionId(
            selectedMenuItemId
        )
    }
}

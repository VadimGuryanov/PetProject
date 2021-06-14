package kpfu.itis.petproject.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kpfu.itis.petproject.R
import kpfu.itis.petproject.utils.functions.provideViewModel
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein

class SplashFragment : Fragment(R.layout.fragment_splash), KodeinAware {

    override val kodein: Kodein by kodein()

    private val viewModel: SplashViewModel by provideViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.navigateToCharacters()
        viewModel.navToCharacters.observe(viewLifecycleOwner, Observer {
            if (it) {
                findNavController().navigate(R.id.action_splashFragment_to_charactersFragment)
            }
        })
    }
}

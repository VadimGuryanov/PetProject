package kpfu.itis.petproject.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kpfu.itis.petproject.R
import kpfu.itis.petproject.utils.functions.provideViewModel
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.android.x.kodein

class SplashFragment : Fragment(R.layout.fragment_splash), KodeinAware {

    override val kodein: Kodein by closestKodein()

    private val viewModel: SplashViewModel by provideViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.navigateToCharacters()
    }
}

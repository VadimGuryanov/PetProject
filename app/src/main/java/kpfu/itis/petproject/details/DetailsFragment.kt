package kpfu.itis.petproject.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_details.*
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kpfu.itis.petproject.R
import kpfu.itis.petproject.utils.functions.provideViewModel
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein

class DetailsFragment: Fragment(R.layout.fragment_details), KodeinAware {

    override val kodein: Kodein by kodein()

    private val viewModel: DetailsViewModel by provideViewModel()

    private val args: DetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCharactersTransactionStream()
        viewModel.getCharacterDetails(args.userId)
    }

    private fun initCharactersTransactionStream() {
        viewModel.character.flowWithLifecycle(lifecycle)
            .onEach {
                it?.let {
                    viewModel.getData(it.episode, it.location)
                    tv_json.text = it.toString()
                }
            }
            .launchIn(lifecycleScope)

        viewModel.episodes.flowWithLifecycle(lifecycle)
            .onEach {
                tv_json.text = ("${tv_json.text}----${it}")
            }
            .launchIn(lifecycleScope)

        viewModel.locations.flowWithLifecycle(lifecycle)
            .onEach {
                tv_json.text = ("${tv_json.text}----${it}")
            }
            .launchIn(lifecycleScope)
    }

}
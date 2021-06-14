package kpfu.itis.petproject.details

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.paging.map
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_characters.*
import kotlinx.android.synthetic.main.fragment_details.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kpfu.itis.petproject.R
import kpfu.itis.petproject.adapter.CharacterLoadStateAdapter
import kpfu.itis.petproject.adapter.CharactersAdapter
import kpfu.itis.petproject.list.CharactersFragmentDirections
import kpfu.itis.petproject.list.CharactersViewModel
import kpfu.itis.petproject.utils.functions.provideViewModel
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein

class DetailsFragment: Fragment(R.layout.fragment_details), KodeinAware {

    override val kodein: Kodein by closestKodein()

    private val viewModel: DetailsViewModel by provideViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCharactersTransactionStream()
        val userId = arguments?.getInt("userId") ?: 1
        Log.e("userId", userId.toString())
        viewModel.getCharacterDetails(userId)
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

        viewModel.locations.flowWithLifecycle(lifecycle)
            .onEach {
                tv_json.text = ("${tv_json.text}----${it}")
            }
    }

}
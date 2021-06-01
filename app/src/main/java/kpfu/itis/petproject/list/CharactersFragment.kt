package kpfu.itis.petproject.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.fragment_characters.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kpfu.itis.petproject.R
import kpfu.itis.petproject.adapter.CharactersAdapter
import kpfu.itis.petproject.utils.functions.provideViewModel
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein

class CharactersFragment : Fragment(R.layout.fragment_characters), KodeinAware {

    override val kodein: Kodein by closestKodein()

    private val viewModel: CharactersViewModel by provideViewModel()

    private var adapter: CharactersAdapter? = null

    private var charactersJob: Job? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initCharactersTransactionStream()
    }

    private fun initCharactersTransactionStream() {
        charactersJob?.cancel()
        charactersJob = lifecycleScope.launch {
            viewModel.characterStream.collectLatest {
                adapter?.submitData(it)
            }
        }
    }

    private fun initView() {
        rv_rates_star_list.adapter = CharactersAdapter { }
    }

}

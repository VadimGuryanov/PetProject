package kpfu.itis.petproject.adapter

import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter

class CharacterLoadStateAdapter : LoadStateAdapter<LoadingHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadingHolder =
        LoadingHolder.create(parent)

    override fun onBindViewHolder(holder: LoadingHolder, loadState: LoadState) {
        holder.bind(loadState)
    }
}

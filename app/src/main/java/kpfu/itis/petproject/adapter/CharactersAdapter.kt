package kpfu.itis.petproject.adapter

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kpfu.itis.petproject.api.model.Character

class CharactersAdapter(
    private val onCLickListener: (Int) -> Unit
) : PagingDataAdapter<Character, RecyclerView.ViewHolder>(
    object : DiffUtil.ItemCallback<Character>() {
        override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean =
            oldItem == newItem
    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        CharactersHolder.newInstance(parent, onCLickListener)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        getItem(position)?.let { character ->
            (holder as? CharactersHolder)?.apply { bind(character) }
        }
    }
}

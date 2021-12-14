package kpfu.itis.petproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_loading.view.*
import kpfu.itis.petproject.R

class LoadingHolder(
    override val containerView: View
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(state: LoadState) {
        itemView.progress.isVisible = state is LoadState.Loading
    }

    companion object {

        fun create(parent: ViewGroup) =
            LoadingHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_loading, parent, false))
    }
}

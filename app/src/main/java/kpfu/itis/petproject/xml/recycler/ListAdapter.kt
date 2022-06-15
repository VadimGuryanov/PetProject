package kpfu.itis.petproject.xml

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kpfu.itis.petproject.R
import test.plugin.project.xml.recycler.ItemHolder

class ListAdapter(
      private val cardList: List<String>,
      private val clickListener: () -> Unit
) : RecyclerView.Adapter<ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder =
        ItemHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent,false)
        )

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(cardList[position])
        holder.itemView.setOnClickListener {
            clickListener()
        }
    }

    override fun getItemCount(): Int = cardList.size
}

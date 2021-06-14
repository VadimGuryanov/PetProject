package kpfu.itis.petproject.adapter

import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_characters.view.*
import kpfu.itis.petproject.R
import kpfu.itis.petproject.api.model.Character

class CharactersHolder(
    override val containerView: View,
    val glideManager: RequestManager,
    val onClickListener: (Int) -> Unit
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(character: Character) {
        with(containerView) {
            tv_name.text = character.name
            tv_last_location.text = character.location.name
            tv_origin.text = character.origin.name
            tv_status_and_species_and_gender.text = context.getString(
                R.string.status_and_species_mask,
                character.statusStr,
                character.species,
                character.gender
            )
            iv_status.setColorFilter(
                ContextCompat.getColor(context, getStatusResId(character.statusStr)),
                PorterDuff.Mode.SRC_IN
            )
            glideManager.load(character.image)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(iv_character)
            setOnClickListener { onClickListener(character.id) }
        }
    }

    private fun getStatusResId(status: String) = when (status) {
        "Alive" -> R.color.bkg_status_green
        "Dead" -> R.color.bkg_status_red
        else -> R.color.bkg_status_gray
    }

    companion object {

        fun newInstance(parent: ViewGroup, glideManager: RequestManager, onClickListener: (Int) -> Unit) =
            LayoutInflater.from(parent.context).inflate(R.layout.item_characters, parent, false).let {
                CharactersHolder(it, glideManager, onClickListener)
            }
    }
}
package kpfu.itis.petproject.adapter

import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_characters.view.*
import kpfu.itis.petproject.R
import kpfu.itis.petproject.api.model.Character
import kpfu.itis.petproject.api.model.Status

class CharactersHolder(
    override val containerView: View,
    val onClickListener: (Int) -> Unit
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(character: Character) {
        with(containerView) {
            tv_name.text = character.name
            tv_last_location.text = character.location.name
            tv_origin.text = character.origin.name
            tv_status_and_species_and_gender.text = context.getString(
                R.string.status_and_species_mask,
                character.status,
                character.species,
                character.gender
            )
            iv_status.setColorFilter(
                ContextCompat.getColor(context, getStatusResId(character.status)),
                PorterDuff.Mode.SRC_IN
            )
        }
    }

    private fun getStatusResId(status: Status) = when (status) {
        Status.ALIVE -> R.color.bkg_status_green
        Status.DEAD -> R.color.bkg_status_red
        Status.UNKNOWN -> R.color.bkg_status_gray
    }

    companion object {

        fun newInstance(parent: ViewGroup, onClickListener: (Int) -> Unit) =
            LayoutInflater.from(parent.context).inflate(R.layout.item_characters, parent, false).let {
                CharactersHolder(it, onClickListener)
            }
    }
}
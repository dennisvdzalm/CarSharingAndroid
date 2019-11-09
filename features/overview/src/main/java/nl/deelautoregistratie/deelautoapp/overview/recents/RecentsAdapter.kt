package nl.deelautoregistratie.deelautoapp.overview.recents

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import nl.deelautoregistratie.deelautoapp.overview.databinding.CarSessionItemViewBinding
import nl.deelautregistratie.domain.model.CarSession

class RecentsAdapter : ListAdapter<CarSession, CarSessionItemViewHolder>(POST_COMPARATOR) {
    override fun onBindViewHolder(holder: CarSessionItemViewHolder, position: Int) =
        holder.bind(getItem(position))


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarSessionItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CarSessionItemViewBinding.inflate(layoutInflater, parent, false)
        return CarSessionItemViewHolder(binding)
    }

    companion object {
        val POST_COMPARATOR = object : DiffUtil.ItemCallback<CarSession>() {
            override fun areItemsTheSame(oldItem: CarSession, newItem: CarSession): Boolean =
                    oldItem.id == newItem.id


            override fun areContentsTheSame(oldItem: CarSession, newItem: CarSession): Boolean =
                    oldItem == newItem
        }
    }
}


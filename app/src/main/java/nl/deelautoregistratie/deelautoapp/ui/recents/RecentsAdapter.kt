package nl.deelautoregistratie.deelautoapp.ui.recents

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.view.ViewGroup
import nl.deelautoregistratie.deelautoapp.data.model.CarSession

class RecentsAdapter : PagedListAdapter<CarSession, CarSessionItemViewHolder>(POST_COMPARATOR) {
    override fun onBindViewHolder(holder: CarSessionItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarSessionItemViewHolder {
        return CarSessionItemViewHolder.create(parent)
    }

    companion object {
        private val PAYLOAD_SCORE = Any()
        val POST_COMPARATOR = object : DiffUtil.ItemCallback<CarSession>() {
            override fun areItemsTheSame(oldItem: CarSession, newItem: CarSession): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: CarSession, newItem: CarSession): Boolean {
                return oldItem == newItem
            }
        }
    }
}


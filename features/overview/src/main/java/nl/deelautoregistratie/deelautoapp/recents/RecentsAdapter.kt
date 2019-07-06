package nl.deelautoregistratie.deelautoapp.recents

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import nl.deelautregistratie.domain.model.CarSession

class RecentsAdapter : RecyclerView.Adapter<CarSessionItemViewHolder>() {
    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: CarSessionItemViewHolder, position: Int) {
       // holder.bind(getItem(position))
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


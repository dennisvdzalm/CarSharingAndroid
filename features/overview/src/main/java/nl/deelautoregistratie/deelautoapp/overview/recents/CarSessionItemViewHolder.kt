package nl.deelautoregistratie.deelautoapp.overview.recents

import androidx.recyclerview.widget.RecyclerView
import nl.deelautoregistratie.deelautoapp.overview.databinding.CarSessionItemViewBinding
import nl.deelautregistratie.domain.model.CarSession

class CarSessionItemViewHolder(private val binding: CarSessionItemViewBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(carSession: CarSession?) {
        binding.model = carSession
    }
}
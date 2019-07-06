package nl.deelautoregistratie.deelautoapp.recents

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import nl.deelautoregistratie.deelautoapp.R
import nl.deelautregistratie.domain.model.CarSession

class CarSessionItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val tvMileage: TextView = itemView.findViewById(R.id.tv_mileage)

    fun bind(carSession: CarSession?) {
        tvMileage.text = carSession?.mileage
    }

    companion object {
        fun create(parent: ViewGroup): CarSessionItemViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.car_session_item_view, parent, false)
            return CarSessionItemViewHolder(view)
        }
    }
}
package nl.deelautoregistratie.deelautoapp.ui.recents

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import nl.deelautoregistratie.deelautoapp.R
import nl.deelautoregistratie.deelautoapp.data.model.CarSession

class CarSessionItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val tvMileage: TextView = itemView.findViewById(R.id.tv_mileage)

    fun bind(carSession: CarSession?) {
        val mileage = (carSession?.end ?: 0) - (carSession?.start ?: 0)

        if (mileage == 0) {
            tvMileage.text = "Loading"
        } else {
            tvMileage.text = mileage.toString()
        }
    }

    companion object {
        fun create(parent: ViewGroup): CarSessionItemViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.car_session_item_view, parent, false)
            return CarSessionItemViewHolder(view)
        }
    }
}
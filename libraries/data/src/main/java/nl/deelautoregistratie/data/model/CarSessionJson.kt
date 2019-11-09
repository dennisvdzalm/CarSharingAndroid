package nl.deelautoregistratie.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "carsessions")
data class CarSessionJson(
        @PrimaryKey
        @SerializedName("id")
        val id: Int,
        @SerializedName("user_id")
        val userId: Int,
        @SerializedName("shared_car_id")
        val sharedCarId: Int,
        @SerializedName("start")
        val start: Int,
        @SerializedName("end")
        val end: Int,
        @SerializedName("description")
        val description: String
)
package data.model
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "activities")
data class ActivityEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val title: String,

    val description: String,

    // Guardamos fecha como timestamp (Long)
    val date: Long,

    // Puede ser null si no hay imagen
    val imageUri: String? = null
)
package qu.cmps312.countryvisit.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity
data class Country(
    @PrimaryKey
    val code: String,
    val name: String,
    val continent: String
) {
    override fun toString(): String {
        return name
    }
}
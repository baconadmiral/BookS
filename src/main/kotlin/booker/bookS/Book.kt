package booker.bookS

import javax.persistence.*

@Entity
@Table(name = "book")
data class Book(
        var title: String = "",

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0
){
    override fun toString(): String{
        return "{title: ${title}"
    }
}
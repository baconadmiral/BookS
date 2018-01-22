package booker.bookS

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table


@Entity @Table(name = "bookshelf")
data class BookShelf(
        var owner: String = "",

        @OneToMany(cascade = arrayOf(CascadeType.ALL))
        var books: MutableList<Book> = mutableListOf(),

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0
){
    override fun toString(): String{
        return "{owner: ${this.owner}, books: ${books.map { it->it.title }}}";
    }
}
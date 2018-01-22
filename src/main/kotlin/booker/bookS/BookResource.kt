package booker.bookS

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.config.annotation.EnableWebMvc

interface BookRepository: JpaRepository<Book, Long>

@RestController
@RequestMapping(value = "/book") @EnableWebMvc
class BookResource(val bookRepo: BookRepository) {

    @GetMapping(value = "/a")
    fun getAll() = bookRepo.findAll()

    @GetMapping(value = "/{id}")
    fun getOne(@PathVariable id: Long) = bookRepo.findOne(id)

    @PostMapping(value ="/")
    fun new(@RequestBody title: String) = bookRepo.save(Book(title = title))//, bookShelf = bookShelf))

    @DeleteMapping(value = "/{id}")
    fun delete(@PathVariable id: Long) = bookRepo.delete(id)


    @PutMapping(value = "/{id}")
    fun update(@PathVariable id: Long, @RequestBody book: Book) : Book{
        val bookToUpdate = bookRepo.getOne(id)

        bookToUpdate.title = book.title;
        //bookToUpdate.bookshelf = book.bookshelf;

        return bookRepo.save(bookToUpdate)

    }
}

/*@Entity @Table(name="book")
class Book(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id:Long = 0, var title:String="")*/
//, @ManyToOne(fetch=FetchType.LAZY) var bookShelf: BookShelf)
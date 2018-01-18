package booker.bookS

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

interface BookRepository: JpaRepository<Book, Long>

@RestController
@RequestMapping(value = "/book") @EnableWebMvc
class BookResource(val bookRepo: BookRepository) {

    @GetMapping(value = "/a")
    fun getAll() = bookRepo.findAll()

    @GetMapping(value = "/{id}")
    fun getOne(@PathVariable id: Long) = bookRepo.findOne(id)

    @PostMapping(value ="/")
    fun new(@RequestBody title: String) = bookRepo.save(Book(title = title))

    @DeleteMapping(value = "/{id}")
    fun delete(@PathVariable id: Long) = bookRepo.delete(id)


    @PutMapping(value = "/{id}")
    fun update(@PathVariable id: Long, @RequestBody book: Book) : Book{
        val bookToUpdate = bookRepo.getOne(id)

        bookToUpdate.title = book.title;

        return bookRepo.save(bookToUpdate)

    }
}

@Entity
class Book(@Id @GeneratedValue(strategy = GenerationType.AUTO)
            val id:Long = 0, var title:String="")
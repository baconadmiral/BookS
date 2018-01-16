package booker.bookS

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import java.time.Instant
import javax.persistence.*

interface BookShelfRepository: JpaRepository<BookShelf, Long>

@RestController @RequestMapping(value = "/bookshelf") @EnableWebMvc
class BookResource(val bookShelfRepo: BookShelfRepository) {

    @GetMapping(value = "/a")
    fun getAll() = bookShelfRepo.findAll()

    @GetMapping(value = "/{id}")
    fun getOne(@PathVariable id: Long) = bookShelfRepo.findOne(id)

    @PostMapping(value ="/")
    fun new(@RequestBody owner: String) = bookShelfRepo.save(BookShelf(owner = owner))

    @DeleteMapping(value = "/{id}")
    fun delete(@PathVariable id: Long) = bookShelfRepo.delete(id)


    @PutMapping(value = "/{id}")
    fun update(@PathVariable id: Long, @RequestBody bookShelf: BookShelf) : BookShelf{
        val shelfToUpdate = bookShelfRepo.getOne(id)

        shelfToUpdate.owner = bookShelf.owner;

        return bookShelfRepo.save(shelfToUpdate)

    }
}

@Entity
class BookShelf(@Id @GeneratedValue(strategy = GenerationType.AUTO)
val id:Long = 0, var owner:String="")

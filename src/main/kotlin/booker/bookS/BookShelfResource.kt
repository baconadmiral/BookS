package booker.bookS

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.config.annotation.EnableWebMvc

interface BookShelfRepository: JpaRepository<BookShelf, Long>

@RestController @RequestMapping(value = "/bookshelf") @EnableWebMvc
class BookShelfResource(val bookShelfRepo: BookShelfRepository) {

    @Autowired
    lateinit var bookRepo: BookRepository


    @GetMapping(value = "/a")
    fun getAll() = bookShelfRepo.findAll()

    @GetMapping(value = "/{id}")
    fun getOne(@PathVariable id: Long) = bookShelfRepo.findOne(id)

    @PostMapping(value ="/")
    fun new(@RequestBody owner: String)
    {
        bookShelfRepo.save(BookShelf(owner = owner))
    }

    @PostMapping(value ="/add")
    fun new(@RequestBody bookId: Long, @RequestBody bookshelfId: Long)
    {
        val addBook = bookRepo.findOne(bookId)
        var shelf = bookShelfRepo.findOne(bookshelfId)

        shelf.books.add(addBook)
        bookShelfRepo.save(shelf)
    }

    @DeleteMapping(value = "/{id}")
    fun delete(@PathVariable id: Long) = bookShelfRepo.delete(id)


    @PutMapping(value = "/{id}")
    fun update(@PathVariable id: Long, @RequestBody bookShelf: BookShelf) : BookShelf{
        val shelfToUpdate = bookShelfRepo.getOne(id)

        shelfToUpdate.owner = bookShelf.owner
        shelfToUpdate.books = bookShelf.books

        return bookShelfRepo.save(shelfToUpdate)

    }
}

/*@Entity
data class BookShelf(@Id @GeneratedValue(strategy = GenerationType.AUTO)
val id:Long = 0, var owner:String="")//, @OneToMany (mappedBy = "bookshelf",
cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY) var bookCollection: List<Book> = emptyList())*/

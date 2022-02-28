package com.codingdojo.mvc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.services.BookServices;

@RestController
public class BookApi {
	private final BookServices bookServices;

	public BookApi(BookServices bookServices) {
		this.bookServices = bookServices;
	}
	
	@RequestMapping("/api/books")
    public List<Book> index() {
        return bookServices.allBooks();
    }
	
	@RequestMapping(value="/api/books", method=RequestMethod.POST)
    public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
        Book book = new Book(title, desc, lang, numOfPages);
        return bookServices.createBook(book);
    }
	
	@RequestMapping("/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        Book book = bookServices.findBook(id);
        return book;
    }
	
	@RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
    public Book update(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
        Book book = bookServices.updateBook(id, title, desc, lang, numOfPages);
        return book;
    }
	//ruta de prueba 
	//@RequestMapping(value="/api/books/todos", method=RequestMethod.PUT)
    //public List<Book> updateTodos(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
     //   List<Book> book = bookServices.updateAllBooks( title, desc, lang, numOfPages);
     //   return book;
   // }
    
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        bookServices.deleteBook(id);
    }
	
}

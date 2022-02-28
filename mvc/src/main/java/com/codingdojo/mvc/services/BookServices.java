package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.repositories.BookRepository;

@Service
public class BookServices {
	//agrege el repositorio de libros a una dependencia 

	private final BookRepository bookRepository;
	
	public BookServices(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	// devolvemos todos los libros 
	
	public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // crea un libro
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // recupera un libro
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    //actualiza un libro 
    public Book updateBook(Long id ,String title, String desc, String lang, Integer numOfPages) {
    	//instanciamos un objeto temporal y no hace falta poner el this ya que solo hay un sola vez el nombre de la variable 
    	Book libroEditado = findBook(id);
    	//libroEditado.setId(id);
    	//Tambien puedes instanciar un objeto nueevo y sucedera que si exite se actualiza y si no se crea
    	//Book libroEditado = new Book();
    	libroEditado.setId(id);
    	libroEditado.setTitle(title);
    	libroEditado.setDescription(desc);
    	libroEditado.setLanguage(lang);
    	libroEditado.setNumberOfPages(numOfPages);
    	//tienes que guardar el objeto que espera la funcion save 
    	return bookRepository.save(libroEditado);
    }
    
    public void deleteBook(Long id) {
    	 bookRepository.deleteById(id);
    }
    
    //actualiza todos los elementos de tus libros  
    //public List<Book> updateAllBooks(String title, String desc, String lang, Integer numOfPages) {
    	//List<Book> librosEditados = bookRepository.findAll();
    	//libroEditado.setId(id);
    	
    	//Book libroEditado = new Book();
    	//librosEditados.forEach(libroEditado -> {
        //	libroEditado.setTitle(title);
        //	libroEditado.setDescription(desc);
        //	libroEditado.setLanguage(lang);
        //	libroEditado.setNumberOfPages(numOfPages);
    	//});

    	
    	//return (List<Book>) bookRepository.saveAll(librosEditados);
    //}
}

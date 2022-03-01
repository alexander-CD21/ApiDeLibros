package com.codingdojo.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.services.BookServices;

@Controller
public class BookController {
	@Autowired
	private  BookServices bookServices;
	//otra opcion al autowired
	//public BookController(BookServices bookServices) {
	//	this.bookServices = bookServices;
	//}

	@RequestMapping("/book/{id}")
	public String  show(@PathVariable("id") Long id, Model model ) {
		Book book =bookServices.findBook(id);
		model.addAttribute("book",book);
		return "show.jsp";
	}
	
	@RequestMapping("/books")
	public String todosLibros(Model model) {
		List<Book> books=bookServices.allBooks();
		model.addAttribute("books",books);
		return "index.jsp";
	}
}

package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.models.Book;
import com.example.demo.services.BookService;

@Controller
public class BookController {
        private final BookService bookService;

        public BookController(BookService bookService) {
            this.bookService = bookService;
        }
        
        // Display all books 
        @RequestMapping("/books/all")
        public String index(Model model) {
            List<Book> books = bookService.allBooks();
            model.addAttribute("books", books);
            return "index.jsp";
        }
        
        // display form page for adding new book
        @RequestMapping("/books/new")
        public String newBook(@ModelAttribute("book") Book book) {
            return "newBookForm.jsp";
        }
        
        // post request for adding new book
        @RequestMapping(value="/books", method= RequestMethod.POST)
        public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
            if (result.hasErrors()) {
                return "newBookForm.jsp";
            }
            else {
                bookService.createBook(book);
                return "redirect:/books/all";
            }
        }
        
        // display specific book by its id
        @RequestMapping("/books/{id}")
        public String show(@PathVariable("id") Long id, Model model) {
            Book book = bookService.findBook(id);
            model.addAttribute("book", book);
            return "showBook.jsp";
        }

        @RequestMapping("/books/{id}/edit")
        public String edit(@PathVariable("id") Long id, Model model) {
            Book book = bookService.findBook(id);
            model.addAttribute("book", book);
            return "editBook.jsp";
        }

        @RequestMapping(value="/books/{id}", method=RequestMethod.POST)
        public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
            if (result.hasErrors()) {
                return "edit.jsp";
            } else {
                bookService.updateBook(book);
                return "redirect:/books/all";
            }
        }

        @RequestMapping(value="/books/{id}/delete", method=RequestMethod.POST)
        public String destroy(@PathVariable("id") Long id) {
            bookService.deleteBook(id);
            return "redirect:/books/all";
        }
}




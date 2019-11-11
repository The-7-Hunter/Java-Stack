package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Book;
import com.example.demo.repositories.BookRepository;

@Service
public class BookService {
    private final BookRepository bookRepository;

    

    public BookService(BookRepository bookRepository) {

        this.bookRepository = bookRepository;

    }

    // returns all the books

    public List<Book> allBooks() {

        return bookRepository.findAll();

    }

    // creates a book

    public Book createBook(Book b) {

        return bookRepository.save(b);

    }

    // retrieves a book

    public Book findBook(Long id) {

        Optional<Book> optionalBook = bookRepository.findById(id);

        if(optionalBook.isPresent()) {

            return optionalBook.get();

        } else {

            return null;

        }

    }
    
    public Book updateBook(Book book) {
    	return bookRepository.save(book);
    }
   
    // Edit a book 
   public Book updateBook(long id, String title, String description, String language, Integer numberOfPages) {
	Optional <Book> bookToEdit = bookRepository.findById(id);
	if(bookToEdit != null) {
		bookToEdit.get().setTitle(title);
		bookToEdit.get().setDescription(description);
		bookToEdit.get().setLanguage(language);
		bookToEdit.get().setNumberOfPages(numberOfPages);
		
		return bookToEdit.get();
	}
	return null;
}
   
  public void deleteBook(long id) {
	  bookRepository.deleteById(id);
  }
    
}





package seminars.fourth.hw;
/*
    Семинар 4. Домашнее задание.
    Задание 2
    У вас есть класс BookService, который использует интерфейс BookRepository для получения информации
    о книгах из базы данных.
    Ваша задача написать unit-тесты для BookService, используя Mockito для создания мок-объекта
    BookRepository.

    2.1 Тестирование BookService
 */


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class BookServiceTest {


    @Test
    void testFindBookById(){
        BookRepository bookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);
        InMemoryBookRepository im = new InMemoryBookRepository();
        Book imBook = im.findById("1");
        when(bookRepository.findById("1")).thenReturn(imBook);

        Book book = bookService.findBookById("1");

        verify(bookRepository).findById("1");
        assertThat(book.getId()).isEqualTo("1");
        assertThat(book.getTitle()).isEqualTo("Book1");
        assertThat(book.getAuthor()).isEqualTo("Author1");
    }

    @Test
    void testFindAllBooks(){
        BookRepository bookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);
        InMemoryBookRepository im = new InMemoryBookRepository();
        List<Book> imBooks = im.findAll();
        when(bookRepository.findAll()).thenReturn(imBooks);

        List<Book> books = bookService.findAllBooks();

        verify(bookRepository).findAll();
        assertThat(books.get(0).getId()).isEqualTo("1");
        assertThat(books.get(0).getTitle()).isEqualTo("Book1");
        assertThat(books.get(0).getAuthor()).isEqualTo("Author1");
        assertThat(books.get(1).getId()).isEqualTo("2");
        assertThat(books.get(1).getTitle()).isEqualTo("Book2");
        assertThat(books.get(1).getAuthor()).isEqualTo("Author2");
    }
}
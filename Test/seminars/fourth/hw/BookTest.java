package seminars.fourth.hw;
/*
    Семинар 4. Домашнее задание.
    Задание 2
    У вас есть класс BookService, который использует интерфейс BookRepository для получения информации
    о книгах из базы данных.
    Ваша задача написать unit-тесты для BookService, используя Mockito для создания мок-объекта
    BookRepository.

    2.2 Тестирование Book
 */
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BookTest {
    Book book;

    @Test
    void testBookGetIdCreatedByConstructor1(){
        String id = "100";
        book = new Book(id);

        assertThat(book.getId()).isEqualTo(id);
    }

    @Test
    void testBookSetIdCreatedByConstructor1(){
        String id = "100";
        String newId = "1001";
        book = new Book(id);
        book.setId(newId);

        assertThat(book.getId()).isEqualTo(newId);
    }

    @Test
    void testBookSetGetTitleCreatedByConstructor1(){
        String title = "Приключения Буратино";
        String id = "100";
        book = new Book(id);
        book.setTitle(title);

        assertThat(book.getTitle()).isEqualTo(title);
    }

    @Test
    void testBookSetGetAuthorCreatedByConstructor1(){
        String author = "Алексей Толстой";
        String id = "100";
        book = new Book(id);
        book.setAuthor(author);

        assertThat(book.getAuthor()).isEqualTo(author);
    }

    @Test
    void testBookGetIdCreatedByConstructor2(){
        String id = "100";
        String title = "Приключения Буратино";
        String author = "Алексей Толстой";
        book = new Book(id, title, author);

        assertThat(book.getId()).isEqualTo(id);
    }

    @Test
    void testBookGetTitleCreatedByConstructor2(){
        String id = "100";
        String title = "Приключения Буратино";
        String author = "Алексей Толстой";
        book = new Book(id, title, author);

        assertThat(book.getTitle()).isEqualTo(title);
    }

    @Test
    void testBookGetAuthorCreatedByConstructor2(){
        String id = "100";
        String title = "Приключения Буратино";
        String author = "Алексей Толстой";
        book = new Book(id, title, author);

        assertThat(book.getAuthor()).isEqualTo(author);
    }

}

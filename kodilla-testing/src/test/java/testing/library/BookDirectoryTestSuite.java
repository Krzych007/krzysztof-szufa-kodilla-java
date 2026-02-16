package testing.library;

import com.kodilla.testing.library.Book;
import com.kodilla.testing.library.BookLibrary;
import com.kodilla.testing.library.LibraryDatabase;
import com.kodilla.testing.library.LibraryUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookDirectoryTestSuite {

    @Mock
    private LibraryDatabase libraryDatabaseMock;

    private BookLibrary bookLibrary;
    private LibraryUser libraryUser;

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++){
            Book theBook = new Book("Title" + n, "Author" + 1, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @BeforeEach
    void before() {
        bookLibrary = new BookLibrary(libraryDatabaseMock);
        libraryUser = new LibraryUser("A", "B", "1");
    }

    @Test
    void testListBooksWithConditionsReturnList() {

        List<Book> resultListOfBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);                   // [5]
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);    // [6]
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);    // [7]
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);                 // [8]
        resultListOfBooks.add(book1);                                                    // [9]
        resultListOfBooks.add(book2);                                                    // [10]
        resultListOfBooks.add(book3);                                                    // [11]
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        assertEquals(4, theListOfBooks.size());
    }

    @Test
    void testListBooksWithConditionMoreThan20() {

        List<Book> resultListOf0Books = new ArrayList<>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks")).thenReturn(resultListOf40Books);

        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");

        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }

    @Test
    void testListBooksWithConditionFragmentShorterThan3() {

        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }


    @Test
    void testListBookInHandOfUserIs0() {

        List<Book> resultOf0BookInHandOf = new ArrayList<>();

        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultOf0BookInHandOf);

        List<Book> theListOfBooks0 = bookLibrary.listBooksInHandsOf(libraryUser);

        assertEquals(0, theListOfBooks0.size());
        verify(libraryDatabaseMock, times(1)).listBooksInHandsOf(libraryUser);
    }

    @Test
    void testListBookInHandOfUserIs1() {

        List<Book> resultOf1BookInHandOf = generateListOfNBooks(1);

        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultOf1BookInHandOf);

        List<Book> theListOfBooks1 = bookLibrary.listBooksInHandsOf(libraryUser);

        assertEquals(1, theListOfBooks1.size());
        verify(libraryDatabaseMock, times(1)).listBooksInHandsOf(libraryUser);
    }

    @Test
    void testListBookInHandOfUserAre5() {

        List<Book> resultOf5BookInHandOf = generateListOfNBooks(5);

        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultOf5BookInHandOf);

        List<Book> theListOfBooks5 = bookLibrary.listBooksInHandsOf(libraryUser);

        assertEquals(5, theListOfBooks5.size());
        verify(libraryDatabaseMock, times(1)).listBooksInHandsOf(libraryUser);
    }
}

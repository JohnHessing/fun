package nl.hessing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BookTest {

    private Book book;

    @Before
    public void init() {
        book = new Book("titel", "schrijver");
    }

    @Test
    public void getTitle() {
        Assert.assertEquals("titel",book.getTitle());
    }

    @Test
    public void setTitle() {
        book.setTitle("TITEL");
        Assert.assertEquals("TITEL",book.getTitle());
    }

    @Test
    public void getAuthor() {
        Assert.assertEquals("schrijver",book.getAuthor());
    }

    @Test
    public void setAuthor() {
        book.setAuthor("SCHRIJVER");
        Assert.assertEquals("SCHRIJVER",book.getAuthor());
    }
}
// Class to handle book details only
class Book {
    private String title;
    private String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    String getTitle() { 
        return title; 
    }
    String getAuthor() { 
        return author; 
    }
}

// Separate class responsible for printing book details
class BookPrinter {
    void print(Book book) {
        System.out.println(book.getTitle() + " by " + book.getAuthor());
    }
}

public class Single_responsibility_principle {
    public static void main(String[] args) {
        Book book = new Book("Salaar", "Prasanth Neel");
        new BookPrinter().print(book);
    }
}


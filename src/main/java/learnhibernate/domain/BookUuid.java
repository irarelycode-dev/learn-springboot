package learnhibernate.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
public class BookUuid {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "uuid2")
    @GenericGenerator(name="uuid2",strategy="uuid2")
    @Column(columnDefinition = "BINARY(16)",updatable = false,nullable = false)
    private UUID id;

    private String title;
    private String isbn;
    private String publisher;


    public BookUuid(){}

    public BookUuid(UUID id, String title, String isbn, String publisher) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}

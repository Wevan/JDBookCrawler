package model;

/**
 * Created by Wean on 2018/1/7.
 */
public class JDModel {
    private int id;
    private String bookId;
    private String bookName;
    private String bookPrice;

    public JDModel() {
    }

    public JDModel(int id, String bookId, String bookName, String bookPrice, String bookImage) {
        this.id = id;
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookImage = bookImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    private String bookImage;

}

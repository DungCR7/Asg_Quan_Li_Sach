package Models;

public class Book_info {


    private String name;
    private String ID;
    private String Athor_name;
    private String Language;
    private float Price;
    private String Publish_date;
    private String ISBN;

    //private String Date_updated;
    public Book_info(String Publish_date, String ISBN, String name, String ID, String Athor_name, String Language, float Price) {
        this.ISBN = ISBN;
        this.Publish_date = Publish_date;
        this.name = name;
        this.ID = ID;
        this.Athor_name = Athor_name;
        this.Language = Language;
        this.Price = Price;
    }

    //Tên cuốn sách
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Id cuốn sách
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    //Tên tác giả
    public String getAthor_name() {
        return Athor_name;
    }

    public void setAthor_name(String Athor_name) {
        this.Athor_name = Athor_name;
    }

    //Ngôn Ngữ
    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String Language) {
        this.Language = Language;
    }

    //Giá sản cuốn sách
    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    //Ngày xuất bản
    public String getPublish_date() {
        return Publish_date;
    }

    public void setPublish_date(String Publish_date) {
        this.Publish_date = Publish_date;
    }

    //ISBN sách
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String toString() {
        return getName() + getID() + getAthor_name() + getLanguage() + getPrice() + getPublish_date() + getISBN();
    }

    //trả về kiểu string dùng để Lưu dữ liệu vào file
    public String Save_data() {
        return "|ID: " + getID() + " Name: " + getName() + "| Athor Name: " + getAthor_name() + "| Language: " + getLanguage()
                + "| Price: " + getPrice() + "đ" + "| Publish date: " + getPublish_date() + "| ISBN: " + getISBN();
    }

}
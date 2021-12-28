package Services;

import java.util.*;

import Models.Book_info;

import java.io.*;
import java.io.IOException;

import App.*;

public class Book_Management {

    public static Scanner input_number = new Scanner(System.in);
    public static Scanner input_string = new Scanner(System.in);

    //Method Thêm sách
    public void addBook() {

        Book_info info;

        //tên cuốn sách không được nhập quá 15 ký tự
        String name;
        do {
            System.out.print("\nName: ");
            name = input_string.nextLine();
            // nếu nhập quá 15 ký thì thông báo lỗi và cho nhập lại
            if (name.length() > 15) {
                System.out.println("\nError: Book name cannot exceed 15 characters");
            }
        } while (name.length() > 15);

        //ID cuốn sách không được nhập quá 10 ký tự
        String ID;
        do {
            System.out.print("\nID: ");
            ID = input_string.nextLine();
            // nếu nhập quá 10 ký thì thông báo lỗi và cho nhập lại
            if (ID.length() > 10) {
                System.out.println("\nError: Book ID cannot exceed 10 characters");
            }
        } while (ID.length() > 10);

        ////tên tác giả cuốn sách không được nhập quá 15 ký tự
        String Athor_name;
        do {
            System.out.print("\nAthor name: ");
            Athor_name = input_string.nextLine();
            // nếu nhập quá 15 ký thì thông báo lỗi và cho nhập lại
            if (Athor_name.length() > 15) {
                System.out.println("\nError: Athor name cannot exceed 15 characters");
            }
        } while (Athor_name.length() > 15);

        //Ngôn ngữ cuốn sách không được nhập quá 12 ký tự
        String Language;
        do {
            System.out.print("\nLanguage: ");
            Language = input_string.nextLine();
            //nếu nhập quá 12 ký thì thông báo lỗi và cho nhập lại
            if (Language.length() > 12) {
                System.out.println("\nError: Language cannot exceed 12 characters");
            }
        } while (Language.length() > 12);

        //giá sản phẩm
        float Price = 0;
        do {
            try {
                System.out.print("\nPrice: ");
                Price = Float.parseFloat(input_number.nextLine());
                //giá sản phẩm phải lớn hơn 1, nếu nhỏ hơn 1 thì thông báo lỗi và cho nhập lại
                if (Price < 1) {
                    System.out.println("\nError: Price cannot be less than 1");
                }
            } catch (Exception e) {
                //Thông báo lỗi : nếu người dùng nhập không phải là số kiểu float
                System.out.println("\nError: " + e.getMessage());
                System.out.println("Price must be some type float > 0");
            }
        } while (Price < 1);

        //ngày xuất bản cuốn sách không được nhập ít hơn 8 ký tự và nhiều hơn 10 ký tự
        String Publish_date;
        do {
            System.out.print("\nPublication date: ");
            Publish_date = input_string.nextLine();
            //nếu ngày xuất bản ko nằm trong khoảng 8 -> 10 ký tự thì thông báo lỗi và cho nhập lại
            if (Publish_date.length() < 8 || Publish_date.length() > 10) {
                System.out.println("\nError: Incorrect publication date format");
                System.out.println("Format should be: dd/mm/yyyy , dd.mm.yyyy or dd-mm-yyyy");
            } else break;
        } while (true);

        //ISBN không được nhập vượt quá 12 ký tự
        String ISBN;
        do {
            System.out.print("\nISBN: ");
            ISBN = input_string.nextLine();
            // nếu nhập quá 12 ký thì thông báo lỗi và cho nhập lại
            if (ISBN.length() > 12) {
                System.out.println("\nError: ISBN cannot exceed 10 characters");
            }
        } while (ISBN.length() > 10);

        info = new Book_info(Publish_date, ISBN, name, ID, Athor_name, Language, Price);
        Main.books.add(info);
    }


    //Method Xoá sách
    public void Delete_Book() {
        int size = Main.books.size();
        System.out.print("\nEnter the book ID you want to delete: ");
        String ID_delete = input_string.nextLine();
        boolean flag = false;
        for (int i = 0; i < size; i++) {
            if (Main.books.get(i).getID().equalsIgnoreCase(ID_delete) == true) {
                Main.books.remove(i);
                System.out.println("\nDone deleting");
                flag = true;
                break;
            }
        }
        if (flag == false) {
            System.out.println("\nError: The book ID you entered doesn't match any book ");
        }
    }


    //Method Sửa thông tin sách
    public void Update_book(int choice) {
        int size = Main.books.size();
        if (size == 0) {
            System.out.println("\nError: Empty list.......! ");
        } else {
            switch (choice) {
                //cập nhật giá bán
                case 1: {
                    System.out.println("\n         ====== Update Price ======");
                    System.out.print("\nImport the Book ID you want to update: ");
                    String ID_update = input_string.nextLine();
                    boolean flag = false;
                    for (int i = 0; i < size; i++) {
                        if (Main.books.get(i).getID().equalsIgnoreCase(ID_update) == true) {
                            flag = true;
                            float Price_new = 0;
                            do {
                                try {
                                    System.out.print("\nPrice: ");
                                    Price_new = Float.parseFloat(input_number.nextLine());
                                    if (Price_new < 1) {
                                        System.out.println("\nError: Price cannot be less than 1");
                                    }
                                } catch (Exception e) {
                                    //Thông báo lỗi : nếu người dùng nhập không phải là số kiểu float
                                    System.out.println("\nError: " + e.getMessage());
                                    System.out.println("Price must be some type float > 0");
                                }
                            } while (Price_new < 1);

                            Main.books.get(i).setPrice(Price_new);
                            System.out.println("\nUpdate done");
                            //Thoát khỏi for
                            break;
                        }
                    }
                    if (flag == false) {
                        System.out.println("\nError: The book ID you entered doesn't match any book ");
                    }
                    break;
                }


                //cập nhật tên sách
                case 2: {
                    System.out.println("\n            ====== Update Name ======");
                    System.out.print("\nImport the Book ID you want to update: ");
                    String name_ID_update = input_string.nextLine();

                    boolean flag = false;

                    for (int i = 0; i < size; i++) {
                        if (Main.books.get(i).getID().equalsIgnoreCase(name_ID_update) == true) {
                            flag = true;
                            String name;
                            do {
                                System.out.print("\nName: ");
                                name = input_string.nextLine();
                                if (name.length() > 15) {
                                    System.out.println("\nError: Book name cannot exceed 15 characters");
                                }
                            } while (name.length() > 15);
                            Main.books.get(i).setName(name);
                            System.out.println("\nUpdate done ");
                            break;
                        }
                    }

                    if (flag == false) {
                        System.out.println("\nError: The book ID you entered doesn't match any book ");
                    }
                    break;
                }


                //cập nhật Tên tác giả
                case 3: {
                    System.out.println("\n         ====== Update Athor name ======");
                    System.out.print("\nImport the Book ID you want to update: ");
                    String ID_update = input_string.nextLine();
                    boolean flag = false;
                    for (int i = 0; i < size; i++) {
                        if (Main.books.get(i).getID().equalsIgnoreCase(ID_update) == true) {
                            flag = true;
                            String Athor_name;
                            do {
                                System.out.print("\nAthor name: ");
                                Athor_name = input_string.nextLine();
                                if (Athor_name.length() > 15) {
                                    System.out.println("\nError: Athor name cannot exceed 15 characters");
                                }
                            } while (Athor_name.length() > 15);

                            Main.books.get(i).setAthor_name(Athor_name);
                            System.out.println("\nUpdate done ");
                        }
                    }

                    if (flag == false) {
                        System.out.println("\nError: The book ID you entered doesn't match any book ");
                    }
                    break;
                }


                //cập nhật Ngôn ngữ
                case 4: {
                    System.out.println("\n         ====== Update Language ======");
                    System.out.print("\nImport the Book you want to update: ");
                    String ID_update = input_string.nextLine();

                    boolean flag = false;

                    for (int i = 0; i < size; i++) {
                        if (Main.books.get(i).getID().equalsIgnoreCase(ID_update) == true) {
                            flag = true;
                            String Language;
                            do {
                                System.out.print("\nLanguage: ");
                                Language = input_string.nextLine();
                                if (Language.length() > 12) {
                                    System.out.println("\nError: Language cannot exceed 12 characters");
                                }
                            } while (Language.length() > 12);
                            Main.books.get(i).setLanguage(Language);
                            System.out.println("\nUpdate done ");
                        }
                    }

                    if (flag == false) {
                        System.out.println("\nError: The book ID you entered doesn't match any book ");
                    }
                    break;
                }


                //cập nhật tất cả thông tin của một cuốn sách
                case 5: {
                    System.out.println("\n       ====== Update book information ======");
                    //Nhập ID sách hoặc tên sách muốn sửa
                    System.out.print("\nImport the Book ID you want to update: ");
                    String ID_update = input_string.nextLine();
                    boolean flag = false;

                    for (int i = 0; i < size; i++) {

                        if (Main.books.get(i).getID().equalsIgnoreCase(ID_update) == true) {
                            flag = true;

                            String name;
                            do {
                                System.out.print("\nName: ");
                                name = input_string.nextLine();
                                if (name.length() > 15) {
                                    System.out.println("\nError: Book name cannot exceed 15 characters");
                                }
                            } while (name.length() > 15);

                            String ID;
                            do {
                                System.out.print("\nID: ");
                                ID = input_string.nextLine();
                                if (ID.length() > 10) {
                                    System.out.println("\nError: Book ID cannot exceed 10 characters");
                                }
                            } while (ID.length() > 10);

                            String Athor_name;
                            do {
                                System.out.print("\nAthor name: ");
                                Athor_name = input_string.nextLine();
                                if (Athor_name.length() > 15) {
                                    System.out.println("\nError: Athor name cannot exceed 15 characters");
                                }
                            } while (Athor_name.length() > 15);

                            String Language;
                            do {
                                System.out.print("\nLanguage: ");
                                Language = input_string.nextLine();
                                if (Language.length() > 12) {
                                    System.out.println("\nError: Language cannot exceed 12 characters");
                                }
                            } while (Language.length() > 12);

                            float Price = 0;
                            do {
                                try {
                                    System.out.print("\nPrice: ");
                                    Price = Float.parseFloat(input_number.nextLine());
                                    //giá sản phẩm phải lớn hơn 1, nếu nhỏ hơn 1 thì thông báo lỗi và cho nhập lại
                                    if (Price < 1) {
                                        System.out.println("\nError: Price cannot be less than 1");
                                    }
                                } catch (Exception e) {
                                    //Thông báo lỗi : nếu người dùng nhập không phải là số kiểu float
                                    System.out.println("\nError: " + e.getMessage());
                                    System.out.println("Price must be some type float > 0");
                                }
                            } while (Price < 1);

                            String Publish_date;
                            do {
                                System.out.print("\nPublication date: ");
                                Publish_date = input_string.nextLine();
                                if (Publish_date.length() < 8 || Publish_date.length() > 10) {
                                    System.out.println("\nError: Incorrect publication date format");
                                    System.out.println("Format should be: dd/mm/yyyy , dd.mm.yyyy or dd-mm-yyyy");
                                } else break;
                            } while (true);

                            String ISBN;
                            do {
                                System.out.print("\nISBN: ");
                                ISBN = input_string.nextLine();
                                if (ISBN.length() > 12) {
                                    System.out.println("\nError: ISBN cannot exceed 10 characters");
                                }
                            } while (ISBN.length() > 10);

                            Main.books.get(i).setName(name);
                            Main.books.get(i).setID(ID);
                            Main.books.get(i).setAthor_name(Athor_name);
                            Main.books.get(i).setLanguage(Language);
                            Main.books.get(i).setPrice(Price);
                            Main.books.get(i).setPublish_date(Publish_date);
                            Main.books.get(i).setISBN(ISBN);

                            System.out.println("\nUpdate done ");
                        }
                    }

                    if (flag == false) {
                        System.out.println("\nError: The book ID you entered doesn't match any book ");
                    }
                    break;
                }

                default:
                    System.out.println("\nInvalid Choice........");
                    break;
            }
        }
    }


    //Hiển thị danh sách
    public void Display() {
        System.out.println("\n\n                               ====== List of books ======\n");
        System.out.println("+----------+---------------+---------------+------------+-------------+--------------+----------+");
        System.out.println("|    ID    |      Name     |   Athor name  |  Language  |    Price    | Publish date |   ISBN   |");
        System.out.println("+----------+---------------+---------------+------------+-------------+--------------+----------+");
        for (Book_info book : Main.books) {
            System.out.format("|%-10s|%-15s|%-15s|%-12s|%-13s|%-14s|%-10s|\n", book.getID(), book.getName(), book.getAthor_name(), book.getLanguage(), (book.getPrice() + " đ"), book.getPublish_date(), book.getISBN());
            System.out.println("+----------+---------------+---------------+------------+-------------+--------------+----------+");
        }
    }

    //Lưu dữ liệu vào file
    public void Save_data() {

        String fileName = "data.txt";
        File file = new File(fileName);

        try {
            //Không có file thì tạo file mới. còn có thì thôi
            if (!file.exists()) {
                file.createNewFile();
            }

            //ghi đè lên data cũ
            FileWriter save_data = new FileWriter(fileName);
            BufferedWriter br = new BufferedWriter(save_data);
            for (Book_info book : Main.books) {
                br.write(book.Save_data());
                br.newLine();
            }
            br.close();
            save_data.close();

        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}


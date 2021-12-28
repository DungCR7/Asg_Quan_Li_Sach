package Services;

import java.util.*;

import App.Main;
import Models.Book_info;

public class Tools {

    public static Scanner input_string = new Scanner(System.in);
    public static Scanner input_number = new Scanner(System.in);

    private String str;

    //Lọc Theo tác giả
    public void Filter_by_Author() {
        System.out.print("Enter the name of the author you want to filter: ");
        str = input_string.nextLine();
        int count = 0;
        for (Book_info book : Main.books) {
            if (book.getAthor_name().equalsIgnoreCase(str)) {
                count++;
                if (count == 1) {
                    //Hai dòng này chỉ cho hiển thị ra mà hình một lần duy nhất
                    System.out.println("\nThe Books of \"" + str + "\" are: ");
                    System.out.println("+----------+---------------+---------------+------------+-------------+--------------+----------+");
                }

                System.out.format("|%-10s|%-15s|%-15s|%-12s|%-13s|%-14s|%-10s|\n", book.getID(), book.getName(), book.getAthor_name(), book.getLanguage(), (book.getPrice() + " đ"), book.getPublish_date(), book.getISBN());
                System.out.println("+----------+---------------+---------------+------------+-------------+--------------+----------+");
            }
        }
        if (count == 0) {
            System.out.println("\nNo books by author \"" + str + "\" were found");
        }
    }

    //Lọc Theo ngôn ngữ
    public void Filter_by_language() {

        System.out.print("Enter the language you want to filter: ");
        str = input_string.nextLine();
        int count = 0;
        for (Book_info book : Main.books) {
            if (book.getLanguage().equalsIgnoreCase(str)) {
                count++;
                if (count == 1) {
                    //Hai dòng này chỉ cho hiển thị ra mà hình một lần duy nhất
                    System.out.println("\nBooks written in \"" + str + "\" are: ");
                    System.out.println("+----------+---------------+---------------+------------+-------------+--------------+----------+");
                }

                System.out.format("|%-10s|%-15s|%-15s|%-12s|%-13s|%-14s|%-10s|\n", book.getID(), book.getName(), book.getAthor_name(), book.getLanguage(), (book.getPrice() + " đ"), book.getPublish_date(), book.getISBN());
                System.out.println("+----------+---------------+---------------+------------+-------------+--------------+----------+");
            }
        }
        if (count == 0) {
            System.out.println("\nNo Books written in \"" + str + "\"");
        }
    }

    /**
     * lọc giản sẩn theo giá
     * cho người dùng nhập vào giá sản phẩn tối thiểu và tối đa
     * - kiểm tra xem có cuốn sách nào nằm trong khoảng này không
     * + có thì in ra danh sách
     * + Không có thì thông báo ra màn hình
     */
    public void Filter_by_Price() {
        float PriceMin = 0, PriceMax = 0;

        //giá tối thiểu
        do {
            try {
                System.out.print("\nEnter the Minimum price: ");
                PriceMin = Float.parseFloat(input_number.nextLine());
                //giá tối thiểu phải lớn hơn hoặc bằng 0, nếu nhỏ hơn 0 thì thông báo lối
                if (PriceMin < 0) {
                    System.out.println("\nMinimum price must be greater than or equal to 0");
                }
            } catch (Exception e) {
                System.out.println("\nError: " + e.getMessage());
                System.out.println("Maximum Price must be some type float ");
            }
        } while (PriceMin < 0);

        //giá tối đa
        do {
            try {
                System.out.print("\nEnter the Maxmum price: ");
                PriceMax = Float.parseFloat(input_number.nextLine());
                //Gia tối đa phải lớn hơn giá tối thiểu nếu không thì thông báo lối
                if (PriceMax <= PriceMin) {
                    System.out.print("\nThe maximum price must be greater than the minimum price");
                }
            } catch (Exception e) {
                System.out.println("\nError: " + e.getMessage());
                System.out.println("Maximum Price must be some type float ");
            }
        } while (PriceMax <= PriceMin);
        int count = 0;
        for (Book_info book : Main.books) {
            if (book.getPrice() >= PriceMin && book.getPrice() <= PriceMax) {
                count++;
                if (count == 1) {
                    //Hai dòng này chỉ cho hiển thị ra mà hình một lần duy nhất
                    System.out.println("\nBooks with prices between " + PriceMin + "đ and " + PriceMax + "đ are: ");
                    System.out.println("+----------+---------------+---------------+------------+-------------+--------------+----------+");
                }

                System.out.format("|%-10s|%-15s|%-15s|%-12s|%-13s|%-14s|%-10s|\n", book.getID(), book.getName(), book.getAthor_name(), book.getLanguage(), (book.getPrice() + " đ"), book.getPublish_date(), book.getISBN());
                System.out.println("+----------+---------------+---------------+------------+-------------+--------------+----------+");
            }
        }
        if (count == 0) {
            System.out.println("\nThere are no books priced from " + PriceMin + "đ to " + PriceMax + "đ");
        }
    }

    //Săp xếp theo thứ tự giảm dần
    public void Order_by_price_desc() {

        List<Book_info> list = new ArrayList<Book_info>(Main.books);

        //săp xếp theo giá giảm dần
        Collections.sort(list, new Comparator<Book_info>() {
            @Override
            public int compare(Book_info o1, Book_info o2) {
                return (int) (o2.getPrice() - o1.getPrice());
            }
        });

        //Hiển thị danh sách ra màn hình
        System.out.println("+----------+---------------+---------------+------------+-------------+--------------+----------+");
        System.out.println("|    ID    |      Name     |   Athor name  |  Language  |    Price    | Publish date |   ISBN   |");
        System.out.println("+----------+---------------+---------------+------------+-------------+--------------+----------+");
        for (Book_info o : list) {
            System.out.format("|%-10s|%-15s|%-15s|%-12s|%-13s|%-14s|%-10s|\n", o.getID(), o.getName(), o.getAthor_name(), o.getLanguage(), (o.getPrice() + " đ"), o.getPublish_date(), o.getISBN());
            System.out.println("+----------+---------------+---------------+------------+-------------+--------------+----------+");
        }
    }

}

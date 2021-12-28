package App;

import java.util.*;

import Models.Book_info;
import Services.*;

public class Main {

    public static Scanner input_number = new Scanner(System.in);
    public static Scanner input_string = new Scanner(System.in);
    public static ArrayList<Book_info> books = new ArrayList<Book_info>();

    public static void main(String[] args) {

        Book_Management Admin = new Book_Management();
        Tools Tools = new Tools();
        int Choice = 0;
        String Check;

        do {
            System.out.println("\n\n============= Main control panel ===========");
            System.out.println("\n 1. Insert a new book  |  2. Update a book     ");
            System.out.println("\n 3. Delete a book      |  4. Display all       ");
            System.out.println("\n 5. Tools");
            System.out.println("\n 0. Exit the program ");
            System.out.println("============================================");

            do {
                try {
                    System.out.print("\nEnter your choice: ");
                    Choice = Integer.parseInt(input_number.nextLine());
                } catch (Exception e) {
                    //Thông báo lỗi nếu người dùng nhập vào không phải là số nguyên và cho người dùng chọn lại
                    System.out.println("\nError: " + e.getMessage());
                    System.out.println("Choice must be some type integer");
                    Choice = -1;
                }
            } while (Choice == -1);

            //Thoát case: 1 switch 1
            if (Choice == 0) break;

            switch (Choice) {
                case 1: {
                    System.out.println("\n\n      ====== Insert a new book ======");
                    do {
                        Admin.addBook();
                        //Lưu data vào file
                        Admin.Save_data();
                        do {
                            System.out.print("\nDo you want to insert a new book (Y/N): ");
                            Check = input_string.nextLine();
                            if (Check.equalsIgnoreCase("n") == true || Check.equalsIgnoreCase("y") == true) {
                                break;
                            } else {
                                System.out.println("\nInvalid Choice.");
                            }
                        } while (true);
                    } while (Check.equalsIgnoreCase("Y"));
                    break;
                }
                case 2: {
                    do {
                        System.out.println("\n\n================= Update a book ===================");
                        System.out.println("\n 1. Update Price         |    2. Update name     ");
                        System.out.println("\n 3. Update Athor name    |    4. Update Language ");
                        System.out.println("\n 5. Update all information a book    ");
                        System.out.println("\n 0. Come Back ");
                        System.out.println("==================================================");
                        do {
                            try {
                                System.out.print("\nEnter your choice: ");
                                Choice = Integer.parseInt(input_number.nextLine());
                                if (Choice < 0 || Choice > 5) {
                                    System.out.println("\nInvalid Choice.");
                                } else break;
                            } catch (Exception e) {
                                System.out.println("\nError: " + e.getMessage());
                                System.out.println("Choice must be some type integer");
                                Choice = -1;
                            }
                        } while (true);

                        if (Choice == 0) break;

                        Admin.Update_book(Choice);
                        //Sau khi cập nhật xong thì lưu lại vào file
                        Admin.Save_data();
                        do {
                            try {
                                System.out.print("\nEnter 0 to go back: ");
                                Choice = Integer.parseInt(input_number.nextLine());
                                if (Choice != 0) {
                                    System.out.println("\nInvalid Choice.");
                                }
                            } catch (Exception e) {
                                System.out.println("\nError: " + e.getMessage());
                                System.out.println("Choice must be some type integer");

                            }
                        } while (Choice != 0);

                    } while (true);
                    break;
                }

                case 3: {
                    System.out.println("\n\n         ====== Delete a book ======");
                    do {
                        if (books.size() == 0) {
                            System.out.println("\nEmpty list.............!");
                            do {
                                try {
                                    System.out.print("\nEnter 0 to go back: ");
                                    Choice = Integer.parseInt(input_number.nextLine());
                                    if (Choice != 0) {
                                        System.out.println("\nInvalid Choice.");
                                    }
                                } catch (Exception e) {
                                    System.out.println("\nError: " + e.getMessage());
                                    System.out.println("Choice must be some type integer");

                                }
                            } while (Choice != 0);
                            //Thoát khỏi chức năng xoá
                            break;
                        }
                        Admin.Delete_Book();
                        //Xoá xong thì cập nhật lại file
                        Admin.Save_data();
                        do {
                            System.out.print("\nDo you want to insert a new book (Y/N): ");
                            Check = input_string.nextLine();
                            if (Check.equalsIgnoreCase("n") == true || Check.equalsIgnoreCase("y") == true) {
                                break;
                            } else {
                                System.out.println("\nInvalid Choice.");
                            }
                        } while (true);
                    } while (Check.equalsIgnoreCase("Y"));

                    break;
                }

                case 4: {
                    if (books.size() == 0) {
                        System.out.println("\nEmpty list.............!");
                    } else {
                        Admin.Display();
                    }
                    do {
                        try {
                            //sau khi hiển thị danh sách ra màn hình thì yêu cầu người dùng nhập 0 để quay lại
                            System.out.print("\nEnter 0 go back: ");
                            Choice = Integer.parseInt(input_number.nextLine());
                            if (Choice != 0) {
                                System.out.println("\nInvalid Choice.");
                            }
                        } catch (Exception e) {
                            System.out.println("\nError: " + e.getMessage());
                            System.out.println("Choice must be some type integer");
                        }
                    } while (Choice != 0);
                    break;
                }

                case 5: {
                    if (books.size() == 0) {
                        //Thông báo ra màn hình để người dùng biết danh sách rỗng
                        //Để sử dụng tools thì hãy quay lại Main control panel vào thêm một cuốn sách
                        System.out.println("\nEmpty list.............!\nNeed Insert a new book to use the tools");
                        do {
                            try {
                                // rồi yêu câu người dùng nhập 0 để quay lại
                                System.out.print("\nEnter 0 go back: ");
                                Choice = Integer.parseInt(input_number.nextLine());
                                if (Choice != 0) {
                                    System.out.println("\nInvalid Choice.");
                                }
                            } catch (Exception e) {
                                System.out.println("\nError: " + e.getMessage());
                                System.out.println("Choice must be some type integer");
                            }
                        } while (Choice != 0);
                    } else {
                        do {
                            System.out.println("\n\n====================== Tools =========================");
                            System.out.println("\n 1. Filter by author     |    2. Filter by language ");
                            System.out.println("\n 3. Filter by price      |    4. Order by price desc ");
                            System.out.println("\n 0. Come Back ");
                            System.out.println("====================================================");
                            do {
                                try {
                                    System.out.print("\nEnter your choice: ");
                                    Choice = Integer.parseInt(input_number.nextLine());
                                } catch (Exception e) {
                                    System.out.println("\nError: " + e.getMessage());
                                    System.out.println("Choice must be some type integer");
                                    Choice = -1;
                                }
                            } while (Choice == -1);
                            if (Choice == 0) break;
                            switch (Choice) {
                                case 1: {
                                    System.out.println("\n\t====== Filter by author ======\n");
                                    Tools.Filter_by_Author();
                                    do {
                                        try {
                                            // rồi yêu câu người dùng nhập 0 để quay lại
                                            System.out.print("\nEnter 0 go back: ");
                                            Choice = Integer.parseInt(input_number.nextLine());
                                            if (Choice != 0) {
                                                System.out.println("\nInvalid Choice.");
                                            }
                                        } catch (Exception e) {
                                            System.out.println("\nError: " + e.getMessage());
                                            System.out.println("Choice must be some type integer");
                                        }
                                    } while (Choice != 0);
                                    break;
                                }
                                case 2: {
                                    System.out.println("\n\t====== Filter by Language ======\n");
                                    Tools.Filter_by_language();
                                    do {
                                        try {
                                            // rồi yêu câu người dùng nhập 0 để quay lại
                                            System.out.print("\nEnter 0 go back: ");
                                            Choice = Integer.parseInt(input_number.nextLine());
                                            if (Choice != 0) {
                                                System.out.println("\nInvalid Choice.");
                                            }
                                        } catch (Exception e) {
                                            System.out.println("\nError: " + e.getMessage());
                                            System.out.println("Choice must be some type integer");
                                        }
                                    } while (Choice != 0);
                                    break;
                                }
                                case 3: {
                                    System.out.println("\n\t====== Filter by Price ======");
                                    Tools.Filter_by_Price();
                                    do {
                                        try {
                                            // rồi yêu câu người dùng nhập 0 để quay lại
                                            System.out.print("\nEnter 0 go back: ");
                                            Choice = Integer.parseInt(input_number.nextLine());
                                            if (Choice != 0) {
                                                System.out.println("\nInvalid Choice.");
                                            }
                                        } catch (Exception e) {
                                            System.out.println("\nError: " + e.getMessage());
                                            System.out.println("Choice must be some type integer");
                                        }
                                    } while (Choice != 0);
                                    break;
                                }
                                case 4: {
                                    System.out.println("\n\t\t\t\t====== Order by price desc ======\n");
                                    Tools.Order_by_price_desc();
                                    do {
                                        try {
                                            // rồi yêu câu người dùng nhập 0 để quay lại
                                            System.out.print("\nEnter 0 go back: ");
                                            Choice = Integer.parseInt(input_number.nextLine());
                                            if (Choice != 0) {
                                                System.out.println("\nInvalid Choice.");
                                            }
                                        } catch (Exception e) {
                                            System.out.println("\nError: " + e.getMessage());
                                            System.out.println("Choice must be some type integer");
                                        }
                                    } while (Choice != 0);
                                    break;
                                }

                                default: {
                                    //Chọn không đúng chức năng ở bảng điều kiển admin thì thông báo lỗi
                                    System.out.println("\nInvalid Choice.");
                                    do {
                                        try {
                                            //yêu cầu nhập 0 để quay lại , nếu khác 0 thì thông báo lỗi
                                            System.out.print("\nEnter 0 to go back: ");
                                            Choice = Integer.parseInt(input_number.nextLine());
                                            if (Choice != 0) {
                                                System.out.println("\nInvalid Choice.");
                                            }

                                        } catch (Exception e) {
                                            System.out.println("\nError: " + e.getMessage());
                                            System.out.println("Choice must be some type integer");
                                        }
                                        //nếu choice = 0 thì menu Tools, nếu khác 0 thì lặp lại
                                    } while (Choice != 0);
                                    break;
                                }
                            }
                        } while (true);
                    }
                    break;
                }

                default: {
                    //Chọn không đúng chức năng ở bảng điều kiển admin thì thông báo lỗi
                    System.out.println("\nInvalid Choice.");
                    do {
                        try {
                            //yêu cầu nhập 0 để quay lại , nếu khác 0 thì thông báo lỗi
                            System.out.print("\nEnter 0 to go back: ");
                            Choice = Integer.parseInt(input_number.nextLine());
                            if (Choice != 0) {
                                System.out.println("\nInvalid Choice.");
                            }
                        } catch (Exception e) {
                            System.out.println("\nError: " + e.getMessage());
                            System.out.println("Choice must be some type integer");
                        }
                        //nếu choice = 0 thì menu Tools, nếu khác 0 thì lặp lại
                    } while (Choice != 0);
                    break;
                }
            }
        } while (true);

        System.out.println("\n====== Thank you for using my program ======");

    }
}


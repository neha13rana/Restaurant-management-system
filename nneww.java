import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import javax.sql.rowset.serial.SerialStruct;

abstract class login {
    abstract boolean check_password();
}

class waiter extends login {
    Scanner sc = new Scanner(System.in);
    public String item;
    public int price;
    public int qty;

    public boolean check_password() {
        System.out.print("Enter your Password : ");
        int pass = sc.nextInt();
        if (pass == 1234) {
            System.out.println("--------------------------WELCOME TO WAITERS PORTAL-----------------------");
            return true;
        } else
            return false;
    }

    public waiter() {
        item = "";
        price = 0;
        qty = 0;
    }

    public waiter(String item, int price, int qty) {
        this.item = item;
        this.price = price;
        this.qty = qty;
    }

    int menu(waiter[] selected_item) {
        System.out.println();
        int ind = 0;
        int ans = 1;
        while (ans == 1) {
            System.out.println("-----------------------------");
            System.out.println("1.Burgur");
            System.out.println("2.Pizza");
            System.out.println("3.Sandwich");
            System.out.println("-----------------------------");
            System.out.print("Enter your choice : ");
            int ch1 = sc.nextInt();
            switch (ch1) {
                case 1:
                    System.out.println("------------------------------");
                    System.out.println("1.Aloo Tikki Burgur      - 120");
                    System.out.println("2.Maxican Burgur         - 140");
                    System.out.println("3.American Cheese Burgur - 160");
                    System.out.println("------------------------------");
                    System.out.print("Enter your choice : ");
                    int ch2 = sc.nextInt();
                    switch (ch2) {
                        case 1:
                            System.out.print("Enter Quantity : ");
                            int q1 = sc.nextInt();
                            selected_item[ind] = new waiter("Aloo Tikki Burgur", 120, q1);
                            ind++;
                            break;
                        case 2:
                            System.out.print("Enter Quantity : ");
                            int q2 = sc.nextInt();
                            selected_item[ind] = new waiter("Maxican Burgur", 140, q2);
                            ind++;
                            break;
                        case 3:
                            System.out.print("Enter Quantity : ");
                            int q3 = sc.nextInt();
                            selected_item[ind] = new waiter("American Cheese Burgur", 160, q3);
                            ind++;
                            break;
                        default:
                            System.out.println("Enter valid Choice");
                    }

                    System.out.print("Want to add more item (1/0) : ");
                    int x1 = sc.nextInt();
                    ans = x1;
                    break;
                case 2:
                    System.out.println("------------------------------");
                    System.out.println("1.Margarita Pizza      - 320");
                    System.out.println("2.Farm House Pizza     - 340");
                    System.out.println("3.Panner Tikka Pizza   - 360");
                    System.out.println("------------------------------");
                    System.out.print("Enter your choice : ");
                    int ch22 = sc.nextInt();
                    switch (ch22) {
                        case 1:
                            System.out.print("Enter Quantity : ");
                            int q21 = sc.nextInt();
                            selected_item[ind] = new waiter("Margarita Pizza", 320, q21);
                            ind++;
                            break;
                        case 2:
                            System.out.print("Enter Quantity : ");
                            int q22 = sc.nextInt();
                            selected_item[ind] = new waiter("Farm House Pizza", 340, q22);
                            ind++;
                            break;
                        case 3:
                            System.out.print("Enter Quantity : ");
                            int q23 = sc.nextInt();
                            selected_item[ind] = new waiter("Panner Tikka Pizza", 360, q23);
                            ind++;
                            break;
                        default:
                            System.out.println("Enter valid Choice");
                    }
                    System.out.print("Want to add more item (1/0) : ");
                    int x2 = sc.nextInt();
                    ans = x2;
                    break;
                case 3:
                    System.out.println("------------------------------------------");
                    System.out.println("1.Double Cheese Grilled Sandwich        - 100");
                    System.out.println("2.Hot Spicy Panner Stuffed Sandwich     - 180");
                    System.out.println("3.Sp. Mayo Senorita Sandwich            - 200");
                    System.out.println("------------------------------------------");
                    System.out.print("Enter your choice : ");
                    int ch32 = sc.nextInt();
                    switch (ch32) {
                        case 1:
                            System.out.print("Enter Quantity : ");
                            int q31 = sc.nextInt();
                            selected_item[ind] = new waiter("Double Cheese Grilled Sandwich", 100, q31);
                            ind++;
                            break;
                        case 2:
                            System.out.print("Enter Quantity : ");
                            int q32 = sc.nextInt();
                            selected_item[ind] = new waiter("Hot Spicy Panner Stuffed Sandwich", 180, q32);
                            ind++;
                            break;
                        case 3:
                            System.out.print("Enter Quantity : ");
                            int q33 = sc.nextInt();
                            selected_item[ind] = new waiter("Sp. Mayo Senorita Sandwich", 200, q33);
                            ind++;
                            break;
                        default:
                            System.out.println("Enter valid Choice");
                    }
                    System.out.print("Want to add more item (1/0) : ");
                    int x3 = sc.nextInt();
                    ans = x3;
                    break;
                default:
                    System.out.println("Enter valid Choice");
            }
        }
        return ind;
    }

    public int total() {
        return qty * price;
    }

    public void display() {
        System.out.println(item + " |    " + qty + "     |    " + price);
    }
}

class casher extends waiter {

    String cst_name, cst_mailId;
    long cst_ph;
    Scanner x;

    public boolean check_password() {
        System.out.print("Enter your Password : ");
        int pass = sc.nextInt();
        if (pass == 0000) {
            System.out.println("--------------------------WELCOME TO CASHIER PORTAL-----------------------");
            return true;
        } else
            return false;
    }

    void bill(waiter[] selected_item, int ti) {
        System.out.println();
        System.out.println("----------------------------------------------------------");
        System.out.println("----------------------MODERN DHABA------------------------");
        System.out.println("FOOD ITEM        |    QUANTITY     |    PRICE             ");
        int t = 0;
        for (int i = 0; i < ti; i++) {
            t += selected_item[i].total();
            selected_item[i].display();
        }
        System.out.println("----------------------------------------------------------");
        System.out.println("\t\t->Total : " + t);
        System.out.println("----------------------------------------------------------");
        System.out.println("                                           Thank You .....");
        System.out.println("----------------------------------------------------------");
    }

    void write_into_file() {
        try {
            FileWriter myWriter = new FileWriter("D:\\cst_file.txt", true);

            Scanner sc1 = new Scanner(System.in);
            System.out.print("Enter customer's name : ");
            cst_name = sc1.nextLine();
            System.out.print("Enter customer's email id : ");
            cst_mailId = sc1.nextLine();
            System.out.print("Enter customer's phone number : ");
            cst_ph = sc1.nextLong();
            myWriter.write(cst_name + " ");
            myWriter.write(cst_ph + " ");
            myWriter.write(cst_mailId + " ");
            myWriter.write("\n");
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void display_cst_info() {
        try {
            x = new Scanner(new File("D:\\cst_file.txt"));
            System.out.println("------------------------CUSTOMER'S DETAILS--------------");
            System.out.println("|     Name    |    Phone Number    |    Email ID    |");
            while (x.hasNextLine()) {
                String temp;
                String[] info;
                temp = x.nextLine();
                info = temp.split(" ");
                System.out.println("-----------------------------------------------------------------------");
                System.out.println(" | " + info[0] + " | " + info[1] + " | " + info[2] + " | ");
                System.out.println("-----------------------------------------------------------------------");
            }
            x.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

class manager extends casher {
    String staff_name, staff_post;
    long staff_ph;
    double staff_sal;
    Scanner x1;

    public boolean check_password() {
        System.out.print("Enter your Password : ");
        int pass = sc.nextInt();
        if (pass == 6666) {
            System.out.println("--------------------------WELCOME TO MANAGERS PORTAL-----------------------");
            return true;
        } else
            return false;
    }

    void write_into_staff_file() {
        try {
            FileWriter myWriter1 = new FileWriter("D:\\staff_file.txt", true);

            Scanner sc11 = new Scanner(System.in);
            System.out.print("Enter Staff Member's  name : ");
            staff_name = sc11.nextLine();
            System.out.print("Enter Staff Post : ");
            staff_post = sc11.nextLine();
            System.out.print("Enter Staff Member's  Phone Number : ");
            staff_ph = sc11.nextLong();
            System.out.print("Enter Staff Member's Salary : ");
            staff_sal = sc11.nextDouble();
            myWriter1.write(staff_name + " ");
            myWriter1.write(staff_post + " ");
            myWriter1.write(staff_ph + " ");
            myWriter1.write(staff_sal + " ");
            myWriter1.write("\n");
            myWriter1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void display_staff_info() {
        try {
            x1 = new Scanner(new File("D:\\staff_file.txt"));
            System.out.println("------------------------STAFF'S DETAILS--------------");
            System.out.println("|     Name    |    Post   |   Phone Number  |  Salary(Rs) |");
            while (x1.hasNextLine()) {
                String temp;
                String[] info;
                temp = x1.nextLine();
                info = temp.split(" ");
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println(" | " + info[0] + " | " + info[1] + " | " + info[2] + " | " + info[3] + " | ");
                System.out.println("------------------------------------------------------------------------------");
            }
            x1.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

class nneww {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println(
                "------------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\t|| WELCOME TO RESTRAUNT MANAGEMENT SYSTEM ||");
        System.out.println(
                "------------------------------------------------------------------------------------------------------------");
        System.out.println("Login as :");
        System.out.println("1. Manager");
        System.out.println("2. Cashier");
        System.out.println("3. Waiter");
        System.out.println("4. Exit");
        boolean ans = true;
        boolean p = true;
        int ti = 0;
        waiter[] selected_item = new waiter[9];
        manager m1 = new manager();
        waiter w1 = new waiter();
        casher c1 = new casher();
        while (ans) {
            System.out.print("Select User : ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    p = m1.check_password();
                    if (!p) {
                        System.out.println("Wrong Password !!");

                    } else {
                        System.out.println("You have the following access :");
                        System.out.println("1. Add customer's detail");
                        System.out.println("2. View customer's detail");
                        System.out.println("3. Add Staff's detail");
                        System.out.println("4. View Staff's detail");
                        System.out.println("5. Exit");
                        boolean a1 = true;
                        while (a1) {
                            System.out.println("Select option : ");
                            int op11 = sc.nextInt();
                            switch (op11) {
                                case 1:
                                    m1.write_into_file();
                                    break;
                                case 2:
                                    m1.display_cst_info();
                                    break;
                                case 3:
                                    m1.write_into_staff_file();
                                    break;
                                case 4:
                                    m1.display_staff_info();
                                    break;
                                case 5:
                                    a1 = false;
                                    break;
                                default:
                                    System.out.println("Select a valid option !!");
                            }
                        }
                    }
                    break;
                case 2:
                    p = c1.check_password();
                    if (!p) {
                        System.out.println("Wrong Password !!");

                    } else {
                        System.out.println("You have the following access :");
                        System.out.println("1. Take Order");
                        System.out.println("2. Print Bill");
                        System.out.println("3. Add customer's detail");
                        System.out.println("4. View customer's detail");
                        System.out.println("5. Exit");
                        boolean a = true;
                        while (a) {
                            System.out.println("Select option : ");
                            int op1 = sc.nextInt();
                            switch (op1) {
                                case 1:
                                    ti = c1.menu(selected_item);
                                case 2:
                                    c1.bill(selected_item, ti);
                                    break;
                                case 3:
                                    c1.write_into_file();
                                    break;
                                case 4:
                                    c1.display_cst_info();
                                    break;
                                case 5:
                                    a = false;
                                    break;
                                default:
                                    System.out.println("Select a valid option !!");
                            }
                        }
                    }
                    break;
                case 3:
                    p = w1.check_password();
                    if (!p) {
                        System.out.println("Wrong Password !!");

                    } else {
                        System.out.println("You have the following access :");
                        System.out.println("1. Take Order");
                        System.out.println("2. Exit");
                        boolean a2 = true;
                        while (a2) {
                            System.out.println("Select option : ");
                            int op12 = sc.nextInt();
                            switch (op12) {
                                case 1:
                                    ti = w1.menu(selected_item);
                                case 2:
                                    a2 = false;
                                    break;
                                default:
                                    System.out.println("Select a valid option !!");
                            }
                        }
                    }
                    break;
                case 4:
                    ans = false;
                    break;
                default:
                    System.out.println("Select a valid option !!");
            }
        }

    }
}

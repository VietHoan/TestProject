import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choose;
        do {
            mainMenu();
            choose = Integer.parseInt(sc.nextLine());
            switch (choose){
                case 1:
                    adminMenu();
                    break;
                case 2:
                    customerMenu();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Nhập lại");
                    break;
            }
        }while (choose != 3);

    }

    static void mainMenu(){
        System.out.println("1. Quản lý");
        System.out.println("2. Khách hàng");
        System.out.println("3. Thoát chương trình");
    }

    static void adminMenu(){
        System.out.println("\n1. Tìm kiếm khách hàng");
        System.out.println("2. Xem danh sách sản phẩm");
        System.out.println("3. Thêm sản phẩm");
        System.out.println("4. Xóa sản phẩm");
        System.out.println("5. Xem thông tin khách hàng");
        System.out.println("6. Xem giỏ hàng của khách hàng");
        System.out.println("7. Xem toàn bộ khách hàng");
        System.out.println("8. Kết thúc");
        int adminChoose;
        do {
            adminChoose = Integer.parseInt(sc.nextLine());
            switch (adminChoose){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Nhập lại");
                    break;
            }
        }while (adminChoose!=8);
    }

    static void customerMenu(){
        System.out.println("\n1. Xem tất cả sản phẩm");
        System.out.println("2. Nhập sản phẩm bạn muốn thêm vào giỏ hàng");
        System.out.println("3. Nhập sản phẩm bạn muốn xóa khỏi giỏ hàng");
        System.out.println("4. Xem giỏ hàng của bạn và xem hóa đơn");
        System.out.println("5. Thanh toán");
        System.out.println("6. Kết thúc");
        int customerChoose;
        do {
            customerChoose = Integer.parseInt(sc.nextLine());
            switch (customerChoose){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Nhập lại");
                    break;
            }
        }while (customerChoose!=6);
    }
}

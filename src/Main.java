import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static GioHang gh = new GioHang();
    static int customerID;

    public static ArrayList<SanPham> pL = new ArrayList<SanPham>();
    public static ArrayList<Customer> cL = new ArrayList<Customer>();

    public static void main(String[] args) {
        cL.add(new Customer(123,"Hoan","4/1",123));
        cL.add(new Customer(124,"Binh","5/1",124));
        cL.add(new Customer(125,"Kien","6/1",125));

        SanPham ao = new Ao("123","123","123","123","123",123,123,123);
        SanPham ao1 = new Ao("124","123","123","123","123",123,123,123);
        SanPham ao2 = new Ao("125","123","123","123","123",123,123,123);
        SanPham ao3 = new Ao("126","123","123","123","123",123,123,123);
        SanPham ao4 = new Ao("127","123","123","123","123",123,123,123);

        pL.add(ao);
        pL.add(ao1);
        pL.add(ao2);
        pL.add(ao3);
        pL.add(ao4);

        GioHang gioHang = new GioHang();

        cL.get(0).addGioHangToKH(gioHang);

        int choose;
        do {
            mainMenu();
            choose = sc.nextInt();
            switch (choose){
                case 1:
                    adminMenu();
                    break;
                case 2:
                    checkID();
                    for(Customer cs: cL) {
                        if(customerID == cs.getId()) {
                            customerMenu();
                        }
                    }
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

        int adminChoose;
        do {
            System.out.println("\n1. Tìm kiếm khách hàng");
            System.out.println("2. Xem danh sách sản phẩm");
            System.out.println("3. Thêm sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Xem toàn bộ khách hàng");
            System.out.println("6. Xem giỏ hàng của khách hàng");
            System.out.println("7. Kết thúc");
            adminChoose = Integer.parseInt(sc.nextLine());
            switch (adminChoose){
                case 1:
                    cSearch();
                    break;
                case 2:
                    pList();
                    break;
                case 3:
                    addProduct();
                    break;
                case 4:
                    removeProduct();
                    break;
                case 5:
                    TTCustomer();
                    break;
                case 6:
                    TTGioHang();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Nhập lại");
                    break;
            }
        }while (adminChoose!=7);
    }

    static void cSearch() {
        System.out.println("Nhập mã khách hàng:");
        int id = Integer.parseInt(sc.nextLine());
        for (Customer c: cL) {
            if (id == c.getId()) {
                c.display();
                return;
            }
        }
        System.out.println("Mã khách hàng không tồn tại!");
    }

    static void pList() {
        if (pL.isEmpty()) {
            System.out.println("Danh sách trống.");
        } else {
            for (SanPham sp: pL) {
                System.out.println(sp.toString());
            }
        }
    }

    static void addProduct() {
        System.out.println("1. Quần");
        System.out.println("2. Áo");
        int adminChoose = Integer.parseInt(sc.nextLine());

        SanPham sp;
        switch (adminChoose) {
            case 1:
                sp = new Quan();
                sp.input();
                pL.add(sp);
                System.out.println("Thêm sản phẩm thành công");
                break;
            case 2:
                sp = new Ao();
                sp.input();
                pL.add(sp);
                System.out.println("Thêm sản phẩm thành công");
                break;
            default:
                System.out.println("Lựa chọn không tồn tại!");
                break;
        }
    }

    static void removeProduct() {
        System.out.println("Nhập mã sản phẩm:");
        String msp = sc.nextLine();

        for (SanPham sp: pL) {
            if (msp.equals(sp.getMaSP())) {
                pL.remove(sp);
                System.out.println("Xóa sản phẩm thành công");
                return;
            }
        }

        System.out.println("Mã sản phẩm không tồn tại!");
    }
    static void TTCustomer(){
        for(Customer cs : cL){
            cs.display();
        }
    }
    static void TTGioHang(){
        System.out.println("Nhap ID khach hang");
        int id = Integer.parseInt(sc.nextLine());
        for(Customer csm : cL){
            if(id == csm.id){
                for (int i = 0; i < csm.getGioHangArrayList().size(); i++) {
                    csm.getGioHangArrayList().get(i).display();
                }
            }
        }
    }

    static void checkID() {
        System.out.print("Nhap ID khach hang: ");
        customerID = sc.nextInt();
    }

    static void customerMenu(){
        int customerChoose;
        do {
            System.out.println("\n1. Xem tất cả sản phẩm");
            System.out.println("2. Nhập sản phẩm bạn muốn thêm vào giỏ hàng");
            System.out.println("3. Nhập sản phẩm bạn muốn xóa khỏi giỏ hàng");
            System.out.println("4. Xem giỏ hàng của bạn và xem hóa đơn");
            System.out.println("5. Thanh toán");
            System.out.println("6. Kết thúc");
            customerChoose = sc.nextInt();
            switch (customerChoose){
                case 1:
                    showProduct();
                    break;
                case 2:
                    addToCart();
                    break;
                case 3:
                    removeFromCart();
                    break;
                case 4:
                    showCart();
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

    static void showProduct() {
        if (pL.isEmpty()) {
            System.out.println("Danh sách trống.");
        } else {
            for (SanPham sp: pL) {
                System.out.println(sp.toString());
            }
        }
    }

    static void addToCart() {
        System.out.print("Nhap ma san pham: ");
        String addToCart = sc.next();

        for(SanPham sp: pL) {
            if(addToCart.equals(sp.getMaSP())) {
                gh.themVaoGioHang(sp);
            }
        }

        for(Customer cs: cL) {
            for(int i = 0; i < cL.size(); i++) {
                if(customerID == cs.getId()) {
                    cL.get(i).addGioHangToKH(gh);
                }
            }
        }
    }

    static void removeFromCart() {
        System.out.print("Nhap ma san pham: ");
        String removeFromCart = sc.next();

        for(SanPham sp: pL) {
            if(removeFromCart.equals(sp.getMaSP())) {
                gh.xoaKhoiGioHang(sp);
            }
        }

        for(Customer cs: cL) {
            for(int i = 0; i < cL.size(); i++) {
                if(customerID == cs.getId()) {
                    cL.get(i).addGioHangToKH(gh);
                }
            }
        }
    }

    static void showCart() {
        for(Customer cs: cL) {
            if (customerID == cs.getId()) {
                for (int i = 0; i < cs.getGioHangArrayList().size(); i++) {
                    cs.getGioHangArrayList().get(i).display();
                }
            }
        }
    }
}

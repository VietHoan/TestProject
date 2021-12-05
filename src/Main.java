import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int customerID;
    static Customer customer;

    public static ArrayList<SanPham> productList = new ArrayList<SanPham>();
    public static ArrayList<Customer> customerList = new ArrayList<Customer>();

    public static void main(String[] args) {
        customerList.add(new Customer(123,"Hoan","4/1",123));
        customerList.add(new Customer(124,"Binh","5/1",124));
        customerList.add(new Customer(125,"Kien","6/1",125));

        SanPham ao = new Ao("123","Ao","Ao da bo","Tot","33",50000,12,77);
        SanPham ao1 = new Ao("124","Ao","Ao da lon","Binh thuong","36",100000,0,55);
        SanPham ao2 = new Ao("125","Ao","Ao ca sau","Te","30",123,20000,11);
        SanPham quan = new Quan("126","Quan","Quan bo","Tot","40",50000,5,10);
        SanPham quan1 = new Quan("127","Quan","Quan chi","Tot","43",50000,1,15);

        productList.add(ao);
        productList.add(ao1);
        productList.add(ao2);
        productList.add(quan);
        productList.add(quan1);



        int choose;
        do {
            mainMenu();
            choose = Integer.parseInt(sc.nextLine());
            switch (choose){
                case 1:
                    adminMenu();
                    break;
                case 2:
                    System.out.print("Nhap ID khach hang: ");
                    customerID = Integer.parseInt(sc.nextLine());
                    for(Customer cs: customerList) {
                        if(customerID == cs.getId()) {
                            customer = cs;
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
        for (Customer c: customerList) {
            if (id == c.getId()) {
                c.display();
                return;
            }
        }
        System.out.println("Mã khách hàng không tồn tại!");
    }

    static void pList() {
        if (productList.isEmpty()) {
            System.out.println("Danh sách trống.");
        } else {
            for (SanPham sp: productList) {
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
                productList.add(sp);
                System.out.println("Thêm sản phẩm thành công");
                break;
            case 2:
                sp = new Ao();
                sp.input();
                productList.add(sp);
                System.out.println("Thêm sản phẩm thành công");
                break;
            default:
                System.out.println("Lựa chọn không tồn tại!");
                break;
        }
    }

    static
    void removeProduct() {
        System.out.println("Nhập mã sản phẩm:");
        String msp = sc.nextLine();

        for (SanPham sp: productList) {
            if (msp.equals(sp.getMaSP())) {
                productList.remove(sp);
                System.out.println("Xóa sản phẩm thành công");
                return;
            }
        }

        System.out.println("Mã sản phẩm không tồn tại!");
    }
    static void TTCustomer(){
        for(Customer cs : customerList){
            cs.display();
        }
    }
    static void TTGioHang(){
        System.out.println("Nhap ID khach hang");
        int id = Integer.parseInt(sc.nextLine());
        for(Customer csm : customerList){
            if(id == csm.id){
                List<GioHang> cartList = customer.getGioHangArrayList();
                if(cartList.size() > 0) {
                    for (GioHang cart: cartList) {
                        if(cart.getPaymentStatus().equals(PaymentStatus.PAID)) {
                            cart.display();
                        }
                    }
                }else {
                    System.out.print("Khong co gio hang nao nao");
                }
            }
        }
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
            customerChoose = Integer.parseInt(sc.nextLine());
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
                    payment();
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
        if (productList.isEmpty()) {
            System.out.println("Danh sách trống.");
        } else {
            for (SanPham sp: productList) {
                System.out.println(sp.toString());
            }
        }
    }

    static void addToCart() {
        System.out.print("Nhap ma san pham: ");
        String productCode = sc.nextLine();
        System.out.print("Nhap so luong: ");
        int productQuantity = Integer.parseInt(sc.nextLine());
        List<GioHang> cartList = customer.getGioHangArrayList();
        GioHang cartTmp = new GioHang();
        boolean checkExist = false;
        for (GioHang cart: cartList) {
            if(cart.getPaymentStatus().equals(PaymentStatus.PENDING)) {
                cartTmp = cart;
                checkExist = true;
                break;
            }
        }

        for(SanPham sp: productList) {
            if(productCode.equals(sp.getMaSP())) {
                if(productQuantity < sp.getSoLuong()) {
                    if(sp.getLoaiSP().equals("Quan")) {
                        SanPham productCart = new Quan(sp.getMaSP(), sp.getLoaiSP(), sp.getTenSP(), sp.getMoTa(),
                                sp.getSize(), sp.getGia(), productQuantity, sp.getDaiQuan());
                        cartTmp.themVaoGioHang(productCart);
                        cartTmp.getQuantity(sp, productQuantity);
                    }
                    if(sp.getLoaiSP().equals("Ao")) {
                        SanPham productCart = new Quan(sp.getMaSP(), sp.getLoaiSP(), sp.getTenSP(), sp.getMoTa(), sp.getSize(),
                                sp.getGia(), productQuantity, sp.getDaiAo());
                        cartTmp.themVaoGioHang(productCart);
                        cartTmp.getQuantity(sp, productQuantity);
                    }
                }else if(productQuantity == 0){
                    System.out.print("San pham da het hang!");
                }else {
                    System.out.print("San pham khong du hang!");
                }
            }
        }


        if(!checkExist) {
            customer.getGioHangArrayList().add(cartTmp);
        }
    }

    static void removeFromCart() {
        System.out.print("Nhap ma san pham: ");
        String productCode = sc.nextLine();

        List<GioHang> cartList = customer.getGioHangArrayList();
        for (GioHang cart: cartList) {
            if(cart.getPaymentStatus().equals(PaymentStatus.PENDING)) {
                for(SanPham sp: productList) {
                    if(productCode.equals(sp.getMaSP())) {
                        cart.xoaKhoiGioHang(sp);
                    }
                }
            }
        }
    }

    static void showCart() {
        List<GioHang> cartList = customer.getGioHangArrayList();
        if(cartList.size() > 0) {
            for (GioHang cart: cartList) {
                if(cart.getPaymentStatus().equals(PaymentStatus.PENDING)) {
                    cart.display();
                }
            }
        }else {
            System.out.print("Khong co san pham nao");
        }
    }

    static void payment() {
        int paymentAmount = 0;
        List<GioHang> cartList = customer.getGioHangArrayList();
        for (GioHang cart: cartList) {
            if(cart.getPaymentStatus().equals(PaymentStatus.PENDING)) {
                paymentAmount = cart.PaymentAmount();
            }
        }
        System.out.println("Tong hoa don: " + paymentAmount);
        System.out.println("1. Dong y");
        System.out.println("2. Quay lai");
        int paymentChoose = Integer.parseInt(sc.nextLine());
        switch(paymentChoose) {
            case 1:
                if(cartList.size() > 0) {
                    for (GioHang cart: cartList) {
                        if(cart.getPaymentStatus().equals(PaymentStatus.PENDING)) {
                            cart.setPaymentStatus(PaymentStatus.PAID);
                            System.out.print("Cam on quy khach!");
                            for(SanPham sp: productList) {
                                sp.setSoLuong(cart.getRemaining(sp));
                            }
                        }
                    }

                }else {
                    System.out.print("Gio hang trong!");
                }
                break;
            case 2:
                break;
            default:
                System.out.print("Chon lai");
        }
    }
}

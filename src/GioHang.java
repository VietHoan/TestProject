import java.util.ArrayList;
import java.util.Date;

public class GioHang {
    private ArrayList<SanPham> gioHang;
    private String thoiGian;
    private Date date;
    private PaymentStatus paymentStatus;
    private int PaymentQuantity;
    private int remainingProduct;

    public int getPaymentQuantity() {
        return PaymentQuantity;
    }

    public void setPaymentQuantity(int paymentQuantity) {
        PaymentQuantity = paymentQuantity;
    }

    public GioHang() {
        gioHang = new ArrayList<>();
        date = new Date();
        thoiGian = date.toString();
        paymentStatus = PaymentStatus.PENDING;
    }

    public void themVaoGioHang(SanPham sp) {
        this.gioHang.add(sp);
    }

    public void xoaKhoiGioHang(SanPham sp) {
        this.gioHang.remove(sp);
    }

    public void display() {
        System.out.println("\nThoi gian tao: " + thoiGian);
        System.out.println("Trạng thái: " + getPaymentStatus());
        System.out.println("San pham trong gio hang:");
        for (SanPham sp: gioHang) {
            System.out.println(sp.toString());
        }
    }

    public ArrayList<SanPham> getGioHang() {
        return gioHang;
    }

    public void setGioHang(ArrayList<SanPham> gioHang) {
        this.gioHang = gioHang;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int PaymentAmount() {
        int paymentAmount = 0;
        for (SanPham sp: gioHang) {
            paymentAmount += sp.getSoLuong() * sp.getGia();
        }
        return paymentAmount;
    }

    public int getRemaining(SanPham s) {
        for(SanPham sp: gioHang) {
            if(s.getMaSP().equals(sp.getMaSP())) {
                s.setSoLuong(s.getSoLuong() - s.getRemainingProduct());
            }
        }
        return s.getSoLuong();
    }

    public void getQuantity(SanPham s, int a) {
        for(SanPham sp: gioHang) {
            if(s.getMaSP().equals(sp.getMaSP())) {
                s.setRemainingProduct(a);
            }
        }
    }

    public void addProduct(String productCode,int productQuantity){
        for(SanPham sp: Main.productList) { // Duyệt từng sản phẩm trong cửa hàng
            if(productCode.equals(sp.getMaSP())) {// nếu tìm được sản phẩm cần thêm
                if(productQuantity <= sp.getSoLuong()) { // check số lượng sản phẩm cần thêm còn lại của cửa hàng
                    if(sp.getLoaiSP().equals("Quan")) {
                        SanPham productCart = new Quan(sp.getMaSP(), sp.getLoaiSP(), sp.getTenSP(), sp.getMoTa(),
                                sp.getSize(), sp.getGia(), productQuantity, sp.getDaiQuan());
                        themVaoGioHang(productCart);
                        getQuantity(sp, productQuantity);
                        System.out.println("Thêm sản phẩm thành công");
                    }
                    if(sp.getLoaiSP().equals("Ao")) {
                        SanPham productCart = new Quan(sp.getMaSP(), sp.getLoaiSP(), sp.getTenSP(), sp.getMoTa(), sp.getSize(),
                                sp.getGia(), productQuantity, sp.getDaiAo());
                        themVaoGioHang(productCart);
                        getQuantity(sp, productQuantity);
                        System.out.println("Thêm sản phẩm thành công");
                    }
                }else if(productQuantity == 0){
                    System.out.print("San pham da het hang!");
                }else {
                    System.out.print("San pham khong du hang!");
                }
            }
        }
    }
}
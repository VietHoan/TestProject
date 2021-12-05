import java.util.ArrayList;
import java.util.Date;

public class GioHang {
    private ArrayList<SanPham> gioHang;
    private String thoiGian;
    private Date date;
    private PaymentStatus paymentStatus;
    private int PaymentQuantity;

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
        System.out.println("\nThoi gian tao: " + thoiGian + "\n");
        System.out.println("San pham trong gio hang:");
        for (SanPham sp: gioHang) {
            sp.display();
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
}
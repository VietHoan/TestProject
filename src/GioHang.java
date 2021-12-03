import java.util.ArrayList;
import java.util.Date;

public class GioHang {

    private ArrayList<SanPham> gioHang;
    private String thoiGian;
    private Date date;

    public GioHang() {
        gioHang = new ArrayList<>();

        date = new Date();
        thoiGian = date.toString();
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
            System.out.println(sp.toString());
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
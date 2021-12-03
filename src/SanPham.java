import java.util.Scanner;

public class SanPham {
    String MaSP, LoaiSP,TenSP, MoTa,Size;
    int Gia,SoLuong;

    public SanPham() {

    }

    public SanPham( String MaSP, String LoaiSP, String TenSP, String MoTa, String Size, int Gia, int SoLuong) {
        this.MaSP = MaSP;
        this.LoaiSP = LoaiSP;
        this.TenSP = TenSP;
        this.MoTa = MoTa;
        this.Size = Size;
        this.Gia = Gia;
        this.SoLuong = SoLuong;
    }

    public String getMaSP () {
        return MaSP;
    }

    public void setMaSP ( String MaSP) {
        this.MaSP = MaSP;
    }

    public String getLoaiSP () {
        return LoaiSP;
    }

    public void setLoaiSP ( String LoaiSP) {
        this.LoaiSP = LoaiSP;
    }

    public String getTenSP () {
        return TenSP;
    }

    public void setTenSP ( String TenSP) {
        this.TenSP = TenSP;
    }

    public String getMoTa () {
        return MoTa;
    }

    public void setMoTa ( String MoTa) {
        this.MoTa = MoTa;
    }

    public String getSize () {
        return Size;
    }

    public void setSize ( String Size) {
        this.Size = Size;
    }

    public int getGia () {
        return Gia;
    }

    public void setGia ( int Gia) {
        this.Gia = Gia;
    }

    public int getSoLuong () {
        return SoLuong;
    }

    public void setSoLuong ( int SoLuong) {
        this.SoLuong = SoLuong;
    }

    @Override
    public String toString() {
        return "Ma san pham: " + MaSP + ", Ten san pham: " + TenSP + ", Loai san pham: " + LoaiSP + ", Mo ta: " + MoTa + ", Size: " + Size +", Gia: " + Gia + ", So luong: " + SoLuong;
    }

/*    public void display() {
        System.out.println(this);
    }*/

    public void input() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Nhap ma san pham: ");
        MaSP = scan.nextLine();

        System.out.println("Nhap ten san pham: ");
        TenSP = scan.nextLine();

        System.out.println("Nhap loai san pham: ");
        LoaiSP = scan.nextLine();

        System.out.println("Nhap mo ta san pham: ");
        MoTa = scan.nextLine();

        System.out.println("Nhap size san pham: ");
        Size = scan.nextLine();

        System.out.println("Nhap gia san pham: ");
        Gia = scan.nextInt();

        System.out.println("Nhap so luong san pham: ");
        SoLuong = scan.nextInt();
    }

}

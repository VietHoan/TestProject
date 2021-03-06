import java.util.Scanner;

public class Ao extends SanPham {
    int  DaiAo;

    public Ao() {

    }

    public Ao(String MaSP, String LoaiSP, String TenSP, String MoTa, String Size, int Gia, int SoLuong, int DaiAo) {
        super (MaSP, TenSP, MoTa, LoaiSP, Size, Gia, SoLuong);
        this.DaiAo = DaiAo;
    }

    public int getDaiAo () {
        return DaiAo;
    }

    public void setDaiAo ( int DaiAo) {
        this.DaiAo = DaiAo;
    }

    @Override
    public String toString() {
        return super.toString() +", Dai Ao = " + DaiAo;
    }

    @Override
    public void input() {
        super.input();

        Scanner scan = new Scanner(System.in);
        System.out.println("Nhap do dai Ao: ");
        DaiAo = scan.nextInt();
    }
}
import java.util.Scanner;

public class Ao extends SanPham {
    int  DaiAo;

    public Ao() {

    }

    public Ao(String MaSP, String LoaiSP, String TenSP, String MoTa, String Size, int Gia, int SoLuong, int DaiAo) {
        super (MaSP, LoaiSP, TenSP, MoTa, Size, Gia, SoLuong);
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
        return super.toString() +"\t\tDai Ao = " + DaiAo;
    }

    public void input() {
        super.input();

        Scanner scan = new Scanner(System.in);
        System.out.println("Nhap do dai Ao: ");
        DaiAo = scan.nextInt();
    }

    public void display() {
        super.display();
        System.out.print(getDaiAo() + "\n");
    }
}
import java.util.Scanner;

public class Quan extends SanPham {
    int  DaiQuan;

    public Quan() {

    }

    public Quan(String MaSP, String LoaiSP, String TenSP, String MoTa, String Size, int Gia, int SoLuong,int DaiQuan) {
        super (MaSP, TenSP, MoTa, LoaiSP, Size, Gia, SoLuong);
        this.DaiQuan = DaiQuan;
    }

    public int getDaiQuan () {
        return DaiQuan;
    }

    public void setDaiQuan ( int DaiQuan) {
        this.DaiQuan = DaiQuan;
    }

    @Override
    public String toString() {
        return super.toString() +", Dai quan = " + DaiQuan;
    }

    @Override
    public void input() {
        super.input();

        Scanner scan = new Scanner(System.in);
        System.out.println("Nhap do dai quan: ");
        DaiQuan = scan.nextInt();
    }
}
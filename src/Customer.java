import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
    Scanner sc = new Scanner(System.in);
    int id;
    String name;
    String dob;
    int phone;
    private ArrayList<GioHang> gioHangArrayList;


    public Customer(int id, String name, String dob, int phone) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.phone = phone;
        this.gioHangArrayList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void display() {
        System.out.println(getId() + "\t" + getName() + "\t" + getDob() + "\t" + getPhone() + "\t" );
    }

    public void addGioHangToKH(GioHang gioHang){
        this.gioHangArrayList.add(gioHang);
    }

    public ArrayList<GioHang> getGioHangArrayList() {
        return gioHangArrayList;
    }

    public void setGioHangArrayList(ArrayList<GioHang> gioHangArrayList) {
        this.gioHangArrayList = gioHangArrayList;
    }

    public void input() {
        System.out.print("Nhap id: ");
        int idInput = sc.nextInt();
        setId(idInput);

        System.out.print("Nhap ten: ");
        String nameInput = sc.nextLine();
        setName(nameInput);

        System.out.print("Nhap nam sinh: ");
        String dobInput = sc.nextLine();
        setDob(dobInput);

        System.out.print("Nhap dien thoai: ");
        int phoneInput = sc.nextInt();
        setPhone(phoneInput);
    }

}
import java.util.Scanner;

// Menu Stok
class MenuStok {
  int stok;

  public MenuStok(int stok) {
    this.stok = stok;
  }
}
// Menu
class Menu extends MenuStok {
  String nama;
  int harga;

  // Enkapsulasi
  private String owner;

  public Menu() {
    super(0);
    this.nama = "";
    this.harga = 0;
  }
  public Menu(String nama, int harga, int stok) {
    super(stok);
    this.nama = nama;
    this.harga = harga;
  }

  // Enkapsulasi
  public String getOwner() {
    return owner;
  }
  public void setOwner(String nama) {
    this.owner = nama;
  }
}

// Program utama
public class seblak {
  private static Scanner scanner = new Scanner(System.in);

  static String loginUsername = "hilwa";
  static String loginPassword = "kzh";
  static Menu[] menu = new Menu[10]; // Array
  static int[] keranjang = new int[10]; // Array

  public static void tambahKeranjang(int idProduct) {
    for (int i : keranjang) {
      if (keranjang[i] == 0) {
        keranjang[i] = idProduct;
        break;
      }
    }
  }
  public static void pesanMakanan() {
    System.out.println("\nMakanan telah dipesan, Selamat menikmati!");
    System.out.println("Terima kasih telah memesan di Rumah Seblak Ciwa");
    System.out.println("Jangan lupa rating 5 ya kawan-kawan");

    menu[0].setOwner("Hilwa");
    System.out.println("Owner: " + menu[0].getOwner());

  }

  public static void lihatKeranjang() {
    int pilihan = 0;
    int total = 0;

    System.out.println("\nKeranjang anda : ");

    for (int i : keranjang) {
      if (i != 0) {
        String harga = " (Rp " + menu[i].harga  + ")"; // String
        System.out.println("  - " + menu[i].nama + harga);
        total = total + menu[i].harga; // Operator Aritmatika
      }
    }

    // Casting dari int ke double
    double totalDouble = (double) total;

    System.out.println("Total: Rp " + totalDouble);
    System.out.println("\n1. Checkout");
    System.out.println("0. Kembali ke menu utama");
    // Pilihan
    System.out.print("Silahkan pilih menu: ");
    pilihan = scanner.nextInt();

    if (pilihan == 1) {
      pesanMakanan();
      System.out.println("");
    }
    else return;
  }

  /*
  Membuat Menu
  Makanan dan Minuman
  */
  public static void buatMenu() {
    menu[0] = new Menu();
    menu[1] = new Menu("Seblak Original", 10000, 10);
    menu[2] = new Menu("Seblak Ceker Pedas", 15000, 10);
    menu[3] = new Menu("Seblak Seafood", 12000, 10);
    menu[4] = new Menu("Seblak Spesial Komplit", 15000, 10);
    menu[5] = new Menu("Seblak Makaroni Keju", 15000, 10);
    menu[6] = new Menu("Es Teh Manis", 8000, 15);
    menu[7] = new Menu("Es Jeruk Peras", 8000, 15);
    menu[8] = new Menu("Es Cincau Susu", 8000, 15);
    menu[9] = new Menu("Es Soda Gembira", 8000, 15);
  }

  public static void tampilkanMenu() {
    int pilihan;
    System.out.println("\nList products:");

    for (int i = 1; i < menu.length; i++) {
      System.out.println(i + ". " + menu[i].nama + " (" + menu[i].stok + ") Rp " + menu[i].harga);
    }

    System.out.print("Silahkan pilih menu: ");
    pilihan = scanner.nextInt();
    menu[pilihan].stok--;
    tambahKeranjang(pilihan);
    System.out.println("Berhasil memasukan '" + menu[pilihan].nama + "' ke keranjang.\n");
  }

  public static boolean menu() {
    int pilihan;

    System.out.println("Silahkan Pilihan Menu:");
    System.out.println("1. Tampilkan Menu");
    System.out.println("2. Keranjang");
    System.out.println("0. Keluar program");
    System.out.print("Silahkan pilih menu: ");

    pilihan = scanner.nextInt();

    switch (pilihan) {
      case 1:
        tampilkanMenu();
        break;
      case 2:
        lihatKeranjang();
        break;
      default:
        return false;
    }

    return true;
  }
  // Login
  public static boolean login() {
    String username;
    String password;

    // Mengambil input username dan password dari user
    System.out.print("Username: ");
    username = scanner.nextLine();
    System.out.print("Password: ");
    password = scanner.nextLine();

    return username.equals(loginUsername) && password.equals(loginPassword);
  }
  // Main
  public static void main(String[] args) {

    buatMenu();

    System.out.print("Selamat datang di Rumah Seblak Ciwa\n");

    while(true) {
      if (login()) {
        System.out.println("--- login berhasil ---\n");
        break;
      } else System.out.println("Username atau password salah!\n");
    } 
    // Setelah Login Berhasil
    while (true) {
      if (!menu()) break;
    }
    scanner.close();
  }
}

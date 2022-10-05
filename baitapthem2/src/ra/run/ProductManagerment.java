package ra.run;

import ra.dev.Catalog;
import ra.dev.Product;

import java.util.Scanner;

public class ProductManagerment {
    static Product[] arrProduct = new Product[1000];
    static Catalog[] arrCatalog = new Catalog[50];
    static int indexProduct = 0;
    static int indexCatalog = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("****************Quản lý cửa hàng*************");
            System.out.println("1. Quản lý danh mục");
            System.out.println("2. QUản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.println("Sự lưa chọn của bạn");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    ProductManagerment.menuCatalog(sc);
                    break;
                case 2:
                    ProductManagerment.menuProduct(sc);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng chọn từ 1-3");
            }
        } while (true);
    }

    public static void menuCatalog(Scanner sc) {
        boolean exitMenuCatalog = true;
        do {
            System.out.println("***************Quản lý danh mục*************");
            System.out.println("1. Nhập thông tin sản phẩm");
            System.out.println("2. Hiển thị thông tin danh mục theo độ ưu tiên");
            System.out.println("3. Cập nhật thông tin danh mục theo mã danh mục");
            System.out.println("4. Thoát");
            int choiceCatalog = Integer.parseInt(sc.nextLine());
            switch (choiceCatalog) {
                case 1:
                    ProductManagerment.inputListCatalog(sc);
                    break;
                case 2:
                    ProductManagerment.displayListCatalog();
                    break;
                case 3:
                    ProductManagerment.updateCatalog(sc);
                    break;
                case 4:
                    exitMenuCatalog = false;
                    break;
                default:
                    System.out.println("Vui lòng chọn từ 1-4");
            }
        } while (exitMenuCatalog);
    }

    public static void menuProduct(Scanner sc) {
        boolean exitMenuProduct = true;
        do {
            System.out.println("**************Quản lý sản phẩm***********");
            System.out.println("1. Nhập thông tin cho n sản phẩm");
            System.out.println("2. Tính giá bán cho tất cả sản phẩm");
            System.out.println("3. Hiển thị thông tin các sản phẩm");
            System.out.println("4. Sắp xếp sản phẩm theo giá bán tăng dần");
            System.out.println("5. Tìm kiếm sản phẩm theo tên sản phẩm");
            System.out.println("6. Thống kê số lượng và in thông tin các sản phẩm sắp hết hàng\n" + "(quantity<=5)");
            System.out.println("7. Cập nhật trạng thái của sản phẩm theo mã sản phẩm");
            System.out.println("8. Nhập sản phẩm");
            System.out.println("9. Bán sản phẩm");
            System.out.println("10. Thoát");
            int choiceProduct = Integer.parseInt(sc.nextLine());
            switch (choiceProduct) {
                case 1:
                    System.out.println("Nhap vao so san pham can nhap thong tin: ");
                    int n = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < n; i++) {
//            //Cach 1: Khoi tao doi tuong product de nhap thong tin
            Product pro = new Product();
            pro.inputData(sc,arrCatalog,indexCatalog);
            arrProduct[indexCatalog] = pro;
            indexCatalog++;
                        //Cach 2: Khoi tao cac phan tu cua mang la doi tuong Product
//                        System.out.println("NHAP THONG TIN SAN PHAM THU " + (i + 1));
//                        arrProduct[indexProduct] = new Product();
//                        arrProduct[indexProduct].inputData(sc,arrCatalog,indexCatalog);
//                        indexProduct++;
                    }
                    break;
                case 2:
                    for (int i = 0; i < indexProduct; i++) {
                        //Tinh gia ban cho tung san pham thu i
                        arrProduct[i].calExportPrice();
                    }
                    System.out.println("Da tinh xong gia ban cua cac san pham");
                    break;
                case 3:
                    System.out.printf("%-15s%-30s%-30s%-15s%-15s%-10s%-50s%-10s\n", "Product ID", "Product Name",
                            "Title", "Import Price", "Export Price", "Quantity", "Descriptions", "Status");
                    for (int i = 0; i < indexProduct; i++) {
                        arrProduct[i].displayData();
                    }
                    break;
                case 4:
                    for (int i = 0; i < indexProduct-1; i++) {
                        for (int j = i+1; j < indexProduct; j++) {
                            if (arrProduct[i].getExportPrice()>arrProduct[j].getExportPrice()){
                                Product temp = arrProduct[i];
                                arrProduct[i] = arrProduct[j];
                                arrProduct[j] = temp;
                            }
                        }
                    }
                    System.out.println("Da sap xep xong cac san pham theo gia ban tang dan");
                    break;
                case 5:
                    System.out.println("Nhap vao ten san pham can tim: ");
                    String strSearch = sc.nextLine();
                    System.out.printf("%-15s%-30s%-30s%-15s%-15s%-10s%-50s%-10s\n", "Product ID", "Product Name",
                            "Title", "Import Price", "Export Price", "Quantity", "Descriptions", "Status");
                    for (int i = 0; i < indexProduct; i++) {
                        if (arrProduct[i].getProductName().startsWith(strSearch)){
                            arrProduct[i].displayData();
                        }
                    }
                    break;
                case 6:
                    int cnt = 0;
                    System.out.printf("%-15s%-30s%-30s%-15s%-15s%-10s%-50s%-10s\n", "Product ID", "Product Name",
                            "Title", "Import Price", "Export Price", "Quantity", "Descriptions", "Status");
                    for (int i = 0; i < indexProduct; i++) {
                        if(arrProduct[i].getQuantity()<=5){
                            cnt++;
                            arrProduct[i].displayData();
                        }
                    }
                    System.out.printf("Co %d san pham sap het hang\n",cnt);
                    break;
                case 7:
                    String strUpdate = "";
                    System.out.println("Nhap vao ma san pham can cap nhat trang thai: ");
                    strUpdate = sc.nextLine();
                    for (int i = 0; i < indexProduct; i++) {
                        if (arrProduct[i].getProductId().equals(strUpdate)){
                            //Cap nhat trang thai cua san pham arrProduct[i]
                            arrProduct[i].setProductStatus(!arrProduct[i].isProductStatus());
                        }
                    }
                    System.out.println("Da cap nhat thanh cong trang thai cua san pham");
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    exitMenuProduct = false;
                    break;
                default:
                    System.out.println("Vui lòng chọn từ 1-8");
            }

        } while (exitMenuProduct);

    }
    public static void inputListCatalog(Scanner sc) {
        System.out.println("Nhập số danh mục cần nhập thông tin: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            arrCatalog[indexCatalog] = new Catalog();
            arrCatalog[indexCatalog].inputData(sc);
            indexCatalog++;
        }
    }

    public static void displayListCatalog() {
        //hiển thị danh mục theo độ ưu tiên tăng dần
        for (int i = 0; i < indexCatalog - 1; i++) {
            for (int j = 0; j < indexCatalog; j++) {
                if (arrCatalog[i].getPriority()>arrCatalog[j].getPriority()) {
                    Catalog temp = arrCatalog[i];
                    arrCatalog[i] = arrCatalog[j];
                    arrCatalog[j] = temp;
                }
            }
        }
        // hiển thị danh mục
        for (int i = 0; i < indexCatalog; i++) {
            arrCatalog[i].displayData();
        }
    }

    public static void updateCatalog(Scanner sc) {
        System.out.println("Nhập vào mã danh mục cần cập nhập thông tin: ");
        int catalogIdUpdate = Integer.parseInt(sc.nextLine());
        //tìm trong danh sách danh mục cần cập nhập
        int indexCatalogUpdate = -1;
        for (int i = 0; i < indexCatalog; i++) {
            if (arrCatalog[i].getCatalogId()==catalogIdUpdate) {
                indexCatalogUpdate = i;
                break;
            }
        }
        if (indexCatalogUpdate != -1) {
            System.out.println("Nhập vào tên danh mục cần cập nhập: ");
            String catalogName = sc.nextLine();
            if (catalogName != "" && catalogName.length() != 0) {
                arrCatalog[indexCatalogUpdate].setCatalogName(catalogName);
            }
            System.out.println("Nhập vào độ ưu tiên của danh mục");
            String priority = sc.nextLine();
            if (priority != "" && priority.length() != 0) {
                arrCatalog[indexCatalogUpdate].setPriority(Integer.parseInt(priority));
            }
            System.out.println("Nhập vào trạng thái danh mục");
            String status = sc.nextLine();
            if (status != "" && status.length() != 0) {
                arrCatalog[indexCatalogUpdate].setCatalogStatus(Boolean.parseBoolean(status));
            }
        } else {
            System.err.println("Mã danh mục không tồn tại");
        }
    }
}

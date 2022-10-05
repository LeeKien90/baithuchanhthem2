package ra.dev;

import java.util.Scanner;

public class Product {
    private String productId; // Mã sản phẩm
    private String productName; // Tên sản phẩm
    private String title; // Tiêu đề sản phẩm
    private float importPrice; // Giá nhập của sản phẩm
    private float exportPrice; // Giá bán
    private int quantity; // Số lượng còn lại của sản phẩm
    private String descriptions; //Mô tả sản phẩm
    private boolean productStatus; // Trạng thái sản phẩm
    private Catalog catalogs; // Danh mục sản phẩm mà sản phẩm thuộc về

    public Product() {
    }

    public Product(String productID, String productName, String title, float importPrice, float exportPrice, int quantity, String descriptions, boolean productStatus, Catalog catalogs) {
        this.productId = productID;
        this.productName = productName;
        this.title = title;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.productStatus = productStatus;
        this.catalogs = catalogs;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public Catalog getCatalogs() {
        return catalogs;
    }

    public void setCatalogs(Catalog catalogs) {
        this.catalogs = catalogs;
    }
    //các phương thức


    public void inputData(Scanner sc, Catalog[] arrCatalog, int indexMax) {
// cho phép nhập các thông tin sản phẩm (trừ exportPrice)
        System.out.println("Nhao vao ma san pham: ");
        this.productId = sc.nextLine();
        System.out.println("Nhap vao ten san pham: ");
        this.productName = sc.nextLine();
        System.out.println("Nhap vao tieu de san pham: ");
        this.title = sc.nextLine();
        System.out.println("Nhap vao gia ban san pham: ");
        this.importPrice = Float.parseFloat(sc.nextLine());
        System.out.println("Nhap vao so luong san pham: ");
        this.quantity = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap vao mo ta san pham: ");
        this.descriptions = sc.nextLine();
        System.out.println("Nhap vao trang thai san pham: ");
        this.productStatus = Boolean.parseBoolean(sc.nextLine());
        System.out.println("Nhap vao danh muc san pham ma san pham thuoc ve");
        for (int i = 0; i < indexMax; i++) {
            System.out.printf("%d.%s\n",(i+1), arrCatalog[i].getCatalogName());
        }
        System.out.println("Lựa chọn của bạn");
        int indexChoice = Integer.parseInt(sc.nextLine());
        //Set đối tượng danh mục cho sản phẩm
        this.catalogs = arrCatalog[indexChoice - 1];

    }

    public void displayData() {
//cho phép hiển thị tất cả thông tin sản phẩm
        System.out.printf("%-15s%-30s%-30s%-15f%-15f%-10d%-50s%-10b\n", this.productId, this.productName, this.title,
                this.importPrice, this.exportPrice, this.quantity, this.descriptions, this.productStatus);
        String trangThai = "";
        if (this.productStatus) {
            trangThai = "Còn bán";
        } else {
            trangThai = "không bán";
        }
    }

    public void calExportPrice() {
//Cho phép tính giá bán của sản phẩm theo công thức: exportPrice = importPrice*1.2;
        this.exportPrice = this.importPrice * 1.2F;
    }
}

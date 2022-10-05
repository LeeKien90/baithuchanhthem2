package ra.dev;

import java.util.Scanner;

public class Catalog {
    private int catalogId; //mã danh mục sản phẩm
    private String catalogName; //Tên danh mục sản phẩm
    private int priority; //độ ưu tiên
    private boolean catalogStatus; //trạng thái danh mục

    public Catalog() {
    }

    public Catalog(int catalogId, String catalogName, int priority, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.priority = priority;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    //các phương thức
    public void inputData(Scanner sc) {
//Cho phép nhập thông tin danh mục sản phẩm
        System.out.println("Nhap ma danh muc san pham");
        this.catalogId = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap ten danh muc san pham");
        this.catalogName = sc.nextLine();
        System.out.println("Do uu tien");
        this.priority = Integer.parseInt(sc.nextLine());
        System.out.println("Trang thai danh muc");
        this.catalogStatus = Boolean.parseBoolean(sc.nextLine());

    }

    public void displayData() {
//Cho phép hiển thị thông tin danh mục sản
        System.out.printf("Mã danh mục: %d - Tên danh mục sản phẩm: %s - Độ ưu tiên: %d - Trạng thái danh mục %b", this.catalogId, this.catalogName, this.priority, this.catalogStatus);
    }

}

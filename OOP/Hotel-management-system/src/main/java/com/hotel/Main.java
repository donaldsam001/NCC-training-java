package com.hotel;

import com.hotel.entity.KhachSan;
import com.hotel.entity.Nguoi;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final KhachSan khachSan = new KhachSan();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n========== HOTEL MANAGEMENT ==========");
            System.out.println("1. Them khach hang");
            System.out.println("2. Xoa khach hang");
            System.out.println("3. Tinh tien thue phong");
            System.out.println("4. Hien thi danh sach khach hang");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    themKhach();
                    break;

                case 2:
                    System.out.print("Nhap so CMND: ");
                    String cmndXoa = scanner.nextLine();
                    khachSan.removeCustomer(cmndXoa);
                    break;

                case 3:
                    System.out.print("Nhap so CMND: ");
                    String cmndTinhTien = scanner.nextLine();
                    khachSan.calculate(cmndTinhTien);
                    break;

                case 4:
                    khachSan.getList();
                    break;

                case 0:
                    System.out.println("Thoat chuong trinh!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (choice != 0);

        scanner.close();
    }

    private static void themKhach() {
        System.out.print("Nhap ho ten: ");
        String hoTen = scanner.nextLine();

        System.out.print("Nhap tuoi: ");
        int tuoi = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhap so CMND: ");
        String soCMND = scanner.nextLine();

        System.out.print("Nhap so ngay thue: ");
        int soNgayThue = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhap loai phong (A/B/C): ");
        String loaiPhong = scanner.nextLine();

        Nguoi nguoi = new Nguoi(hoTen, tuoi, soCMND);

        khachSan.addCustomer(nguoi, soNgayThue, loaiPhong);
    }
}

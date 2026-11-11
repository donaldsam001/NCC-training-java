package com.companys;
import com.companys.entity.*;

import java.util.*;

public class QLCB {

    private static final Scanner scanner = new Scanner(System.in);

    private static Map<Integer, CanBo> employees = new HashMap<>();
    private static int nextId = 1;

    public static void main(String[] args){
        int choice;

        do {
            System.out.println("\n===== QUAN LY CAN BO =====");
            System.out.println("1. Them moi can bo");
            System.out.println("2. Tim kiem theo ho ten");
            System.out.println("3. Hien thi danh sach can bo");
            System.out.println("4. Thoat chuong trinh");
            System.out.print("Lua chon: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    searchEmployee();
                    break;

                case 3:
                    displayEmployees();
                    break;

                case 4:
                    System.out.println("Thoat chuong trinh!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (choice != 4);

        scanner.close();
    }

    public static void addEmployee(){
        int choice;
        System.out.println("Them can bo: ");
        System.out.println("1. Cong nhan");
        System.out.println("2. Ky su");
        System.out.println("3. Nhan vien");

        System.out.print("Chuc vu: ");
        choice =  Integer.parseInt(scanner.nextLine());

        String fullName;
        int age;
        String gender;
        String address;

        System.out.print("Ho ten: ");
        fullName = scanner.nextLine();

        System.out.print("Tuoi: ");
        age = Integer.parseInt(scanner.nextLine());

        System.out.print("Gioi tinh: ");
        gender = scanner.nextLine();

        System.out.print("Dia chi: ");
        address = scanner.nextLine();

        CanBo employee = null;
        switch (choice){
            case 1:

                System.out.print("Bac: ");
                int level;
                level = Integer.parseInt(scanner.nextLine());
                if (level<1 || level >10){
                    System.out.println("Invalid levels");
                    return;
                }

                employee = new CongNhan(fullName, age, gender, address, level);
                break;
            case 2:
                System.out.print("Nganh dao tao: ");
                String major;
                major = scanner.nextLine().trim();

                employee= new KySu(fullName, age, gender, address, major);
                break;
            case 3:
                System.out.print("Cong viec: ");
                String task;
                task = scanner.nextLine().trim();

                employee = new NhanVien(fullName, age, gender, address, task);
                break;
            default:
                System.out.println("Invalid choice. Retry");
                break;
        }
        employees.put(nextId, employee);
        System.out.println("Them can bo thanh cong!");
        System.out.println("Employee ID: " + nextId);

        nextId++;
    }

    public static void searchEmployee(){
        String fullName;

        System.out.print("Enter full name: ");
        fullName = scanner.nextLine();

        if (employees.isEmpty()){
            System.out.println("Empty");
            return;
        }

        boolean found = false;

        for (CanBo employee: employees.values()){
            if (employee.getFullName().equalsIgnoreCase(fullName)){
                employee.displayInfo();
                found = true;
            }
        }

        if (found == false){
            System.out.println("Employee not found");
            return;
        }
    }

    public static void displayEmployees(){
        if (employees.isEmpty()){
            System.out.println("Empty");
            return;
        }

        for (CanBo employee: employees.values()){
            employee.displayInfo();
        }

    }
}

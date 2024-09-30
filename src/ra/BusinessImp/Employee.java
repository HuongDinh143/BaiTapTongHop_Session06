package ra.BusinessImp;

import ra.Business.IEmployee;

import java.util.Scanner;

public class Employee implements IEmployee {
    private String id;
    private String name;
    private int year;
    private float rate;
    private float commission;
    private float salary;
    private boolean status;
    public Employee() {

    }

    public Employee(String id, String name, int year, float rate, float commission, float salary, boolean status) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.rate = rate;
        this.commission = commission;
        this.salary = salary;
        this.status = status;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getRate() {
        return this.rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getCommission() {
        return this.commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }

    public float getSalary() {
        return this.salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner, Employee[] employee, int currentIndex) {
        this.id = inputId(scanner, employee, currentIndex);
        this.name = inputName(scanner);
        this.year = inputYear(scanner);
        this.rate = inputRate(scanner);
        this.commission = intputCommission(scanner);
        this.status = inputStatus(scanner);

    }
    public String inputId(Scanner scanner, Employee[] employee, int currentIndex) {
        System.out.println("Nhập mã nhân viên");
        do {
            String id = scanner.nextLine();
            for (int i = 0; i < currentIndex; i++) {
                if (employee[i].getId().equals(id)) {
                    System.err.println("Mã nhân viên không được trùng");
                    break;
                }
            }
            return id;
        }while (true);

    }
    public String inputName(Scanner scanner) {
        System.out.println("Nhập tên nhân viên");
        do{
            String name = scanner.nextLine();
            if(name.length()>=6 && name.length()<=50){
                return name;
            }else {
                System.err.println("Tên nhân viên gồm 6 – 50 ký tự");
            }
        }while (true);
    }
    public int inputYear(Scanner scanner) {
        System.out.println("Nhập năm sinh");
        do {
            int year = Integer.parseInt(scanner.nextLine());
            if(year<2002 && year>1900){
                return year;
            }else {
                System.err.println(" Năm sinh nhân viên phải trước năm 2002 ");

            }
        }while (true);
    }
    public float inputRate(Scanner scanner) {
        System.out.println("Nhập vào hệ số lương: ");
        do{
            float rate = Float.parseFloat(scanner.nextLine());
            if(rate>0){
                return rate;
            }else {
                System.err.println("Hệ số lương nhân viên lớn hơn 0");
            }
        }while (true);
    }
    public float intputCommission(Scanner scanner) {
        System.out.println("Nhập vào hoa hồng nhân viên; ");
        return Float.parseFloat(scanner.nextLine());
    }
    public boolean inputStatus(Scanner scanner) {
        System.out.println("Nhập vào trạng thái nhân viên: ");
        return Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public void display() {
        System.out.println("Employee ID: " + this.getId());
        System.out.println("Employee Name: " + this.getName());
        System.out.println("Employee Year: " + this.getYear());
        System.out.println("Employee Rate: " + this.getRate());
        System.out.println("Employee Commission: " + this.getCommission());
        System.out.println("Employee Status: " + (this.isStatus()?"Đang làm việc":"Nghỉ việc"));
        System.out.println("----------");
    }
    public double calSalary(){
        return rate * BASIC_SALARY + commission;
    }
}

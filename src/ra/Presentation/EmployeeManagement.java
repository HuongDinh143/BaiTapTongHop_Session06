package ra.Presentation;

import ra.BusinessImp.Employee;

import java.util.Scanner;

public class EmployeeManagement {
    Employee[] employees = new Employee[100];
    int currentIndex = 0;

    public static void main(String[] args) {
        EmployeeManagement employeeManagement = new EmployeeManagement();
        int choice;
        Scanner scanner = new Scanner(System.in);
        do {


            System.out.println("********MENU**********");
            System.out.println("1. Nhập thông tin cho n nhân viên ");
            System.out.println("2. Hiển thị thông tin nhân viên");
            System.out.println("3. Tính lương cho các nhân viên");
            System.out.println("4. Tìm kiếm nhân viên theo tên nhân viên");
            System.out.println("5. Cập nhật thông tin nhân viên");
            System.out.println("6. Xóa nhân viên theo mã nhân viên");
            System.out.println("7. Sắp xếp nhân viên theo lương tăng dần");
            System.out.println("8. Thoát ");
            System.out.println("Lựa chọn của bạn:");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("1. Nhập thông tin cho n nhân viên ");
                    employeeManagement.inputDataEmployee(scanner);
                    break;
                case 2:
                    System.out.println("2. Hiển thị thông tin nhân viên");
                    employeeManagement.displayEmployees();
                    break;
                case 3:
                    System.out.println("3. Tính lương cho các nhân viên");
                    employeeManagement.calSalalyEmployee();
                    break;
                case 4:
                    System.out.println("4. Tìm kiếm nhân viên theo tên nhân viên");
                    employeeManagement.searchEmployeeByName(scanner);
                    break;
                case 5:
                    System.out.println("5. Cập nhật thông tin nhân viên");
                    employeeManagement.updateEmployee(scanner);
                    break;
                case 6:
                    System.out.println("6. Xóa nhân viên theo mã nhân viên");
                    employeeManagement.deleteEmployeeById(scanner);
                    break;
                case 7:
                    System.out.println("7. Sắp xếp nhân viên theo lương tăng dần");
                    employeeManagement.sortEmployeesBySalary();
                    break;
                case 8:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.err.println("Vui long chon tu 1-8");
            }
        } while (choice != 8);
    }

    public void inputDataEmployee(Scanner scanner) {
        System.out.println("Nhập số nhân viên cần nhập thông tin");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            employees[currentIndex] = new Employee();
            employees[currentIndex].inputData(scanner, employees, currentIndex);
            currentIndex++;
        }
    }

    public void displayEmployees() {
        for (int i = 0; i < currentIndex; i++) {
            employees[i].display();
        }
    }

    public void calSalalyEmployee() {
        for (int i = 0; i < currentIndex; i++) {
            System.out.printf("Lương nhân viên %s là:  %f\n", employees[i].getName(), employees[i].calSalary());
        }
    }

    public void searchEmployeeByName(Scanner scanner) {
        System.out.println("Nhập tên nhân viên cần tìm");
        String searchValue = scanner.nextLine();
        for (int i = 0; i < currentIndex; i++) {
            if (employees[i].getName().toUpperCase().contains(searchValue.toUpperCase())) {
                employees[i].display();
            }
        }
    }

    public void updateEmployee(Scanner scanner) {
        System.out.println("Nhập mã nhân viên cần cập nhật");
        String updateId = scanner.nextLine();
        int indexUpdate = getIndexById(updateId);
        if (indexUpdate == -1) {
            System.err.println("Mã nhân viên không tồn tại");
        } else {
            int choice;
            for (int i = 0; i < currentIndex; i++) {
                do {
                    System.out.println("Chọn thông tin cần cập nhật");
                    System.out.println("1. Tên");
                    System.out.println("2. Năm sinh");
                    System.out.println("3. Hệ số lương");
                    System.out.println("4. Hoa hồng hàng tháng");
                    System.out.println("5. Trạng thái nhân viên");
                    System.out.println("6. Thoát");
                    System.out.println("Lựa chọn của bạn: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            System.out.println("Nhập vào tên mới: ");
                            employees[indexUpdate].setName(scanner.nextLine());
                            break;
                        case 2:
                            System.out.println("Nhập vào năm sinh mới: ");
                            employees[indexUpdate].setYear(Integer.parseInt(scanner.nextLine()));
                            break;
                        case 3:
                            System.out.println("Nhập vào hệ số lương mới: ");
                            employees[indexUpdate].setRate(Float.parseFloat(scanner.nextLine()));
                            break;
                        case 4:
                            System.out.println("Nhập vào hoa hồng hàng tháng mới: ");
                            employees[indexUpdate].setCommission(Float.parseFloat(scanner.nextLine()));
                            break;
                        case 5:
                            System.out.println("Nhập vào trạng thái nhân viên mới: ");
                            employees[indexUpdate].setStatus(Boolean.parseBoolean(scanner.nextLine()));
                            break;
                        case 6:
                            System.out.println("Thoát chương trình!");
                            break;
                        default:
                            System.err.println("Vui lòng nhập từ 1 - 6");
                    }
                } while (choice != 6);

            }

        }
    }

    public int getIndexById(String id) {
        for (int i = 0; i < currentIndex; i++) {
            if (employees[i].getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public void deleteEmployeeById(Scanner scanner) {
        System.out.println("Nhập vào mã nhân viên cần xóa");
        String deleteId = scanner.nextLine();
        int indexDelete = getIndexById(deleteId);
        if (indexDelete == -1) {
            System.err.println("Mã nhân viên không tồn tại");
        } else {
            for (int i = indexDelete; i < currentIndex; i++) {
                employees[i] = employees[i + 1];
            }
            employees[currentIndex - 1] = null;
            currentIndex--;
        }
    }

    public void sortEmployeesBySalary() {
        for (int i = 0; i < currentIndex - 1; i++) {
            for (int j = i + 1; j < currentIndex; j++) {
                if (employees[i].calSalary() > employees[j].calSalary()) {
                    Employee temp = employees[i];
                    employees[i] = employees[j];
                    employees[j] = temp;
                }
            }
        }
    }

}

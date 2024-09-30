package ra.Business;

import ra.BusinessImp.Employee;

import java.util.Scanner;

public interface IEmployee {
    public  final double BASIC_SALARY = 1300000;
    public void inputData(Scanner scanner, Employee[] employee, int currentIndex);
    public void display();
}

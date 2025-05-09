package com.debuggeando_ideas.lambdas;

import com.debuggeando_ideas.fundamentals.Employee;
import com.debuggeando_ideas.fundamentals.Product;

public class AppGenericLambda {
    public static void main(String[] args) {
        Printer<String> printString = string -> System.out.println(string);
        printString.print("Hello World");

        Printer<Product> printProduct = product -> System.out.println(product);

        Product product = new Product();

        product.setId(1L);
        product.setName("Coky");
        product.setPrice(100.0);

        printProduct.print(product);

        Printer<Employee> printEmployee = employee -> System.out.println(employee);
        Employee employee = new Employee();

        employee.setDni("als");
        employee.setName("Cokencio cokens");
        employee.setSalary(1000.0);
        printEmployee.print(employee);
    }
}

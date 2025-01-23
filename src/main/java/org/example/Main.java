package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = new LinkedList<>();
        Employee employee1 = new Employee(1, "Hakan", "Sahin");
        Employee employee2 = new Employee(2, "Merve", "Guner");
        Employee employee3 = new Employee(3, "Umut", "Bulut");
        Employee employee4 = new Employee(4, "Mahmut", "Hertan");
        Employee employee5 = new Employee(5, "Yahsi", "Polat");
        Employee employee6 = new Employee(3, "Umut", "Bulut");
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);
        employeeList.add(employee5);
        employeeList.add(employee6);
        // System.out.println(employeeList);

        findDuplicates(employeeList);
    }

    public static List<Employee> findDuplicates(List<Employee> list) {
        List<Employee> duplicates = new ArrayList<>();

        Set<Employee> seen = new HashSet<>();

        for (Employee item : list) {
            if (seen.contains(item) && !duplicates.contains(item)) {
                duplicates.add(item);
            }
            seen.add(item);
        }

        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> inpList){
        Map<Integer, Employee> uniqueList = new HashMap<>();

        for (Employee employee : inpList) {
            if (employee != null && !uniqueList.containsKey(employee.getId())) {
                uniqueList.put(employee.getId(), employee);
            }
        }

        return uniqueList;
    }

    public static List<Employee> removeDuplicates(List<Employee> inpList) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Employee> uniqueList = new ArrayList<>();

        for (Employee employee : inpList) {
            if (employee != null) {
                if (countMap.containsKey(employee.getId())) {
                    countMap.put(employee.getId(), countMap.get(employee.getId()) + 1);
                } else {
                    countMap.put(employee.getId(), 1);
                }
            }
        }

        for (Employee employee : inpList) {
            if (employee != null && countMap.get(employee.getId()) == 1) {
                uniqueList.add(employee);
            }
        }

        return uniqueList;
    }
}
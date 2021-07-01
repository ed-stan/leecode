package cn;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;

@SuppressWarnings("all")
public class Test {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.add(new Employee("tom",16));
        set.add(new Employee("ely",15));
        set.add(new Employee("tom",16));
        System.out.println(set);
    }


    static class Employee{
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Employee() {}

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return age == employee.age && name.equals(employee.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}

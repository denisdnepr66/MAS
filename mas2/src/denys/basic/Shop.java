package denys.basic;

import denys.ValidationException;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Shop {
    private String name;
    private String address;
    private Set<Car> cars = new HashSet<>();
    private Set<Employee> employees = new HashSet<>();

    public Shop(String name, String address, Employee employee) {
        setName(name);
        setAddress(address);
        employees.add(employee);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty()){
            throw new ValidationException("empty string");
        }
        if (name.equals(this.getName())){
            throw new ValidationException("You are trying to set the same name");
        }
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address.isEmpty()){
            throw new ValidationException("empty string");
        }
        if (address.equals(this.getAddress())){
            throw new ValidationException("You are trying to set the same address");
        }
        this.address = address;
    }

    public Set<Car> getCars() {
        return Collections.unmodifiableSet(cars);
    }

    public void addCar(Car car){
        if (car == null) {
            throw new ValidationException("input cannot be null");
        }
        if (cars.contains(car)){
            return;
        }
        cars.add(car);
        car.addShop(this);
    }

    public void removeCar(Car car){
        if (car == null) {
            throw new ValidationException("input cannot be null");
        }
        if (!cars.contains(car)){
            return;
        }
        cars.remove(car);
        car.removeShop(this);
    }

    public void addEmployee(Employee employee){
        if (employee == null) {
            throw new ValidationException("input cannot be null");
        }
        if (employees.contains(employee)){
            return;
        }
        this.employees.add(employee);
        if (employee.getShop() == null){
            employee.setShop(this);
        }
    }

    public void removeEmployee(Employee employee){
        if (employee == null) {
            throw new ValidationException("input cannot be null");
        }
        if (!employees.contains(employee)){
            throw new ValidationException("there is no such employee");
        }
        if (employees.size() < 2){
            throw new ValidationException("cannot remove last employee");
        }

        employees.remove(employee);
        employee.quit();
    }

    public Set<Employee> getEmployees() {
        return Collections.unmodifiableSet(employees);
    }
}

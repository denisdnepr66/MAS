package denys.basic;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("safd", 34, new Part("asdf","asf"), new Shop("asfd","asf", new Employee("sdf","safd", LocalDate.now())));
        Part part = new Part("sf", "asdfff");
        car.addPart(part);
        car.removePart(part);
        Shop shop = new Shop("asssd", "ssasf", new Employee("sssdf", "sssafd", LocalDate.now()));
        car.addShop(shop);
        car.removeShop(shop);
    }
}

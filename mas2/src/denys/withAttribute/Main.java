package denys.withAttribute;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        var car1 = new Car("asdf", 123);
        var car2 = new Car("aasfsdf", 12343);

        Shop shop1 = new Shop("asfsad","safasdf");
        Shop shop2 = new Shop("asfsad","safasdf");

        shop1.addCarSold(new CarSold(car1,shop1, LocalDate.now(),new Person("asfdd","asdfd", LocalDate.now())));

        System.out.println(car1.getSoldCars().size());
    }
}

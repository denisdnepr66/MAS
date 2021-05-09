package denys.withAttribute;

import denys.ValidationException;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CarSold {

    private Car car;
    private Shop shop;
    private Person person;
    private LocalDate dateOfTransaction;

    private static Set<CarSold> soldCars = new HashSet<>();

    public CarSold(Car car, Shop shop, LocalDate dateOfTransaction, Person person) {
        setCar(car);
        setShop(shop);
        setDateOfTransaction(dateOfTransaction);
        setPerson(person);
        soldCars.add(this);
    }

    public static Set<CarSold> getSoldCars() {
        return Collections.unmodifiableSet(soldCars);
    }

    public Car getCar() {
        return car;
    }

    private void setCar(Car car) {
        if (car == null) {
            throw new ValidationException("car cannot be null");
        }
        this.car = car;
        car.addSoldCar(this);
    }

    public Shop getShop() {
        return shop;
    }

    private void setShop(Shop shop) {
        if (shop == null) {
            throw new ValidationException("shop cannot be null");
        }
        this.shop = shop;
        this.shop.addCarSold(this);
    }

    public LocalDate getDateOfTransaction() {
        return dateOfTransaction;
    }

    public void setDateOfTransaction(LocalDate dateOfTransaction) {
        if (dateOfTransaction == null){
            throw new ValidationException("input cannot be null");
        }
        this.dateOfTransaction = dateOfTransaction;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        if (person == null) {
            throw new ValidationException("null input");
        }
        this.person = person;
    }

    public void remove() {
        if (this.car != null) {
            Car temp = this.car;
            this.car = null;
            temp.removeSoldCar(this);
        }
        if (this.shop != null) {
            Shop temp = this.shop;
            this.shop = null;
            temp.removeSoldCar(this);
        }
    }
}

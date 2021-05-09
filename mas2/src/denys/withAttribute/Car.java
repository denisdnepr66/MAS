package denys.withAttribute;

import denys.ValidationException;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Car {
    private String name;
    private double price;

    private Set<CarSold> soldCars = new HashSet<>();

    public Car(String name, double price) {
        setName(name);
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            throw new ValidationException("empty string");
        }
        if (name.equals(this.getName())) {
            throw new ValidationException("You are trying to set the same name");
        }
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new ValidationException("Price cannot be less or equal 0");
        }
        this.price = price;
    }

    public Set<CarSold> getSoldCars() {
        return Collections.unmodifiableSet(soldCars);
    }

    public void addSoldCar(CarSold soldCar) {
        if (soldCar == null) {
            throw new ValidationException("sold car cannot be null");
        }
        if (soldCar.getCar() == null) {
            throw new ValidationException("invalid sold car");
        }
        this.soldCars.add(soldCar);
    }

    public void removeSoldCar(CarSold carSold) {
        if (this.soldCars.contains(carSold)) {
            this.soldCars.remove(carSold);
            carSold.remove();
        }
    }
}

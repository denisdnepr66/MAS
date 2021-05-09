package denys.withAttribute;

import denys.ValidationException;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Shop {
    private String name;
    private String address;

    private Set<CarSold> soldCars = new HashSet<>();

    public Shop(String name, String address) {
        setName(name);
        setAddress(address);
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address.isEmpty()) {
            throw new ValidationException("empty string");
        }
        if (address.equals(this.getAddress())) {
            throw new ValidationException("You are trying to set the same name");
        }
        this.address = address;
    }

    public Set<CarSold> getSoldCars() {
        return Collections.unmodifiableSet(soldCars);
    }

    public void addCarSold(CarSold soldCar) {
        if (soldCar == null) {
            throw new ValidationException("sold car cannot be null");
        }
        if (soldCar.getShop() == null) {
            throw new ValidationException("invalid sold car");
        }
        this.soldCars.add(soldCar);
    }

    public void removeSoldCar(CarSold soldCar) {
        if (this.soldCars.contains(soldCar)) {
            this.soldCars.remove(soldCar);
            soldCar.remove();
        }
    }

}

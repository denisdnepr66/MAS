package denys.qualified;

import denys.ValidationException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Parking {
    private String address;
    private Map<Integer, Car> cars = new HashMap<>();


    public Parking(String address) {
        setAddress(address);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address.isEmpty()) {
            throw new ValidationException("empty string");
        }
        if (address.equals(this.getAddress())) {
            throw new ValidationException("You are trying to set the same address");
        }
        this.address = address;
    }

    public Map<Integer, Car> getCars() {
        return Collections.unmodifiableMap(cars);
    }

    public void addCar(Car car) {
        if (car == null) {
            throw new ValidationException("null input");
        }
        if (this.cars.containsKey(car.getId())) {
            return;
        }
        this.cars.put(car.getId(), car);
        car.setParking(this);
    }

    public void removeCar(Car car) {
        if (this.cars.containsKey(car.getId())) {
            this.cars.remove(car.getId(), car);
            if (car.getParking() == this) {
                car.setParking(null);
            }
        }
    }

}

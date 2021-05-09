package denys.basic;

import denys.ValidationException;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Part {
    private String name;
    private String description;

    private Set<Car> cars = new HashSet<>();

    public Part(String name, String description) {
        setName(name);
        setDescription(description);
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
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description.isEmpty()){
            throw new ValidationException("input cannot be null");
        }
        this.description = description;
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
        car.addPart(this);
    }

    public void removeCar(Car car){
        if (car == null) {
            throw new ValidationException("input cannot be null");
        }
        if (!cars.contains(car)){
            return;
        }
        cars.remove(car);
        car.removePart(this);
    }

}

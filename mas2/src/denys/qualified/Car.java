package denys.qualified;

import denys.ValidationException;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Car {
    private Integer id;
    private String name;
    private String manufacturer;
    private Set<String> owners = new HashSet<>();

    private Parking parking;

    public Car(Integer id, String name, String manufacturer, String owner) {
        setId(id);
        setName(name);
        setManufacturer(manufacturer);
        addOwner(owner);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        if (id < 0 || id > 100000)
            throw new ValidationException("wrong id");
        this.id = id;
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        if (manufacturer.isEmpty()) {
            throw new ValidationException("empty input");
        }
        this.manufacturer = manufacturer;
    }

    public Set<String> getOwners() {
        return Collections.unmodifiableSet(owners);
    }

    public void addOwner(String owner){
        if (owner.isEmpty()){
            throw new ValidationException("input cannot be empty");
        }
        if (owners.contains(owner)){
            throw new ValidationException("cannot add the same owner");
        }
        owners.add(owner);
    }

    public void removeOwner(String owner){
        if (owner.isEmpty()){
            throw new ValidationException("input cannot be empty");
        }
        if (!owners.contains(owner)){
            throw new ValidationException("there is no such owner");
        }
        owners.remove(owner);
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {

        if (parking == null && this.parking != null) {
            Parking temp = this.parking;
            this.parking = null;
            temp.removeCar(this);

        } else if (parking != null && this.parking == null) {
            this.parking = parking;
            parking.addCar(this);

        } else if (parking != null && parking.getCars().containsKey(this.getId())) {
            Parking temp = this.parking;
            this.parking = parking;
            temp.removeCar(this);

        } else {
            throw new ValidationException("cannot set parking");
        }
    }

}

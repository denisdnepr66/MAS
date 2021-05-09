package denys.basic;

import denys.ValidationException;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Car {
    private String name;
    private int price;
    private Set<Part> parts = new HashSet<>();
    private Set<Shop>  shops = new HashSet<>();

    public Car(String name, int price, Part part, Shop shop) {
        setName(name);
        setPrice(price);
        addPart(part);
        addShop(shop);
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price <= 0){
            throw new ValidationException("wrong price");
        }
        this.price = price;
    }

    public Set<Part> getParts() {
        return Collections.unmodifiableSet(parts);
    }

    public void addPart(Part part) {
        if (part == null) {
            throw new ValidationException("input cannot be null");
        }
        if (parts.contains(part)){
            return;
        }
        parts.add(part);
        part.addCar(this);
    }

    public void removePart(Part part){
        if (part == null) {
            throw new ValidationException("input cannot be null");
        }
        if (!parts.contains(part)){
            return;
        }
        parts.remove(part);
        part.removeCar(this);
    }

    public Set<Shop> getShops() {
        return Collections.unmodifiableSet(shops);
    }

    public void addShop(Shop shop){
        if (shop  == null){
            throw new ValidationException("input cannot be null");
        }
        if (shops.contains(shop)){
            return;
        }
        shops.add(shop);
        shop.addCar(this);
    }

    public void removeShop(Shop shop){
        if (shop == null) {
            throw new ValidationException("input cannot be null");
        }
        if (!shops.contains(shop)){
            return;
        }
        shops.remove(shop);
        shop.removeCar(this);
    }
}

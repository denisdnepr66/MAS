package denys.basic;


import denys.ValidationException;

import java.time.LocalDate;

public class Employee {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Shop shop;

    public Employee(String firstName, String lastName, LocalDate birthDate) {
        setFirstName(firstName);
        setLastName(lastName);
        setBirthDate(birthDate);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.isEmpty()){
            throw new ValidationException("empty string");
        }
        if (firstName.equals(this.getFirstName())){
            throw new ValidationException("You are trying to set the same name");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.isEmpty()){
            throw new ValidationException("empty string");
        }
        if (lastName.equals(this.getLastName())){
            throw new ValidationException("You are trying to set the same name");
        }
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        if (birthDate == null){
            throw new ValidationException("null input");
        }
        this.birthDate = birthDate;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        if (shop == null) {
            throw new ValidationException("input canno be null");
        }
        if (this.getShop() != null){
            throw new ValidationException("Employee can have only one job");
        }
        this.shop = shop;
        shop.addEmployee(this);
    }

    public void quit(){
        this.shop = null;
    }
}

package denys.withAttribute;

import denys.ValidationException;

import java.time.LocalDate;

public class Person {
    private String name;
    private String info;
    private LocalDate dateOfBirth;

    public Person(String name, String info, LocalDate dateOfBirth) {
        setName(name);
        setInfo(info);
        setDateOfBirth(dateOfBirth);
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        if (info.isEmpty()) {
            throw new ValidationException("empty string");
        }
        if (info.equals(this.getInfo())) {
            throw new ValidationException("You are trying to set the same info");
        }
        this.info = info;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}

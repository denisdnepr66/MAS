package denys.compositiion;

import denys.ValidationException;
import denys.withAttribute.Person;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Account {
    private Person owner;

    private Set<Photo> photos = new HashSet<>();

    public Account(Person owner) {
        setOwner(owner);
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        if (owner == null) {
            throw new ValidationException("Input cannot be null");
        }
        this.owner = owner;
    }

    public Set<Photo> getPhotos() {
        return Collections.unmodifiableSet(photos);
    }

    public void addPhoto(Photo photo){
        if (photo == null) {
            throw new ValidationException("input cannot be null");
        }
        else if (photos.contains(photo)){
            return;
        }
        else if (photo.getAccount() != this){
            throw new ValidationException("photo already assigned");
        }
        photos.add(photo);
    }

    public void removePhoto(Photo photo) {
        if (photo == null)
            return;
        if (photo.getAccount() != this)
            throw new ValidationException("wrong photo");
        if (photos.contains(photo)){
            throw new ValidationException("there is np such photo");
        }
        photos.remove(photo);
    }

    public void delete() {
        this.photos.clear();
    }

    public static void main(String[] args) {
        Account account = new Account(new Person("anna", "asdf", LocalDate.now()));

        Photo photo = new Photo(789, LocalDate.now(),"asdfgh", account);
        Photo photo1 = new Photo(789, LocalDate.now(),"aassdfgh", account);

        account.addPhoto(photo);

        System.out.println(account.getPhotos().size());
    }
}

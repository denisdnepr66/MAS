package denys.compositiion;

import denys.ValidationException;

import java.time.LocalDate;

public class Photo {
    private String photoName;
    private int size;
    private LocalDate publishingDate;
    private Account account;

    public Photo(int size, LocalDate publishingDate, String photoName, Account account) {
        setAccount(account);
        setPhotoName(photoName);
        setSize(size);
        setPublishingDate(publishingDate);
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        if (photoName == null) {
            throw new ValidationException("input cannot be null");
        }
        this.photoName = photoName;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if (size <= 0) {
            throw new ValidationException("size cannot be less or equal 0");
        }
        this.size = size;
    }

    public LocalDate getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(LocalDate publishingDate) {
        if (publishingDate == null) {
            throw new ValidationException("input cannot be null");
        }
        this.publishingDate = publishingDate;
    }

    private void setAccount(Account account) {
        if (account == null) {
            throw new ValidationException("input cannot be null");
        }
        this.account = account;
        account.addPhoto(this);
    }

    public Account getAccount() {
        return account;
    }

    public void delete() {
        this.account.removePhoto(this);
        this.account = null;
    }
}

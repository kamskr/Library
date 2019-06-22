package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LibraryUser extends User {
    private List<Publication> publicationHistory = new ArrayList<>();
    private List<Publication> borrowedPublications = new ArrayList<>();

    public List<Publication> getPublicationHistory() {
        return publicationHistory;
    }

    public List<Publication> getBorrowedPublications() {
        return borrowedPublications;
    }

    public LibraryUser(String firstName, String lastName, String pesel){
        super(firstName,lastName,pesel);
    }

    private void addPublicationToHistory(Publication publication){
        publicationHistory.add(publication);
    }

    private void borrowPublication(Publication publication){
        borrowedPublications.add(publication);
    }

    public boolean returnPublication(Publication publication){
        boolean result = false;
        if(borrowedPublications.remove(publication)) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LibraryUser that = (LibraryUser) o;
        return Objects.equals(getPublicationHistory(), that.getPublicationHistory()) &&
                Objects.equals(getBorrowedPublications(), that.getBorrowedPublications());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPublicationHistory(), getBorrowedPublications());
    }

    @Override
    public String toCsv() {
        return getFirstName() + ";" + getLastName() + ";" + getPesel();
    }
}

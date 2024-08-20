package student;

public class Student extends User{
    private String firstName;
    private String lastName;

    public Student(String id, String userName, String phone, String email, String address,
                   String firstName, String lastName
    ) {
        super(id, userName, phone, email, address);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + '(' + this.getEmail() + ')';
    }
}

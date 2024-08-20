import dao.CRUDStudent;
import dao.CRUDStudentImpl;
import dao.DatabaseConnection;
import student.Student;

import java.util.Optional;

public class Test {
    public static void main(String[] args) {
        CRUDStudent crud = new CRUDStudentImpl(DatabaseConnection.getConnection());

//        crud.insert(new Student("STD2025002", "RakotoBe", "0341234422",
//                "rakoto@mail.com", "MadagascarStreet", "Be", "Rakoto"));
        System.out.println(crud.findAll());

        System.out.println("Who's STD2025001 ? Let us find out");

        Optional<Student> optionalStudent =  crud.findOneById("STD2025001");
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            System.out.println("It is : " + student);

            System.out.println("Let's change its name");
            student.setFirstName("HEI");
            crud.updateOneById("STD2025001", student);
        } else {
            System.out.println("STD2025001 does not exist.");
        }

        System.out.println(crud.findAll());
    }
}

package dao;

import student.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CRUDStudentImpl implements CRUDStudent{
    private Connection connection;

    public CRUDStudentImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public Student insert(Student toInsert) {
        String sql = "INSERT INTO student VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stm = this.connection.prepareStatement(sql)){
            stm.setString(1, toInsert.getId());
            stm.setString(2, toInsert.getUserName());
            stm.setString(3, toInsert.getPhone());
            stm.setString(4, toInsert.getEmail());
            stm.setString(5, toInsert.getAddress());
            stm.setString(6, toInsert.getFirstName());
            stm.setString(7, toInsert.getLastName());

            stm.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }

        return toInsert;
    }

    @Override
    public Optional<Student> findOneById(String id) {
        String sql = "SELECT * FROM student WHERE id = ?";
        Student student = null;

        try (PreparedStatement stm = this.connection.prepareStatement(sql)){
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                student = new Student(
                        rs.getString("id"),
                        rs.getString("user_name"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("first_name"),
                        rs.getString("last_name")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(student);
    }

    @Override
    public List<Student> findAll() {
        String sql = "SELECT * FROM student";
        List<Student> students = new ArrayList<>();

        try (PreparedStatement stm = this.connection.prepareStatement(sql)){
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Student student = new Student(
                        rs.getString("id"),
                        rs.getString("user_name"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("first_name"),
                        rs.getString("last_name")
                );
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    @Override
    public Student updateOneById(String id, Student updatedStudent) {
        String sql = "UPDATE student SET user_name = ?, phone = ?, email = ?, address = ?, first_name = ?, last_name = ? WHERE id = ?";

        try (PreparedStatement stm = this.connection.prepareStatement(sql)) {
            stm.setString(1, updatedStudent.getUserName());
            stm.setString(2, updatedStudent.getPhone());
            stm.setString(3, updatedStudent.getEmail());
            stm.setString(4, updatedStudent.getAddress());
            stm.setString(5, updatedStudent.getFirstName());
            stm.setString(6, updatedStudent.getLastName());
            stm.setString(7, id);

            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updatedStudent;
    }

    @Override
    public Student deleteById(String id) {
        String sql = "DELETE FROM student WHERE id = ?";
        Student deletedStudent = null;

        try (PreparedStatement stm = connection.prepareStatement(sql)){
            Optional<Student> studentOpt = findOneById(id);

            if (studentOpt.isPresent()) {
                deletedStudent = studentOpt.get();

                stm.setString(1, id);
                stm.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return deletedStudent;
    }
}
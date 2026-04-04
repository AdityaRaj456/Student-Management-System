import java.sql.*;

class StudentDAO {

    static void addStudent(String name, String course, String regno, String email) {
    try {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO students(name, course, regno, email) VALUES (?, ?, ?, ?)"
        );
        ps.setString(1, name);
        ps.setString(2, course);
        ps.setString(3, regno);
        ps.setString(4, email);
        ps.executeUpdate();
        System.out.println("Student Added");
    } catch (Exception e) {
        System.out.println(e);
    }
}

    static void viewStudents() {
        try {
            Connection con = DBConnection.getConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM students");

            while (rs.next()) {
                System.out.println(
                    rs.getInt(1) + " " +
                    rs.getString(2) + " " +
                    rs.getString(3)
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static ResultSet getStudents() {
        try {
            Connection con = DBConnection.getConnection();
            return con.createStatement().executeQuery("SELECT * FROM students");
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    // DELETE
    static void deleteStudent(int id) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM students WHERE id=?"
            );
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Student Deleted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // UPDATE
    static void updateStudent(int id, String name, String course, String regno, String email) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "UPDATE students SET name=?, course=?, regno=?, email=? WHERE id=?"
            );
            ps.setString(1, name);
            ps.setString(2, course);
            ps.setString(3, regno);
            ps.setString(4, email);
            ps.setInt(5, id);
            ps.executeUpdate();
            System.out.println("Student Updated");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

class GUI {
    JTable table;
    DefaultTableModel model;

    void loadTable() {
        try {
            model.setRowCount(0);
            ResultSet rs = StudentDAO.getStudents();

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("course"),
                        rs.getString("regno"),
                        rs.getString("email")
                });
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    GUI() {
        JFrame f = new JFrame("Student Management System");

        // COLORS
        Color bgColor = new Color(245, 247, 250);
        Color primary = new Color(52, 152, 219);
        Color danger = new Color(231, 76, 60);
        Color success = new Color(46, 204, 113);

        // MAIN PANEL
        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBackground(bgColor);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // TITLE
        JLabel title = new JLabel("Student Management System", JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setForeground(primary);

        // FORM PANEL
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBackground(bgColor);

        JTextField nameField = new JTextField();
        JTextField courseField = new JTextField();
        JTextField regField = new JTextField();
        JTextField emailField = new JTextField();

        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Course:"));
        formPanel.add(courseField);
        formPanel.add(new JLabel("Reg No:"));
        formPanel.add(regField);
        formPanel.add(new JLabel("Email:"));
        formPanel.add(emailField);

        // BUTTON PANEL
        JPanel btnPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        btnPanel.setBackground(bgColor);

        JButton addBtn = new JButton("Add");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");

        // Button Colors
        addBtn.setBackground(success);
        addBtn.setForeground(Color.WHITE);

        updateBtn.setBackground(primary);
        updateBtn.setForeground(Color.WHITE);

        deleteBtn.setBackground(danger);
        deleteBtn.setForeground(Color.WHITE);

        btnPanel.add(addBtn);
        btnPanel.add(updateBtn);
        btnPanel.add(deleteBtn);

        // TABLE
        model = new DefaultTableModel();
        table = new JTable(model);

        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Course");
        model.addColumn("Reg No");
        model.addColumn("Email");

        JScrollPane sp = new JScrollPane(table);

        // LEFT PANEL (Form + Buttons)
        JPanel leftPanel = new JPanel(new BorderLayout(10, 10));
        leftPanel.setBackground(bgColor);
        leftPanel.add(formPanel, BorderLayout.CENTER);
        leftPanel.add(btnPanel, BorderLayout.SOUTH);

        // ADD TO MAIN PANEL
        mainPanel.add(title, BorderLayout.NORTH);
        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(sp, BorderLayout.CENTER);

        // TABLE CLICK
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int i = table.getSelectedRow();

                nameField.setText(model.getValueAt(i, 1).toString());
                courseField.setText(model.getValueAt(i, 2).toString());
                regField.setText(model.getValueAt(i, 3).toString());
                emailField.setText(model.getValueAt(i, 4).toString());
            }
        });

        // ADD
        addBtn.addActionListener(e -> {
            StudentDAO.addStudent(
                    nameField.getText(),
                    courseField.getText(),
                    regField.getText(),
                    emailField.getText()
            );

            loadTable();
            clearFields(nameField, courseField, regField, emailField);
            JOptionPane.showMessageDialog(f, "Student Added!");
        });

        // UPDATE
        updateBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                int id = (int) model.getValueAt(row, 0);

                StudentDAO.updateStudent(
                        id,
                        nameField.getText(),
                        courseField.getText(),
                        regField.getText(),
                        emailField.getText()
                );

                loadTable();
                clearFields(nameField, courseField, regField, emailField);
                JOptionPane.showMessageDialog(f, "Updated!");
            }
        });

        // DELETE
        deleteBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                int id = (int) model.getValueAt(row, 0);

                StudentDAO.deleteStudent(id);
                loadTable();
                clearFields(nameField, courseField, regField, emailField);

                JOptionPane.showMessageDialog(f, "Deleted!");
            }
        });

        loadTable();

        f.add(mainPanel);
        f.setSize(800, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    // Clear fields
    void clearFields(JTextField n, JTextField c, JTextField r, JTextField e) {
        n.setText("");
        c.setText("");
        r.setText("");
        e.setText("");
    }
}
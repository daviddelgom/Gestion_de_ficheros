package view.console;

import exceptions.EmptyFieldException;
import exceptions.InvalidEmailException;
import model.UserDataValidations;

import javax.swing.*;

public class JFrameMain extends JFrame {

    private JTextField txtNombre;
    private JTextField txtEmail;
    private JButton btnEnviar;

    public JFrameMain() {
        setTitle("Formulario de Usuario");
        setSize(350, 200);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 30, 80, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(120, 30, 180, 25);
        add(txtNombre);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(30, 70, 80, 25);
        add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(120, 70, 180, 25);
        add(txtEmail);

        btnEnviar = new JButton("Validar");
        btnEnviar.setBounds(120, 110, 100, 30);
        add(btnEnviar);

        btnEnviar.addActionListener(e -> validarDatos());

        setVisible(true);
    }

    private void validarDatos() {
        try {
            String nombre = txtNombre.getText();
            String email = txtEmail.getText();

            UserDataValidations.validarNombre(nombre);
            UserDataValidations.validarEmail(email);

            JOptionPane.showMessageDialog(this, "Datos válidos. ¡Formulario correcto!", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (EmptyFieldException | InvalidEmailException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new JFrameMain();
    }
}
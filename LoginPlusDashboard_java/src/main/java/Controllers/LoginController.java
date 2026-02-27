package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class LoginController {

    @FXML
    private TextField TxtUsuario;
    @FXML
    private TextField TxtCorreo;
    @FXML
    private PasswordField TxtPassword;
    @FXML
    private TextField lblError;

    public void onLogin(ActionEvent event) {
        String usuario  = TxtUsuario.getText()  == null ? "" : TxtUsuario.getText();
        String correo   = TxtCorreo.getText()   == null ? "" : TxtCorreo.getText();
        String password = TxtPassword.getText() == null ? "" : TxtPassword.getText();

        List<String> errores = new ArrayList<>();


        if (usuario.trim().isEmpty() || usuario.length() < 4) {
            errores.add("Usuario inválido (mín 4 caracteres). ");
        }

        if (correo.trim().isEmpty() || !correo.contains("@") || !correo.contains(".")) {
            errores.add("Correo inválido (debe incluir @ y .). ");
        }
        if (password.isEmpty() || password.length() < 6) {
            errores.add("Contraseña inválida (mín 6 caracteres). ");
        }

        if (errores.isEmpty()) {

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/loginplusdashboard_java/dashboard-view.fxml"));
                Scene dashboardScene = new Scene(loader.load(), 500, 400);


                DashboardController dashboardController = loader.getController();
                dashboardController.setUsuario(usuario);

                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                stage.setScene(dashboardScene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            String mensajeError = "";
            for (String error : errores) {
                mensajeError += error;
            }
            lblError.setText(mensajeError);
            lblError.setStyle("-fx-border-color: red; -fx-text-fill: red;");
        }
    }
}

package fr.romain.compteurbouteilles2binding;

import fr.romain.utils.ApplicationUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

// TOUS LES CONTROLLERS DOIVENT IMPLEMENTER INITIALIZABLE
// PUIS, ON DOIT L'ATTACHER AU FICHIER FXML CORRESPONDANT :
// fx:controller="fr.romain.compteurbouteilles2binding.MainController"
public class MainController implements Initializable {

    // NE PAS OUBLIER D'AJOUTER LES ANNOTATIONS FXML

    // ATTENTION A LA POST ET/OU PRE INCREMENTATION

    @FXML
    private Label statusLabel;

    private int totalBottleCount = 0;

    @FXML
    protected void handleAddBottleButtonAction() {
        updateStatusLabel(++totalBottleCount);
        //System.out.println("Add Button Clicked");
    }

    @FXML
    protected void handleRemoveBottleButtonAction() {
        if (totalBottleCount > 0) {
            updateStatusLabel(--totalBottleCount);
        }
        //System.out.println("Remove Button Clicked");
    }

    public void updateStatusLabel(int totalBottleCount) {
        statusLabel.setText("Vous avez : " + ApplicationUtils.pluralize(totalBottleCount, "Bouteille"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateStatusLabel(totalBottleCount);
        System.out.println("INITIALISATION DU CONTROLLER");
    }
}
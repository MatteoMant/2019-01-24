/**
 * Sample Skeleton for 'ExtFlightDelays.fxml' Controller Class
 */

package it.polito.tdp.extflightdelays;

import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.extflightdelays.model.Adiacenza;
import it.polito.tdp.extflightdelays.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ExtFlightDelaysController {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="btnCreaGrafo"
    private Button btnCreaGrafo; // Value injected by FXMLLoader

    @FXML // fx:id="cmbBoxStati"
    private ComboBox<String> cmbBoxStati; // Value injected by FXMLLoader

    @FXML // fx:id="btnVisualizzaVelivoli"
    private Button btnVisualizzaVelivoli; // Value injected by FXMLLoader

    @FXML // fx:id="txtT"
    private TextField txtT; // Value injected by FXMLLoader

    @FXML // fx:id="txtG"
    private TextField txtG; // Value injected by FXMLLoader

    @FXML // fx:id="btnSimula"
    private Button btnSimula; // Value injected by FXMLLoader

    @FXML
    void doCreaGrafo(ActionEvent event) {
    	cmbBoxStati.getItems().clear();
  
    	this.model.creaGrafo();
    	txtResult.setText("Grafo creato!\n");
    	txtResult.appendText("# Vertici : " + this.model.getNumVertici() + "\n");
    	txtResult.appendText("# Archi : " + this.model.getNumArchi() + "\n");
    	
    	// Dopo aver creato il grafo, possiamo popolare la tendina
    	List<String> stati = this.model.getAllVertici();
    	Collections.sort(stati);
    	cmbBoxStati.getItems().addAll(stati);
    }

    @FXML
    void doSimula(ActionEvent event) {

    }

    @FXML
    void doVisualizzaVelivoli(ActionEvent event) {
    	String stato = cmbBoxStati.getValue();
    	if (stato == null) {
    		txtResult.appendText("Per favore selezionare uno stato dalla tendina!\n");
    		return;
    	}
    	List<Adiacenza> connessi = this.model.getStatiConnessi(stato);
    	txtResult.appendText("Gli stati connessi allo stato '" + stato + "' sono: \n");
    	for (Adiacenza a : connessi) {
    		txtResult.appendText(a.getStato2() + " - " + a.getPeso() + "\n");
    	}
    }
    
    public void setModel(Model model) {
		this.model = model;	
	}

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'ExtFlightDelays.fxml'.";
        assert btnCreaGrafo != null : "fx:id=\"btnCreaGrafo\" was not injected: check your FXML file 'ExtFlightDelays.fxml'.";
        assert cmbBoxStati != null : "fx:id=\"cmbBoxStati\" was not injected: check your FXML file 'ExtFlightDelays.fxml'.";
        assert btnVisualizzaVelivoli != null : "fx:id=\"btnVisualizzaVelivoli\" was not injected: check your FXML file 'ExtFlightDelays.fxml'.";
        assert txtT != null : "fx:id=\"txtT\" was not injected: check your FXML file 'ExtFlightDelays.fxml'.";
        assert txtG != null : "fx:id=\"txtG\" was not injected: check your FXML file 'ExtFlightDelays.fxml'.";
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'ExtFlightDelays.fxml'.";

    }
}
 package pkgApp.controller;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable {

	private RetirementApp mainApp = null;

	@FXML
	private TextField txtYearsToWork;
	@FXML
	private TextField txtAnnualReturnWork;
	@FXML
	private TextField txtYearsRetired;
	@FXML
	private TextField txtAnnualReturnRetired;
	@FXML
	private TextField txtRequiredIncome;
	@FXML
	private TextField txtMonthlySSI;
	@FXML
	private TextField txtSaveEachMonth;
	@FXML
	private TextField txtNeedToSave;

	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	@FXML
	public void btnClear(ActionEvent event) {
		System.out.println("Clear pressed");

		txtYearsToWork.clear();
		txtAnnualReturnWork.clear();
		txtYearsRetired.clear();
		txtAnnualReturnRetired.clear();
		txtRequiredIncome.clear();
		txtMonthlySSI.clear();
		txtSaveEachMonth.clear();
		txtNeedToSave.clear();

	}

	@FXML
	public void btnCalculate(ActionEvent event) {

		if (InputValid()) {
			Retirement k = new Retirement();
			k.setdAnnualReturnWorking(Double.parseDouble(txtAnnualReturnWork.getText()));
			k.setdAnnualReturnRetired(Double.parseDouble(txtAnnualReturnRetired.getText()));
			k.setdRequiredIncome(Double.parseDouble(txtRequiredIncome.getText()));
			k.setdMonthlySSI(Double.parseDouble(txtMonthlySSI.getText()));
			k.setiYearsToWork(Integer.parseInt(txtYearsToWork.getText()));
			k.setiYearsRetired(Integer.parseInt(txtYearsRetired.getText()));
			double needToSave = k.TotalAmountSaved();
			double saveEachMonth = k.AmountToSave(needToSave);

			txtSaveEachMonth.setText(NumberFormat.getCurrencyInstance().format(saveEachMonth));
			txtNeedToSave.setText(NumberFormat.getCurrencyInstance().format(needToSave));
		}

	}

	private boolean InputValid() {
		if (txtAnnualReturnWork.getText().isEmpty()) {
			Alert a = new Alert(Alert.AlertType.ERROR);
			a.setContentText("Invalid input");
			a.show();
			return false;
		}
		try {
			double workReturn = Double.parseDouble(txtAnnualReturnWork.getText());
			if (workReturn < 0 || workReturn > 0.2) {
				Alert a= new Alert(Alert.AlertType.ERROR);
				a.setContentText("Invalid input");
				a.show();
				return false;
			}
		} catch (NumberFormatException e) {
			Alert a = new Alert(Alert.AlertType.ERROR);
			a.setContentText("Invalid input");
			a.show();
			return false;
		}

		if (txtYearsToWork.getText().isEmpty()) {
			Alert a = new Alert(Alert.AlertType.ERROR);
			a.setContentText("Invalid input!");
			a.show();
			return false;
		}
		try {
			Integer.parseInt(txtYearsToWork.getText());
		} catch (NumberFormatException e) {
			Alert a = new Alert(Alert.AlertType.ERROR);
			a.setContentText("Invalid input");
			a.show();
			return false;
		}

		if (txtYearsRetired.getText().isEmpty()) {
			Alert a = new Alert(Alert.AlertType.ERROR);
			a.setContentText("Invalid input");
			a.show();
			return false;
		}
		try {
			Integer.parseInt(txtYearsRetired.getText());
		} catch (NumberFormatException e) {
			Alert a = new Alert(Alert.AlertType.ERROR);
			a.setContentText("Invalid input");
			a.show();
			return false;
		}

		if (txtAnnualReturnRetired.getText().isEmpty()) {
			Alert a = new Alert(Alert.AlertType.ERROR);
			a.setContentText("Invalid input");
			a.show();
			return false;
		}
		try {
			double RReturn = Double.parseDouble(txtAnnualReturnRetired.getText());
			if (RReturn < 0 || RReturn > 0.03) {
				Alert a = new Alert(Alert.AlertType.ERROR);
				a.setContentText("Invalid input");
				a.show();
				return false;
			}
		} catch (NumberFormatException e) {
			Alert a = new Alert(Alert.AlertType.ERROR);
			a.setContentText("Invalid input");
			a.show();
			return false;
		}

		if (txtRequiredIncome.getText().isEmpty()) {
			Alert a = new Alert(Alert.AlertType.ERROR);
			a.setContentText("Invalid input");
			a.show();
			return false;
		}
		try {
			Double.parseDouble(txtRequiredIncome.getText());
		} catch (NumberFormatException e) {
			Alert a = new Alert(Alert.AlertType.ERROR);
			a.setContentText("Invalid input");
			a.show();
			return false;
		}

		if (txtMonthlySSI.getText().isEmpty()) {
			Alert a = new Alert(Alert.AlertType.ERROR);
			a.setContentText("Invalid input");
			a.show();
			return false;
		}
		try {
			Double.parseDouble(txtMonthlySSI.getText());
		} catch (NumberFormatException e) {
			Alert a = new Alert(Alert.AlertType.ERROR);
			a.setContentText("Invalid input");
			a.show();
			return false;
		}

		return true;
	}
}

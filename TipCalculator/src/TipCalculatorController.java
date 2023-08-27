//TipCalculatorController.java
// Controller that handles calculateButton and tipPercentageSlider events
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class TipCalculatorController {
// formatters for currency and percentages
private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
private static final NumberFormat percent = NumberFormat.getPercentInstance();

private BigDecimal tipPercentage = new BigDecimal(0.15); // 15% default

// GUI controls defined in FXML and used by the controller's code
@FXML
private TextField amountTextField;

@FXML
private Label tipPercentageLabel;
@FXML
private Slider tipPercentageSlider;

@FXML
private TextField tipTextField;

@FXML
private TextField totalTextField;

// calculates and displays the tip and total amounts
@FXML
private void calculateButtonPressed(ActionEvent event) {
try {
BigDecimal amount = new BigDecimal(amountTextField.getText());
BigDecimal tip = amount.multiply(tipPercentage);
BigDecimal total = amount.add(tip);

tipTextField.setText(currency.format(tip));
totalTextField.setText(currency.format(total));
} catch (NumberFormatException ex) {
amountTextField.setText("Enter amount");
amountTextField.selectAll();
amountTextField.requestFocus();
}
}

@FXML
public void onEnter(ActionEvent ae) {
BigDecimal amount = new BigDecimal(amountTextField.getText());
BigDecimal tip = amount.multiply(tipPercentage);
BigDecimal total = amount.add(tip);
tipTextField.setText(currency.format(tip));
totalTextField.setText(currency.format(total));
}

// called by FXMLLoader to initialize the controller
public void initialize() {
// 0-4 rounds down, 5-9 rounds up
currency.setRoundingMode(RoundingMode.HALF_UP);

amountTextField.setOnKeyPressed((EventHandler<? super KeyEvent>) new EventHandler<KeyEvent>() {
public void handle(KeyEvent e) {
BigDecimal amount = new BigDecimal(amountTextField.getText());
BigDecimal tip = amount.multiply(tipPercentage);
BigDecimal total = amount.add(tip);
tipTextField.setText(currency.format(tip));
totalTextField.setText(currency.format(total));
}
});

// listener for changes to tipPercentageSlider's value
tipPercentageSlider.valueProperty().addListener(new ChangeListener() {
public void changed(ObservableValue ov, Object oldValue, Number newValue) {
tipPercentage = BigDecimal.valueOf(newValue.intValue() / 100.0);
tipPercentageLabel.setText(percent.format(tipPercentage));
}

@Override
public void changed(ObservableValue observable, Object oldValue, Object newValue) {
tipPercentage = BigDecimal.valueOf(((Number) newValue).intValue() / 100.0);
tipPercentageLabel.setText(percent.format(tipPercentage));
BigDecimal amount = new BigDecimal(amountTextField.getText());
BigDecimal tip = amount.multiply(tipPercentage);
BigDecimal total = amount.add(tip);
tipTextField.setText(currency.format(tip));
totalTextField.setText(currency.format(total));

}
});
}
}
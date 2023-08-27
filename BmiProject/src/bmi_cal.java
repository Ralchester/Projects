//Java 2
//Rafael Ortiz
//Hw 1 Bmi Calculator

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.HBox;

public class bmi_cal extends Application {
	@Override
	public void start(Stage stage) {
	/* What features and text are in the form */
	Text text1 = new Text("Weight(lb/kg)");
	Text text2 = new Text("Height(in/m)");
	TextField textField1 = new TextField();
	TextField textField2 = new TextField();
	Button button1 = new Button("Calculate");
	Label label1 =new Label("Result (BMI) :");
	Label label2=new Label("answer");

	final ComboBox combobox1 = new ComboBox();
	combobox1.getItems().addAll(
	"lb",
	"kg"
	);
	final ComboBox combobox2 = new ComboBox();
	combobox2.getItems().addAll(
	"inch",
	"meter"
	);

	GridPane gridPane = new GridPane();
	/*Size of the screen */
	gridPane.setMinSize(400, 200);

	/*padding value */
	gridPane.setPadding(new Insets(10, 10, 10, 10));

	/* space between fields */
	gridPane.setVgap(10);
	gridPane.setHgap(10);

	//Setting the Grid alignment
	gridPane.setAlignment(Pos.CENTER);
	/* putting the fields in different position */
	gridPane.add(text1, 0, 0);
	gridPane.add(textField1, 1, 0);
	gridPane.add(text2, 0, 1);
	gridPane.add(textField2, 1, 1);
	gridPane.add(button1, 0, 2);
	gridPane.add(label1, 0, 3);
	gridPane.add(label2, 1, 3);
	gridPane.add(combobox1, 2, 0);
	gridPane.add(combobox2, 2, 1);
	//Styling nodes
	button1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

	text1.setStyle("-fx-font: normal bold 20px 'serif' ");
	text2.setStyle("-fx-font: normal bold 20px 'serif' ");
	gridPane.setStyle("-fx-background-color: BEIGE;");

	/* button action event */
	EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
	public void handle(ActionEvent e)
	{
	/* variable declare */
	double wt,ht,bmi;
	/* put the boxes in the text fields */
	wt=Double.valueOf(textField1.getText());
	ht=Double.valueOf(textField2.getText());
	if (combobox1.getValue() =="lb" && combobox2.getValue() =="inch")
	{
	/* calculate the value*/
	bmi=(wt*703)/(ht*ht);
	/* result will be printed on label2*/
	label2.setText(Double.toString(bmi)+ " kg/m^2");
	}

	if (combobox1.getValue() =="kg" && combobox2.getValue() =="meter")
	{
	/* calculate the value*/
	bmi=(wt/(ht*ht));
	/* result will be printed on label2*/
	label2.setText(Double.toString(bmi)+ " kg/m^2");
	}
	}
	};

	/* button is pressed */
	button1.setOnAction(event);
	/*Creating a scene object */
	Scene sc = new Scene(gridPane);
	/*putting title */
	stage.setTitle("BMI Calculator");
	/* adding scene to the stage */
	stage.setScene(sc);
	//Displaying the contents of the stage
	stage.show();
	}
	public static void main(String args[]){
	launch(args);
	}
	}

import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.*;
import javafx.scene.control.TextFormatter;
import javafx.util.StringConverter;
import javafx.scene.paint.Color;

/*
**Bailey Spicer
**March 28, 2016
**bes2725@email.vccs.edu
**this is an authenticaiton program.  it will get text input from GUI and confirm username/password
**then it will further authenticate by requiring the user to know the correct account type.
*/

public class Authentication2 extends Application
{
	public void start (Stage primaryStage)
	{
		final String USERNAME = "Bailey", PASSWORD = "keePer";
		//string
		
		primaryStage.setTitle("Authentication");
		Label userName = new Label("Username");
		TextField userNameTxtFld = new TextField();
		Label passWord = new Label("Password");
		PasswordField pwTxtFld = new PasswordField();
		Button submitBtn = new Button("Login");
		Text sceneTitle = new Text("Welcome! Please login.");
		sceneTitle.setFont(Font.font(20));
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		GridPane.setConstraints(sceneTitle,2,1);
		GridPane.setConstraints(userName, 2,3);
		GridPane.setConstraints(userNameTxtFld, 2,4);
		GridPane.setConstraints(passWord, 2,5);
		GridPane.setConstraints(pwTxtFld,2,6);
		GridPane.setConstraints(submitBtn, 2,7);
		final Text wrong = new Text();
		grid.add(wrong, 2,8);
		submitBtn.setOnAction(new EventHandler<ActionEvent>()
			{
				public void handle(ActionEvent event)
				{
					int count = 1;
					String inuser = userNameTxtFld.getText();
					String inpass = pwTxtFld.getText();
					if (USERNAME.equalsIgnoreCase(inuser) && PASSWORD.equals(inpass))
					{
						JOptionPane.showMessageDialog(null, "Welcome, " + USERNAME);
					}
					else
					{	
					while (count<=3)
					{
					wrong.setFill(Color.RED);
					wrong.setText("Incorrect username or password");
						if (count == 3)
						{
							JOptionPane.showMessageDialog(null, "ERROR");
						}
						else
						{ 
						count++;
						}
					}
					}
				}
			});
		grid.getChildren().add(sceneTitle);
		grid.getChildren().add(submitBtn);
		grid.getChildren().add(userName);
		grid.getChildren().add(passWord);
		grid.getChildren().add(userNameTxtFld);
		grid.getChildren().add(pwTxtFld);
		Scene scene = new Scene(grid,300,300);
		primaryStage.setScene(scene);
		primaryStage.show();
			

	}
}

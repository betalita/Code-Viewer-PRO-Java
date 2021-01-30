package pl.edu.prz.jprokop;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
public class FXProgram extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}
	@Override
	public void start(Stage stage) {
		Image image = new Image("myImage.jpg");
		ImageView imageView = new ImageView(image);
		DatePicker datePicker = new DatePicker();
		VBox root = new VBox(10, datePicker, imageView);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("MyTitle");
		//stage.show();
	}
}
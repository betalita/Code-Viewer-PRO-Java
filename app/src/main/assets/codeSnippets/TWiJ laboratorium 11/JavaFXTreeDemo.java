import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class JavaFXTreeDemo extends Application {
	@Override
	public void start(Stage primaryStage) {
		TreeItem<String> java = new TreeItem<String>("Java");
		TreeItem<String> lecture = new TreeItem<String>("Lecture");
		TreeItem<String> laboratory = new TreeItem<String>("Laboratory");
		TreeItem<String> project = new TreeItem<String>("Project");
		java.getChildren().addAll(lecture, laboratory, project);
		TreeItem<String> lec1 = new TreeItem<String>("Lec01");
		TreeItem<String> lec2 = new TreeItem<String>("Lec02");
		TreeItem<String> lec3 = new TreeItem<String>("Lec03");
		lecture.getChildren().addAll(lec1, lec2, lec3);
		TreeItem<String> lab1 = new TreeItem<String>("Lab01");
		TreeItem<String> lab2 = new TreeItem<String>("Lab02");
		TreeItem<String> lab3 = new TreeItem<String>("Lab03");
		laboratory.getChildren().addAll(lab1, lab2, lab3);
		TreeView<String> treeView = new TreeView<>(java);
		treeView.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue)
						-> System.out.println("Selected Text : " + newValue.getValue()));
		StackPane root = new StackPane();
		root.getChildren().add(treeView);
		Scene scene = new Scene(root, 300, 250);
		primaryStage.setTitle("JavaPRO");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
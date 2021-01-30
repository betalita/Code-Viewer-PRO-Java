package pl.edu.prz.jprokop;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;
public class PieChartSample extends Application {
	@Override
	public void starts(Stage stage) {
		Scene scene = new Scene(new Group());
		stage.setTitle("Języki programowania");
		stage.setWidth(500);
		stage.setHeight(500);
		ObservableList<PieChart.Data> pieChartData
				= FXCollections.observableArrayList(
				new PieChart.Data("Java", 21),
				new PieChart.Data("C", 14),
				new PieChart.Data("C++", 6),
				new PieChart.Data("C#", 3.8),
				new PieChart.Data("PHP", 3),
				new PieChart.Data("Python",3.2));
		final PieChart chart = new PieChart(pieChartData);
		chart.setTitle("Języki programowania");
		((Group) scene.getRoot()).getChildren().add(chart);
		stage.setScene(scene);
		//stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}

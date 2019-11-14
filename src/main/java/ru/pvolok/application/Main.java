package ru.pvolok.application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;

import java.io.FileReader;

public class Main extends Application {

	private final String APP_NAME = "Musictool";

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		MavenXpp3Reader reader = new MavenXpp3Reader();
		Model model = reader.read(new FileReader("pom.xml"));
		String appVersion = model.getVersion();
		stage.setTitle(APP_NAME + " " + appVersion);
		StackPane root = new StackPane();
		stage.setScene(new Scene(root, 1280, 720));
		stage.show();
	}
}

package ru.pvolok.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;

import java.io.FileReader;
import java.net.URL;

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

		FXMLLoader loader = new FXMLLoader();
		URL xmlUrl = getClass().getResource("/ui/primary.fxml");
		loader.setLocation(xmlUrl);
		Parent root = loader.load();

		stage.setScene(new Scene(root));
		stage.setTitle(APP_NAME + " " + appVersion);
		if (System.getProperty("os.name").contains("Mac")) {
			MenuBar menuBar = (MenuBar) stage.getScene().lookup("#mainMenuBar");
			menuBar.useSystemMenuBarProperty().set(true);
		}

		stage.show();
	}
}

package ru.pvolok.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import ru.pvolok.utils.CueUtils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class Main extends Application {

	private final String APP_NAME = "Musictool";

	public static void main(String[] args) throws IOException {
		CueUtils.readFromFile(new File("C:\\Users\\pvolok\\Downloads\\Meteora\\Linkin Park - Meteora.cue"));
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
		stage.show();
	}
}

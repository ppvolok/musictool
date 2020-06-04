package ru.pvolok.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import ru.pvolok.helper.cue.CueObject;
import ru.pvolok.utils.CueUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class PrimaryController {

	@FXML
	private TextField folderPath;

	@FXML
	private AnchorPane mainPane;

	@FXML
	private void chooseFolderAction() throws IOException {
		DirectoryChooser directoryChooser = new DirectoryChooser();
		File dir = directoryChooser.showDialog(mainPane.getScene().getWindow());
		if (dir != null) {
			String dirPath = dir.getAbsolutePath();
			List<String> cueFiles = Files.walk(Paths.get(dirPath))
					.map(x -> x.toString())
					.filter(f -> f.endsWith(".cue"))
					.collect(Collectors.toList());
			CueObject cueSheet = CueUtils.readFromFile(new File(cueFiles.get(0)));
			folderPath.setText(dirPath);
		} else {
			folderPath.setText(null);
		}
	}

	@FXML
	private void quitApplication() {
		Platform.exit();
	}
}

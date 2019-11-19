package ru.pvolok.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;

import java.io.File;

public class PrimaryController {

	@FXML
	private TextField folderPath;

	@FXML
	private AnchorPane mainPane;

	@FXML
	private void chooseFolderAction() {
		DirectoryChooser directoryChooser = new DirectoryChooser();
		File dir = directoryChooser.showDialog(mainPane.getScene().getWindow());
		if (dir != null) {
			folderPath.setText(dir.getAbsolutePath());
		} else {
			folderPath.setText(null);
		}
	}

	@FXML
	private void quitApplication() {
		Platform.exit();
	}
}

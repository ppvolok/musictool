package ru.pvolok.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;

public class PrimaryController {

	@FXML
	private void quitApplication() {
		Platform.exit();
	}
}

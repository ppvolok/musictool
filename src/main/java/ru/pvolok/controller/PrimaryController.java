package ru.pvolok.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import ru.pvolok.helper.cue.CueObject;
import ru.pvolok.model.SongTableModel;
import ru.pvolok.utils.CueUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class PrimaryController {

	@FXML private TextField folderPath;
	@FXML private AnchorPane mainPane;

	@FXML private TableView<SongTableModel> musicTable;
	@FXML private TableColumn<SongTableModel, String> numberColumn;
	@FXML private TableColumn<SongTableModel, String> nameColumn;
	@FXML private TableColumn<SongTableModel, String> artistColumn;
	@FXML private TableColumn<SongTableModel, String> albumColumn;
	@FXML private TableColumn<SongTableModel, String> yearColumn;

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
			if (cueFiles.size() != 0) {
				CueObject cueSheet = CueUtils.readFromFile(new File(cueFiles.get(0)));
				List<SongTableModel> model = CueUtils.createModelFromCue(cueSheet);

				numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
				nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
				artistColumn.setCellValueFactory(new PropertyValueFactory<>("artist"));
				albumColumn.setCellValueFactory(new PropertyValueFactory<>("album"));
				yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));

				musicTable.getItems().setAll(model);
			}
			folderPath.setText(dirPath);
		} else {
			folderPath.setText(null);
			musicTable.getItems().clear();
		}
	}

	@FXML
	private void quitApplication() {
		Platform.exit();
	}
}

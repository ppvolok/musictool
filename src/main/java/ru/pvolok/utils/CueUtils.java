package ru.pvolok.utils;

import ru.pvolok.helper.cue.CueObject;
import ru.pvolok.helper.cue.CueTime;
import ru.pvolok.helper.cue.CueTrack;
import ru.pvolok.model.SongTableModel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class CueUtils {

	public static CueObject readFromFile(File file) throws IOException {
		CueObject cueObject = new CueObject();
		List<CueTrack> tracks = new ArrayList<>();
		Files.lines(file.toPath()).forEach(line -> {
			String key, value;
			CueTrack currentTrack = new CueTrack();
			line = line.strip();
			switch (line.split("\\s")[0]) {
				case "REM":
					key = line.split("\\s")[1];
					value = line.split(key)[1].strip();
					cueObject.getRems().put(key, StringUtils.removeQuotes(value));
					break;
				case "PERFORMER":
					key = line.split("\\s")[0];
					value = line.split(key)[1].strip();
					String performer = StringUtils.removeQuotes(value);
					if (!tracks.isEmpty()) {
						tracks.get(tracks.size() - 1).setPerformer(performer);
					} else {
						cueObject.setPerformer(performer);
					}
					break;
				case "TITLE":
					key = line.split("\\s")[0];
					value = line.split(key)[1].strip();
					String title = StringUtils.removeQuotes(value);
					if (!tracks.isEmpty()) {
						tracks.get(tracks.size() - 1).setTitle(title);
					} else {
						cueObject.setTitle(title);
					}
					break;
				case "FILE":
					cueObject.setFile(line.split("\"")[1]);
					break;
				case "INDEX":
					String[] timeArray = line.split("\\s")[2].split(":");
					String indexNumber = line.split("\\s")[1];
					int minute = Integer.parseInt(timeArray[0]);
					int second = Integer.parseInt(timeArray[1]);
					int frame = Integer.parseInt(timeArray[2]);
					CueTime index = new CueTime(minute, second, frame);
					if ("00".equals(indexNumber)) {
						tracks.get(tracks.size() - 1).setIndex00(index);
					} else if ("01".equals(indexNumber)) {
						tracks.get(tracks.size() - 1).setIndex01(index);
					}
					break;
				case "TRACK":
					int number = Integer.parseInt(line.split("\\s")[1]);
					currentTrack.setNumber(number);
					String type = line.split("\\s")[2];
					type = type.substring(0, 1).toUpperCase() + type.substring(1).toLowerCase();
					currentTrack.setType(type);
					tracks.add(currentTrack);
					break;
			}
		});
		cueObject.setTracks(tracks);
		return cueObject;
	}

	public static List<SongTableModel> createModelFromCue(CueObject cueObject) {
		List<SongTableModel> rows = new ArrayList<>();

		String year = cueObject.getRems().get("DATE");
		String album = cueObject.getTitle();
		String artist = cueObject.getPerformer();
		for (CueTrack track : cueObject.getTracks()) {
			int number = track.getNumber();
			String name = track.getTitle();
			rows.add(new SongTableModel(String.format("%02d", number), name, artist, album, year));
		}

		return rows;
	}
}

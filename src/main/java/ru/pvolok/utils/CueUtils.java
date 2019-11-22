package ru.pvolok.utils;

import ru.pvolok.helper.cue.CueObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CueUtils {

	public static CueObject readFromFile(File file) throws IOException {
		CueObject cueObject = new CueObject();
		Files.lines(file.toPath()).forEach(line -> {
			String key, value;
			switch (line.split("\\s")[0]) {
				case "REM":
					key = line.split("\\s")[1];
					value = line.split(key)[1].strip();
					cueObject.getRems().put(key, StringUtils.removeQuotes(value));
					break;
				case "PERFORMER":
					key = line.split("\\s")[0];
					value = line.split(key)[1].strip();
					cueObject.setPerformer(StringUtils.removeQuotes(value));
					break;
				case "TITLE":
					key = line.split("\\s")[0];
					value = line.split(key)[1].strip();
					cueObject.setTitle(StringUtils.removeQuotes(value));
					break;
				case "FILE":
					cueObject.setFile(line.split("\"")[1]);
			}
		});
		return null;
	}
}

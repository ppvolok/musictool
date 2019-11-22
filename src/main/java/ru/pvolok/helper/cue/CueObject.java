package ru.pvolok.helper.cue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CueObject {
	private String performer;
	private String title;
	private String file;
	private Map<String, String> rems = new HashMap<>();
	private List<CueTrack> tracks;

	public String getPerformer() {
		return performer;
	}

	public void setPerformer(String performer) {
		this.performer = performer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public Map<String, String> getRems() {
		return rems;
	}

	public void setRems(Map<String, String> rems) {
		this.rems = rems;
	}

	public List<CueTrack> getTracks() {
		return tracks;
	}

	public void setTracks(List<CueTrack> tracks) {
		this.tracks = tracks;
	}

}

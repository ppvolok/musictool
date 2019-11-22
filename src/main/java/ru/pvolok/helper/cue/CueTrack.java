package ru.pvolok.helper.cue;

public class CueTrack {
	private String title;
	private String performer;
	private String type;
	private int number;
	private CueTime index00;
	private CueTime index01;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPerformer() {
		return performer;
	}

	public void setPerformer(String performer) {
		this.performer = performer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public CueTime getIndex00() {
		return index00;
	}

	public void setIndex00(CueTime index00) {
		this.index00 = index00;
	}

	public CueTime getIndex01() {
		return index01;
	}

	public void setIndex01(CueTime index01) {
		this.index01 = index01;
	}
}

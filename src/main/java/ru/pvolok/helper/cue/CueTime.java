package ru.pvolok.helper.cue;

public class CueTime {
	private int minute;
	private int second;
	private int frame;

	public CueTime(int minute, int second, int frame) {
		this.minute = minute;
		this.second = second;
		this.frame = frame;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public int getFrame() {
		return frame;
	}

	public void setFrame(int frame) {
		this.frame = frame;
	}
}

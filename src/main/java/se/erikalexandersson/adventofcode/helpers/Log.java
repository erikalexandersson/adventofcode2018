package se.erikalexandersson.adventofcode.helpers;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Log implements Comparable<Log> {

	public int year;
	public int month;
	public int day;

	public int hour;
	public int minute;

	public String event;

	public Log(Integer year, Integer month, Integer day, Integer hour, Integer minute, String event) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
		this.event = event;
	}

	public static Log parseLine(String line) {
		Pattern p = Pattern.compile("\\[(\\d+)-(\\d+)-(\\d+)\\s+(\\d+):(\\d+)\\]\\s+(.*)");
		Matcher m = p.matcher(line);

		if (m.matches()) {
			return new Log(Integer.valueOf(m.group(1)), Integer.valueOf(m.group(2)), Integer.valueOf(m.group(3)),
					Integer.valueOf(m.group(4)), Integer.valueOf(m.group(5)), m.group(6));
		} else {
			return null;
		}
	}

	public static List<Log> parseLines(List<String> lines) {
		return lines.stream().map(line -> parseLine(line)).sorted().collect(Collectors.toList());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Log other = (Log) obj;
		if (day != other.day)
			return false;
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
		if (hour != other.hour)
			return false;
		if (minute != other.minute)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public int compareTo(Log o) {
		if (this.year == o.year) {
			if (this.month == o.month) {
				if (this.day == o.day) {
					if (this.hour == o.hour) {
						if (this.minute == o.minute) {
							return event.compareTo(o.event);
						} else {
							return Integer.compare(this.minute, o.minute);
						}
					} else {
						return Integer.compare(this.hour, o.hour);
					}
				} else {
					return Integer.compare(this.day, o.day);
				}
			} else {
				return Integer.compare(this.month, o.month);
			}
		} else {
			return Integer.compare(this.year, o.year);
		}
	}

}

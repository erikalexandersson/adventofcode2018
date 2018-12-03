package se.erikalexandersson.adventofcode.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Claim {

	public String id;
	public int left;
	public int top;
	public int width;
	public int height;

	public Claim(String id, int left, int top, int width, int height) {
		this.id = id;
		this.left = left;
		this.top = top;
		this.width = width;
		this.height = height;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Claim other = (Claim) obj;
		if (height != other.height)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (left != other.left)
			return false;
		if (top != other.top)
			return false;
		if (width != other.width)
			return false;
		return true;
	}

	public static Claim parseLine(String line) {
		Pattern p = Pattern.compile("#(\\d+)\\s+@\\s+(\\d+),(\\d+):\\s+(\\d+)x(\\d+)");
		Matcher m = p.matcher(line);

		if (m.matches()) {
			return new Claim(m.group(1), Integer.valueOf(m.group(2)), Integer.valueOf(m.group(3)),
					Integer.valueOf(m.group(4)), Integer.valueOf(m.group(5)));
		} else {
			return null;
		}
	}

}
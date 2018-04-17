package com.tamboro.test2.question.one;

import java.util.Objects;

/**
 *
 * @author drishti
 */
public class HSV {

	private Integer hue;
	private Integer saturation;
	private Integer value;

	/**
	 * @param hue
	 * @param saturation
	 * @param value
	 */
	public HSV(Integer hue, Integer saturation, Integer value) {

		this.hue = hue;
		this.saturation = saturation;
		this.value = value;
	}

	public Integer getHue() {

		return hue;
	}

	public void setHue(Integer hue) {

		this.hue = hue;
	}

	public Integer getSaturation() {

		return saturation;
	}

	public void setSaturation(Integer saturation) {

		this.saturation = saturation;
	}

	public Integer getValue() {

		return value;
	}

	public void setValue(Integer value) {

		this.value = value;
	}

	@Override
	public boolean equals(Object obj) {
		HSV hsv = (HSV) obj;
		if (hsv != null && this.hue.equals(hsv.getHue()) && this.saturation.equals(hsv.getSaturation())
				&& this.value.equals(hsv.getValue())) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getHue(), this.getSaturation(), this.getValue());
	}

	@Override
	public String toString() {

		return "HSV [hue=" + hue + ", saturation=" + saturation + ", value=" + value + "]";
	}

}

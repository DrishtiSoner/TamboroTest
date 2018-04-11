package com.tamboro.test2.question.one;

import java.util.Vector;

/**
 * @author drishti
 */
public class HSVComplementaryColor {

	public static Vector<HSV> getComplementaryColorPairs(Vector<HSV> hsvColorVector) {

		Vector<HSV> hsvComplementaryColorVector = new Vector<>();

		for (HSV hsv : hsvColorVector) {
			HSV hsvComplementaryColor = getOppositeColor(hsv);

			boolean isPairAvailable = hsvColorVector.contains(hsvComplementaryColor);

			if (isPairAvailable) {
				hsvComplementaryColorVector.add(hsv);
			}
		}

		return hsvComplementaryColorVector;
	}

	// using (h + 180°, s, v) formula to get the complementary color

	private static HSV getOppositeColor(HSV hsv) {
		Integer hue = (hsv.getHue() + 180) > 360 ? (hsv.getHue() + 180) - 360 : hsv.getHue() + 180;
		return new HSV(hue, hsv.getSaturation(), hsv.getValue());
	}

	public static void main(String[] args) {

		// Creating the vector of HSV color tuples.

		Vector<HSV> hsvColorVector = new Vector<HSV>();

		HSV colorOne = new HSV(195, 11, 12);
		HSV colorSecond = new HSV(37, 13, 76);
		HSV colorThird = new HSV(15, 11, 12);

		hsvColorVector.add(colorThird);
		hsvColorVector.add(colorOne);
		hsvColorVector.add(colorSecond);

		Vector<HSV> hsvComplementaryColorVector = HSVComplementaryColor.getComplementaryColorPairs(hsvColorVector);

		if (hsvComplementaryColorVector.size() > 0) {
			System.out.println(hsvComplementaryColorVector);
		} else {
			System.out.println("No pairs found.");
		}

	}
}

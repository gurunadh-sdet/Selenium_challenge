package com.just.answer.interview;

public class AngleUnitTest {

	public static void main(String[] args) {
		//unit testing the method
		System.out.println(calcAngle(9,15));
		
	}
	
	public static int calcAngle(int h, int m) {
		if (h<0 || m < 0 || h>12 || m>60)
		return -1;
		if (h == 12)
		h = 0;
		if (m == 60)
		m = 0;
		int hour_angle = (int)(0.5 * (h*60 + m));
		System.out.println(hour_angle);
		int minute_angle = (int)(6*m);
		System.out.println(minute_angle);
		int angle = Math.abs(hour_angle - minute_angle);
		angle = Math.min(360-angle, angle);
		return angle;
		}
}


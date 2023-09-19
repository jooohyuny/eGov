package com.yun.jun131.main;

import java.util.Scanner;

//포인트적립률 : 허구헌날 바뀔것
public class MMain {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		int price;
		while (true) {
			System.out.print("구매한 금액 : ");
			price = k.nextInt();
			if (price <0) {
				break;
			}
			System.out.printf("포인트 : %.0f\n", price *0.01);
		}
		k.close();
		
	}
}

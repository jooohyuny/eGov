package com.yun.jun131.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

// 마트 정책이 포인트를 0.5%적립하는걸로 바뀜
// -> 프로그램 수정해야
// -> 마트 사장님 point.txt수정하면 됨
// => 마트측에서 해결 가능

// 뭔가가 .java에 써있으면 -> 컴파일 당해서 -> 수정불가능하게된다.
// 앞으로 말하는 유지보수에 용이 :
//		수정이 일어날만한거는 .java에 하지말고 외부 파일에 작성하자

// eGovFramework
// 		MyBatis	: Java + DB 유지보수에 용이
// 		Maven	: .jar관리 유지보수에 용이
//		Spring	: Java객체만드는거 유지보수에 용이

public class MMain2 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		BufferedReader br = null;
		try {
			FileInputStream fis = new FileInputStream("C:/yun/point.txt");
			InputStreamReader isr = new InputStreamReader(fis,"utf-8");
			br = new BufferedReader(isr);
			String p = br.readLine();
			System.out.println(p);
			double pointRate = Double.parseDouble(p);
			
			int price;
			while (true) {
				System.out.print("구매한 금액 : ");
				price = k.nextInt();
				if (price < 0) {
					break;
				}
				System.out.printf("포인트 : %.0f\n", price * pointRate);
			}
		} catch (Exception e) {
		}
		try {
			br.close();
		} catch (Exception e) {
		}
		k.close();

	}
}

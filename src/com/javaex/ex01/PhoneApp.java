package com.javaex.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) throws IOException {
		int num;
		boolean begin = true;
		List<Person> phoneDB = new ArrayList<Person>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("****************************************");
		System.out.println("**       전화번호 관리 프로그램       **");
		System.out.println("****************************************");

		Reader rdPhone = new FileReader("./PhoneDB.txt");
		BufferedReader brdPhone = new BufferedReader(rdPhone);
		
		//내부 리스트 저장
		while (true) {
			String str = brdPhone.readLine();
			if (str == null) {
				break;
			}
			String data[] = str.split(",");
			phoneDB.add(new Person(data[0], data[1], data[2]));
		}
		
		while (begin) {
			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
			System.out.print(">메뉴번호:");
			num = sc.nextInt();

			switch (num) {

			case 1:
				System.out.println("<1.리스트>");
				for (Person pp : phoneDB) {
					System.out.printf("%d.   %s     %s   %s\n", phoneDB.lastIndexOf(pp) + 1, pp.getName(), pp.getHp(),
							pp.getCompany());
				}
				break;

			case 2:
				
				Writer wradd = new FileWriter("./PhoneDB.txt");
				BufferedWriter bwradd = new BufferedWriter(wradd);
				
				
				sc.nextLine();
				System.out.println("<2.등록>");
				System.out.print("이름: ");
				String name = sc.nextLine();
				System.out.print("휴대전화: ");
				String hp = sc.nextLine();
				System.out.print("회사전화: ");
				String company = sc.nextLine();

				phoneDB.add(new Person(name, hp, company));

				for (Person pp : phoneDB) {
					bwradd.write(pp.getName() + "," + pp.getHp() + "," + pp.getCompany());
					bwradd.newLine();
					bwradd.flush();
				}
				System.out.println("[등록되었습니다]");
				bwradd.close();
				break;

			case 3:
				
				Writer wrdel = new FileWriter("./PhoneDB.txt");
				BufferedWriter bwrdel = new BufferedWriter(wrdel);

				System.out.println("<3.삭제>");
				System.out.print(">번호: ");
				
				phoneDB.remove(sc.nextInt() - 1);
				
				System.out.println("[삭제되었습니다]");
				for (Person pp : phoneDB) {
					bwrdel.write(pp.getName() + "," + pp.getHp() + "," + pp.getCompany());
					bwrdel.newLine();
					bwrdel.flush();
				}
				bwrdel.close();
				break;

			case 4:
				sc.nextLine();
				System.out.println("<4.검색>");
				System.out.print(">이름: ");
				String search = sc.nextLine();
				for (Person pp : phoneDB) {
					if (pp.getName().contains(search)) {
						System.out.printf("%d.   %s     %s   %s\n", phoneDB.lastIndexOf(pp) + 1, pp.getName(),
								pp.getHp(), pp.getCompany());
					}
				}
				break;

			case 5:
				begin = false;
				break;
			default:
				System.out.println("다시 입력해주세요");
			}

		}

		System.out.println("종료");

		sc.close();
		brdPhone.close();
	}

}
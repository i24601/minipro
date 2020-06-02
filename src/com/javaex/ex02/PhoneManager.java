package com.javaex.ex02;

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

import com.javaex.ex01.Person;

public class PhoneManager {

	private List<Person> pList;
	private Scanner sc;
	private int num;

	public PhoneManager() throws IOException{
		sc = new Scanner(System.in);
		pList = new ArrayList<Person>();

		pList = getList();
	}

	// 시작준비 (시작화면 출려과 리스트 가져온다)
	public void showTitle() {
		System.out.println("****************************************");
		System.out.println("**       전화번호 관리 프로그램       **");
		System.out.println("****************************************");
	}

	// 메뉴 출력과 입력을 받는다.
	public int showMenu() {
		System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
		System.out.print(">메뉴번호:");
		num = sc.nextInt();
		return num;
	}

	// 1.리스트선택시
	public void showList() {
		for (Person pp : pList) {
			System.out.printf("%d.   %s     %s   %s\n", pList.lastIndexOf(pp) + 1, pp.getName(), pp.getHp(),
					pp.getCompany());
		}

	}

	// 2.등록선택시
	public void showAdd() throws IOException{
		Writer wrPhone = new FileWriter("./PhoneDB.txt");
		BufferedWriter bwrPhone = new BufferedWriter(wrPhone);
		sc.nextLine();
		System.out.println("<2.등록>");
		System.out.print("이름: ");
		String name = sc.nextLine();
		System.out.print("휴대전화: ");
		String hp = sc.nextLine();
		System.out.print("회사전화: ");
		String company = sc.nextLine();
		pList.add(new Person(name, hp, company));
		bwrPhone.write(name + "," + hp + "," + company);
		saveList();
		bwrPhone.newLine();
		bwrPhone.flush();
		System.out.println("[등록되었습니다]");
		bwrPhone.close();
	}

	// 3.삭제선택시
	public void showRemove() throws IOException {
		Writer wrPhone = new FileWriter("./PhoneDB.txt");
		BufferedWriter bwrPhone = new BufferedWriter(wrPhone);

		System.out.println("<3.삭제>");
		System.out.print(">번호: ");
		pList.remove(sc.nextInt() - 1);
		System.out.println("[삭제되었습니다]");
		saveList();
		bwrPhone.close();
	}

	// 4.검색선택시
	public void showSearch() {
		sc.nextLine();
		System.out.println("<4.검색>");
		System.out.print(">이름: ");
		String search = sc.nextLine();
		for (Person pp : pList) {
			if (pp.getName().contains(search)) {
				System.out.printf("%d.   %s     %s   %s\n", pList.lastIndexOf(pp) + 1, pp.getName(),
						pp.getHp(), pp.getCompany());
			}
		}
	}

	// 5.종료시
	public void showEnd() {
		System.out.println("****************************************");
		System.out.println("**             감사합니다             **");
		System.out.println("****************************************");
	}

	// 메뉴번호를 잘못 입력시 안내문구를 출력하는 메소드
	public void showEtc() {
		System.out.println("다시 입력해주세요");
	}

	// 파일을 읽어 리스트에 담아 전달한다.
	private List<Person> getList() throws IOException {
		Reader rdPhone = new FileReader("./PhoneDB.txt");
		BufferedReader brdPhone = new BufferedReader(rdPhone);

		while (true) {
			String str = brdPhone.readLine();
			if (str == null) {
				break;
			}
			String data[] = str.split(",");
			pList.add(new Person(data[0], data[1], data[2]));
		}
		brdPhone.close();
		return pList;
	}

	// 리스트를 파일에 저장한다.
	private void saveList() throws IOException {
		System.out.println("실행");
		Writer wradd = new FileWriter("./PhoneDB.txt");
		BufferedWriter bwradd = new BufferedWriter(wradd);
		for (Person pp : pList) {
			bwradd.write(pp.getName() + "," + pp.getHp() + "," + pp.getCompany());
			bwradd.newLine();
			bwradd.flush();
		}
		bwradd.close();
		}
	}



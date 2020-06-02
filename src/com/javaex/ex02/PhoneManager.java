package com.javaex.ex02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.javaex.ex01.Person;

public class PhoneManager {

	private List<Person> pList;
	private Scanner sc;
	private int num;
	public PhoneManager() {
		sc = new Scanner(System.in);
		pList = new ArrayList<Person>();

		pList = getList();
	}

	// 시작준비 (시작화면 출려과 리스트 가져온다)
	public void showTitle() throws IOException{
		System.out.println("****************************************");
		System.out.println("**       전화번호 관리 프로그램       **");
		System.out.println("****************************************");
		
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
		
	}

	// 2.등록선택시
	public void showAdd() {

	}

	// 3.삭제선택시
	public void showRemove() {

	}

	// 4.검색선택시
	public void showSearch() {

	}

	// 5.종료시
	public void showEnd() {

	}
	
	
	// 메뉴번호를 잘못 입력시 안내문구를 출력하는 메소드
	public void showEtc() {

	}
	
	
	// 파일을 읽어 리스트에 담아 전달한다.
	private List<Person> getList() {

	}

	// 리스트를 파일에 저장한다.
	private void saveList() {

	}

	// 전체 리스트를 출력한다
	private void printList() {
		printList("");// 아래 메소드에 키워드값을 비워서 호출
	}

	// 키워드로 검색한 리스트를 출력한다
	private void printList(String keyword) {
		
	}
	
}

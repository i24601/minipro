package com.javaex.ex03;

import java.io.IOException;
import java.util.List;

public class PhoneApp {

	public static void main(String[] args) throws IOException {

		/*
		PhoneView 생성
        화면의 출력, 데이터 입력의 기능을 담당하고 있는 클래스
		*/
		PhoneView phoneView = new PhoneView();
		
		/*
		PhoneRepository 생성
        PhoneDB.txt로 부터 데이터를 가져오고, 저장하고, 삭제하는 등의 기능을
		담당하는 클래스
		*/
		PhoneRepository phoneRepo =  new PhoneRepository();

		
		boolean run = true;
		List<Person> phoneList;
		
		phoneView.showStart();// 프로그램 시작시 안내 문구를 출력하는 메소드

		while (run) {
			int menuNum = phoneView.showMenu();// 메뉴를 출력하고 메뉴번호 입력을 받아 입력된 메뉴번호를 전달하는 메소드

			switch (menuNum){

			case 1:
				phoneList = phoneRepo.getList();
				//phoneDB.txt 파일을 읽어 모든 전화번호(리스트)를 전달하는(pList 생성) 메소드
				phoneView.showList(phoneList);
				break;

			case 2:
				phoneList = phoneRepo.getList();
				Person phoneVO = phoneView.showAdd();
				// 2.등록 : 등록을 위한 화면을 출력하고 사용자가 입력한 데이트를 받아 Person의 인스턴스에 담아 전달하는 메소드
				phoneRepo.addInfo(phoneVO);
				//기존데이터(pList)에 새로입력받은 데이터를 추가하여(pList.add(Person)) 모두저장하는(Write) 메소드 
				phoneView.showAddResult();
				// 등록 완료시 결과 출력 메소드
				break;

			case 3:
				int delNo = phoneView.showDel();
				phoneRepo.delInfo(delNo);
				phoneView.showDelResult();
				break;

			case 4:
				String keyword = phoneView.showSearch();
				phoneList = phoneRepo.getList();
				phoneView.showSearchResult(phoneList, keyword);
				break;

			case 5:
				phoneView.showEnd();
				run = false;
				break;

			default:
				phoneView.showEtc();
				break;
			}// switch

		} // while

	}

}

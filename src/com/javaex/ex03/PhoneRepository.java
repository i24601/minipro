package com.javaex.ex03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class PhoneRepository {
	private List<Person> pList;
    
    //phoneDB.txt 파일을 읽어 모든 전화번호(리스트)를 전달하는 메소드
	public List<Person> getList() throws IOException{
		pList = new ArrayList<Person>();
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

	//phoneDB.txt 에 모든 전화번호 리스트를 저장하는 메소드
	private void saveInfo(List<Person> list) throws IOException{
		
		Writer wradd = new FileWriter("./PhoneDB.txt");
		BufferedWriter bwradd = new BufferedWriter(wradd);
		
		for (Person pp : pList) {
			bwradd.write(pp.getName() + "," + pp.getHp() + "," + pp.getCompany());
			bwradd.newLine();
			bwradd.flush();
		}
		bwradd.close();
		}

	
	//기존데이터에 새로입력받은 데이터를 추가하여 모두저장하는 메소드 
	public void addInfo(Person phoneVO) throws IOException{
		Writer wradd = new FileWriter("./PhoneDB.txt");
		BufferedWriter bwradd = new BufferedWriter(wradd);
		
		pList.add(phoneVO);
		for (Person pp : pList) {
			bwradd.write(pp.getName() + "," + pp.getHp() + "," + pp.getCompany());
			bwradd.newLine();
			bwradd.flush();
		}
		bwradd.close();
	}

	//선택한 번호의 데이터를 삭제하고 저장하는 메소드(모두 다시저장)
	public void delInfo(int num) throws IOException{
		Writer wrRemove = new FileWriter("./PhoneDB.txt");
		BufferedWriter bwrRemove = new BufferedWriter(wrRemove);

		
		pList.remove(num - 1);
		for (Person pp : pList) {
			bwrRemove.write(pp.getName() + "," + pp.getHp() + "," + pp.getCompany());
			bwrRemove.newLine();
			bwrRemove.flush();
		}
		bwrRemove.close();

	}
	

}

package core;

import java.util.ArrayList;
import java.util.List;

import util.CheckDataUtil;

public class AddressBook2 {
	private List<Personal> dataList;
	private Personal personal;

	public AddressBook2() {
		dataList = new ArrayList<Personal>();
		personal = null;
	}

	public List<Personal> getDataList() {
		return dataList;
	}

	/**
	 * データを登録する
	 * @param name
	 * @param zip
	 * @param address
	 */
	public void insert(String name, String zip, String address) {
		personal = new Personal.Builder(name).zip(zip)
											.address(address).build();
		if (!dataList.contains(personal)) {
			dataList.add(personal);
			System.out.println("登録に成功しました");
		} else {
			System.out.println("登録に失敗しました");
		}
	}

	/**
	 * データを更新する
	 * @param name
	 * @param zip
	 * @param address
	 */
	public void updata(String name, String zip, String address) {
		personal = new Personal.Builder(name).zip(zip)
											.address(address).build();
		int index = dataList.indexOf(personal);
		if (index != -1) {
			dataList.set(index, personal);
			System.out.println("更新に成功しました");
		} else {
			System.out.println("更新に失敗しました");
		}
	}

	/**
	 * データを削除する
	 * @param name
	 */
	public void delete(String name) {
		personal = new Personal.Builder(name).build();
		int index = dataList.indexOf(personal);
		if (index != -1) {
			dataList.remove(index);
			System.out.println("削除に成功しました");
		} else {
			System.out.println("削除に失敗しました");
		}
	}

	/**
	 * データを一覧表示する
	 */
	public void show() {
		if (dataList.isEmpty()) {
			System.out.println("データが存在しません");
			return;
		}

		for (Personal personal : dataList) {
			System.out.println("名　　前:" + personal.getName());
			System.out.println("郵便番号:" + CheckDataUtil.addHyphen(personal.getZip()));
			System.out.println("住　　所:" + personal.getAddress() + "\n");
		}
	}
}

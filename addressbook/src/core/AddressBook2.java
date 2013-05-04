package core;

import java.util.ArrayList;
import java.util.List;

import util.CheckDataUtil;

public class AddressBook2 {
	private List<Personal> dataList;
	private Personal personal;

	public AddressBook2() {
		dataList = new ArrayList<Personal>();
	}

	public List<Personal> getDataList() {
		return dataList;
	}

	/**
	 * データを登録する
	 * @param name 名前
	 * @param zip 郵便番号
	 * @param address 住所
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
	 * @param name 名前
	 * @param zip 郵便番号
	 * @param address 住所
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
	 * @param name 名前
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

	public void deleteAll() {
		dataList.clear();
		System.out.println("全件削除しました");
	}

	/**
	 * データを一覧表示する
	 */
	public void showAll() {
		if (dataList.isEmpty()) {
			System.out.println("データが存在しません");
			return;
		}

		for (Personal personal : dataList) {
			this.showOne(personal);
		}
	}

	/**
	 * 名前が一致するデータを検索する
	 * @param name 名前
	 */
	public void search(String name) {
		personal = new Personal.Builder(name).build();
		int index = dataList.indexOf(personal);
		if (index != -1) {
			this.showOne(personal);
		} else {
			System.out.println("データが見つかりません");
		}
	}

	/**
	 * データを一件表示する
	 * @param personal 個人データ
	 */
	private void showOne(Personal personal) {
		System.out.println("名　　前:" + personal.getName());
		System.out.println("郵便番号:" + CheckDataUtil.addHyphen(personal.getZip()));
		System.out.println("住　　所:" + personal.getAddress() + "\n");
	}
}

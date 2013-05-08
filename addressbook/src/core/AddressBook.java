package core;

import java.util.ArrayList;

/**
 * 住所録クラス。
 * このクラスで保存するデータはDataインタフェースを実装し、
 * equalsメソッド・hashCodeメソッドをオーバーライドする必要がある。
 * オーバーライドしていない場合意図しない動作をする可能性がある。
 *
 * @author shin
 *
 */
public class AddressBook {

	private ArrayList<Data> dataList = new ArrayList<Data>();

	/**
	 * 渡されたデータと一致するものがなければデータを登録する
	 * @param data データ
	 * @return 登録に成功すればtrue、そうでなければfalse
	 */
	public boolean insert(Data data) {
		if (dataList.contains(data)) {
			return false;
		}
		dataList.add(data);
		return true;
	}

	/**
	 * 渡されたデータと一致するものがあればデータを更新する
	 * @param data データ
	 * @return 更新に成功すればtrue、そうでなければfalse
	 */
	public boolean update(Data data) {
		if (!dataList.contains(data)) {
			return false;
		}
		int index = dataList.indexOf(data);
		dataList.set(index, data);
		return true;
	}

	/**
	 * 渡されたデータと一致するものがあればデータを削除する
	 * @param data データ
	 * @return 削除に成功すればtrue、そうでなければfalse
	 */
	public boolean delete(Data data) {
		return dataList.remove(data);
	}

	/**
	 * 登録されているデータを全て表示する。
	 * 表示の形式は保存しているデータクラスのshow()メソッドに
	 * 依存する
	 */
	public void show() {
		for (Data data : dataList) {
			data.show();
		}
	}
}

package core;

import java.util.ArrayList;
import java.util.List;

/**
 * 住所録クラス
 * @author shin
 *
 */
public class AddressBook<E> {

	private List<E> dataList;

	public AddressBook() {
		this.dataList = new ArrayList<E>();
	}

	/**
	 * 登録済みデータのリストを返す
	 * @return 登録されているデータリストであるList<E>
	 */
	public List<E> getDataList() {
		return dataList;
	}

	/**
	 * データを登録する。重複している場合は登録しない。
	 * @param data 登録するデータ
	 * @return 登録に成功すればtrue
	 */
	public boolean insert(E data) {
		if (!dataList.contains(data)) {
			dataList.add(data);
			return true;
		}
		return false;
	}

	/**
	 * データを更新する。更新できるデータがない場合は何も行わない。
	 * @param data 更新するデータ
	 * @return 更新に成功すればtrue
	 */
	public boolean update(E data) {
		int index = dataList.indexOf(data);

		if (index != -1) {
			dataList.set(index, data);
			return true;
		}
		return false;
	}

	/**
	 * データを削除する。削除できるデータがない場合は何も行わない。
	 * @param data 削除するデータ
	 * @return 削除に成功すればtrue
	 */
	public boolean delete(E data) {
		int index = dataList.indexOf(data);

		if (index != -1) {
			dataList.remove(index);
			return true;
		}
		return false;
	}
}

package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import core.AddressBook;
import core.Person;

import util.CheckDataUtil;
import util.CommonUtil;

/**
 * 実行クラス
 * @author shin
 *
 */
public class Exec {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		AddressBook ab = new AddressBook();
		boolean roopFlg = true;

		//処理実行部
		while (roopFlg) {
			String input = null;
			try {
				input = br.readLine();
			} catch (IOException e) {
				System.out.println("入出力エラーです");
				break;
			}

			int mode = CheckDataUtil.getMode(input);
			String[] token = null;

			switch (mode) {
				case 0:
					roopFlg = false;
					break;
				case 1:
					token = checkInput(input, CommonUtil.ARRAY_NUM_INSERT);
					if (token.length != 0) {
						Person person = new Person.Builder(token[1]).zip(token[2]).address(token[3]).build();
						ab.insert(person);
					}
					break;
				case 2:
					token = checkInput(input, CommonUtil.ARRAY_NUM_UPDATA);
					if (token.length != 0) {
						Person person = new Person.Builder(token[1]).zip(token[2]).address(token[3]).build();
						ab.update(person);
					}
					break;
				case 3:
					token = checkInput(input, CommonUtil.ARRAY_NUM_DELETE);
					if (token.length != 0) {
						Person person = new Person.Builder(token[1]).build();
						ab.delete(person);
					}
					break;
				case 9:
					if (checkInput(input, CommonUtil.ARRAY_NUM_SHOW_ALL).length != 0) {
						ab.show();
					}
					break;
				default:
					System.out.println("存在しないモード値です");
			}
		}
	}

	/**
	 * 入力された文字列が正しいかチェックする。
	 * 現在の正しい文字列は モード[]名前[]郵便番号[]住所
	 * @param input 入力された文字列
	 * @param arrayNum 望まれる配列数
	 * @return 入力された文字列の各値が正しければ分割した配列、
	 * 正しくない値が存在した場合は空配列を返す
	 */
	public static String[] checkInput(String input, int arrayNum) {
		String[] token = input.split(" ");
		String error = "";

		//配列数チェック
		if (token.length != arrayNum) {
			if (token.length < arrayNum) {
				error += "入力値が足りません";
			} else {
				error += "入力値が多いです";
			}
			System.out.println(error);
			token = new String[0];
			return token;
		}

		//名前チェック
		if (token.length > 2) {
			if (!CheckDataUtil.checkName(token[1])) {
				error += "名前が正しくありません\n";
			}
		}

		//郵便番号チェック
		if (token.length > 3) {
			if (CheckDataUtil.checkZip(token[2])) {
				token[2] = CheckDataUtil.removeHyphen(token[2]);
			} else {
				error += "郵便番号の値が正しくありません\n";
			}
		}

		if (!error.equals("")) {
			System.out.println(error);
			token = new String[0];
			return token;
		}

		return token;
	}
}

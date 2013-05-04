package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import core.AddressBook2;

import util.CheckDataUtil;

public class Exec {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		AddressBook2 ab = new AddressBook2();
		boolean roopFlg = true;

		//処理実行部
		while (roopFlg) {
			String input = null;
			try {
				input = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			int mode = getMode(input);
			String[] token = null;

			switch (mode) {
				case 0:
					roopFlg = false;
					break;
				case 1:
					token = checkInput(input, 4);
					ab.insert(token[1], token[2], token[3]);
					break;
				case 2:
					token = checkInput(input, 4);
					ab.updata(token[1], token[2], token[3]);
					break;
				case 3:
					token = checkInput(input,2);
					ab.delete(token[1]);
					break;
				case 9:
					ab.show();
					break;
				default:
					System.out.println("存在しないモード値です");
			}
		}
	}

	/**
	 * モード値を取得する。
	 * 適切な入力値でない場合は-1を返す。
	 * @param token 入力された文字列
	 * @return
	 */
	public static int getMode(String input) {
		String[] token = input.split(" ");
		if (token.length == 0) {
			return -1;
		}

		if (!CheckDataUtil.checkMode(token[0])) {
			return -1;
		}
		return Integer.parseInt(token[0]);
	}

	/**
	 * 入力された文字列が正しいかチェックする。
	 * 現在の正しい文字列は モード[]名前[]郵便番号[]住所
	 * @param input 入力された文字列
	 * @param arrayNum 望まれる配列数
	 * @return 入力された文字列の各値が正しければ分割した配列、
	 * 正しくない値が存在した場合は空配列
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

		//モード値チェック
		if (!CheckDataUtil.checkMode(token[0])) {
			error += "モード値が正しくありません\n";
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

package util;

/**
 * データチェックユーティリティクラス
 * @author shin
 *
 */
public class CheckDataUtil {

	/**
	 * モード値が数値に変換できる文字列かどうかチェックする。
	 * @param mode モード値
	 * @return 数値に変換できればtrue
	 */
	public static boolean checkMode(String mode) {
		try {
			Integer.parseInt(mode);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	/**
	 * 名前に数値が含まれているかどうかチェックする。
	 * @param name 名前
	 * @return 名前に数値が含まれていなければtrue
	 */
	public static boolean checkName(String name) {
		if (name.matches("\\d+")) {
			return false;
		}
		return true;
	}

	/**
	 * 郵便番号が3桁-4桁、または7桁かチェックする。
	 * @param zip 郵便番号
	 * @return 郵便番号が正しければtrue
	 */
	public static boolean checkZip(String zip) {
		if (zip.matches("\\d{3}-?\\d{4}")) {
			return true;
		}
		return false;
	}

	/**
	 * 郵便番号が3桁-4桁の場合ハイフンを除く。
	 * @param zip 郵便番号
	 * @return ハイフンを除いた7桁の郵便番号。
	 * ハイフンなし7桁の場合は渡された郵便番号をそのまま返す。
	 * @throws IlleagalArgumentException - 郵便番号の値が正しくない場合
	 */
	public static String removeHyphen(String zip) {
		if (!checkZip(zip)) {
			throw new IllegalArgumentException("郵便番号の形式が正しくありません");
		}

		String[] token = zip.split("-");
		String afterZip = "";
		for (String str : token) {
			afterZip += str;
		}
		return afterZip;
	}

	/**
	 * 7桁の郵便番号を3桁-4桁の形に変換する。
	 * @param zip 7桁の郵便番号
	 * @return 3桁-4桁の形式の郵便番号
	 */
	public static String addHyphen(String zip) {
		if (zip == null) {
			throw new NullPointerException("郵便番号の値がnullです");
		} else if (!checkZip(zip)){
			throw new IllegalArgumentException("郵便番号の形式が正しくありません");
		}

		String first = zip.substring(0, 3);
		String latter = zip.substring(3);
		String hyphenExistZip = first + "-" + latter;
		return hyphenExistZip;
	}
}

package core;

/**
 * 個人データクラス。
 * 名前・郵便番号・住所を保持
 * @author shin
 *
 */
public class Person implements Data {
	private String name;			//名前
	private String zip;				//郵便番号
	private String address;			//住所

	public static class Builder {

		//必須パラメータ
		private String name;
		//オプションパラメータ
		private String zip = "";
		private String address = "";

		public Builder(String name) {
			this.name = name;
		}

		public Builder zip(String zip) {
			this.zip = zip;
			return this;
		}

		public Builder address(String address) {
			this.address = address;
			return this;
		}

		public Person build() {
			return new Person(this);
		}
	}

	public Person(Builder builder) {
		this.name = builder.name;
		this.zip = builder.zip;
		this.address = builder.address;
	}

	public String getName() {
	    return name;
	}

	public void setName(String name) {
	    this.name = name;
	}

	public String getZip() {
	    return zip;
	}

	public void setZip(String zip) {
	    this.zip = zip;
	}

	public String getAddress() {
	    return address;
	}

	public void setAddress(String address) {
	    this.address = address;
	}

	/**
	 * データを表示する
	 */
	public void show() {
		System.out.println("名    前:" + this.name);
		System.out.println("郵便番号:" + this.zip);
		System.out.println("住    所:" + this.address + "\n");
	}

	/**
	 * 名前が一致すればtrueを返す。
	 */
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Person))
			return false;
		Person person = (Person)o;
		return person.getName().equals(name);
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}
}

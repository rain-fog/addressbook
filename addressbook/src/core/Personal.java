package core;

/**
 * 個人データクラス
 * @author shin
 *
 */
public class Personal {
	private String name;
	private String zip;
	private String address;

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

		public Personal build() {
			return new Personal(this);
		}
	}

	public Personal(Builder builder) {
		this.name = builder.name;
		this.zip = builder.zip;
		this.address = builder.address;
	}

	/**
	 * nameを取得します。
	 * @return name
	 */
	public String getName() {
	    return name;
	}
	/**
	 * nameを設定します。
	 * @param name name
	 */
	public void setName(String name) {
	    this.name = name;
	}
	/**
	 * zipを取得します。
	 * @return zip
	 */
	public String getZip() {
	    return zip;
	}
	/**
	 * zipを設定します。
	 * @param zip zip
	 */
	public void setZip(String zip) {
	    this.zip = zip;
	}
	/**
	 * addressを取得します。
	 * @return address
	 */
	public String getAddress() {
	    return address;
	}
	/**
	 * addressを設定します。
	 * @param address address
	 */
	public void setAddress(String address) {
	    this.address = address;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Personal))
			return false;
		Personal personal = (Personal)o;
		return personal.getName().equals(name);
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}
}

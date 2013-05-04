package core;

/**
 * 個人データクラス
 * @author shin
 *
 */
public class Personal {
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

		public Personal build() {
			return new Personal(this);
		}
	}

	public Personal(Builder builder) {
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
	 * 名前が一致すればtrueを返す。
	 */
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

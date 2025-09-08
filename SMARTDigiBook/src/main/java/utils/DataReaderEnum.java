package utils;

public enum DataReaderEnum {

	//* paths
	CONF_PATH("./src/main/resources/config.properties"),
	//* production data
	PROD_URL("prod.url"),PROD_USERNAME("prod.username"),PROD_PASSWORD("prod.password"),
	//* uat data
	UAT_URL("uat.url"),UAT_USERNAME("uat.username"),UAT_PASSWORD("uat.password");

	String dataReader;
	private DataReaderEnum(String dataReader) {
		this.dataReader = dataReader;
	}

	public String getDataReader() {
		return dataReader;
	}
}

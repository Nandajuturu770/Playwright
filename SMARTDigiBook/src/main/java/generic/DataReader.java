package generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataReader {

	Properties properties;
	FileInputStream fileInputStream;

	public DataReader(String filePath) throws IOException {
		properties = new Properties();
		fileInputStream = new FileInputStream(filePath);
		this.properties.load(fileInputStream);
	}

	/**
	 * @description this method is used to get value of key.
	 * @param key    <code>String</code>
	 * @return value <code>String</code>
	 */
	public String getValueOfKey(String key) {
		return properties.getProperty(key);
	}
}
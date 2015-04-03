package com.epam.Vadym_Vlasenko.eShop.dataLoader;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.epam.Vadym_Vlasenko.eShop.entity.Product;
import com.epam.Vadym_Vlasenko.eShop.entity.Insert;
import com.epam.Vadym_Vlasenko.eShop.entity.Material;
import com.epam.Vadym_Vlasenko.eShop.entity.Ring;

public class DataLoader {

	private static final String KEY = "Ring";

	private static int cursor;

	private List<Product> list;

	public DataLoader() {
		list = new ArrayList<Product>();
	}

	public List<Product> loadProducts(String filePath) {
		InputStream io = null;
		Properties prop = new Properties();
		try {
			io = new FileInputStream(filePath);
			prop.load(io);
			io.close();
			String key = "Ring";
			int count = 1;
			while (prop.containsKey(key + count + "Id")) {
				list.add(getRing(prop, key + count));
				count++;
				cursor = count;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (io != null) {
				try {
					io.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	public void append(String fileName, Ring ring) {
		InputStream input = null;
		OutputStream output = null;
		Properties prop = new Properties();
		try {
			input = new FileInputStream(fileName);
			prop.load(input);
			output = new FileOutputStream(fileName);
			setRing(prop, ring);
			prop.store(output, "rewrite");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (input != null & output != null) {
				try {
					output.close();
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void setRing(Properties prop, Ring ring) {
		String key = KEY + cursor++;
		prop.setProperty(key + "Id", String.valueOf(ring.getId()));
		prop.setProperty(key + "Description", ring.getDescription());
		prop.setProperty(key + "Insert", ring.getInsert().toString());
		prop.setProperty(key + "Material", ring.getMaterial().toString());
		prop.setProperty(key + "Price", String.valueOf(ring.getPrice()));
		prop.setProperty(key + "Size", String.valueOf(ring.getSize()));
		prop.setProperty(key + "Weight", String.valueOf(ring.getWeight()));
		prop.setProperty(key + "Title", ring.getTitle());
	}

	private Ring getRing(Properties prop, String key) {
		Ring ring = new Ring();
		ring.setId(Integer.parseInt(prop.getProperty(key + "Id")));
		ring.setDescription(prop.getProperty(key + "Description"));
		ring.setInsert(Insert.valueOf(prop.getProperty(key + "Insert")));
		ring.setMaterial(Material.valueOf(prop.getProperty(key + "Material")));
		ring.setPrice(Integer.parseInt(prop.getProperty(key + "Price")));
		ring.setSize(Double.parseDouble(prop.getProperty(key + "Size")));
		ring.setWeight(Double.parseDouble(prop.getProperty(key + "Weight")));
		ring.setTitle(prop.getProperty(key + "Title"));
		return ring;
	}

}

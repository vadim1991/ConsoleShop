package com.epam.Vadym_Vlasenko.eShop.dataLoader;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.epam.Vadym_Vlasenko.eShop.entity.Product;

public class JsonLoader {

	public List<Product> parseJson(String filePath) {
		File file = new File(filePath);
		ObjectMapper objectMapper = new ObjectMapper();
		List<Product> products = null;

		try {
			products = objectMapper.readValue(file,
					new TypeReference<List<Product>>() {
					});
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return products;
	}

	public void toJson(String filePath, List<Product> products) {
		File file = new File(filePath);
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			objectMapper.writeValue(file, products);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

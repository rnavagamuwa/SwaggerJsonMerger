package org.wso2jsonmerger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;
import io.swagger.models.Path;
import io.swagger.models.Model;
import io.swagger.models.Swagger;

import io.swagger.parser.SwaggerParser;

public class merger {
	private static int swaggerCount = 0;

	public static void merge() {
		getCount("inputSwagger");
		if (swaggerCount > 0) {
			Swagger initial = new SwaggerParser().read("inputSwagger/0.json");
			Map<String, Path> paths = null;
			Map<String, Path> tempPaths;
			Map<String, Model> definitions = null;
			Map<String, Model> tempDefinitions;
			paths = initial.getPaths();

			try {
				definitions = initial.getDefinitions();
			} catch (Exception e) {
				// TODO: handle exception
			}

			for (int i = 1; i < swaggerCount; i++) {
				Swagger temp = new SwaggerParser().read("inputSwagger/" + i + ".json");

				tempPaths = temp.getPaths();
				for (Entry<String, Path> entryPath : tempPaths.entrySet()) {
					paths.put(entryPath.getKey(), entryPath.getValue());
				}

				try {
					tempDefinitions = temp.getDefinitions();
					for (Entry<String, Model> entryDef : tempDefinitions.entrySet()) {
						definitions.put(entryDef.getKey(), entryDef.getValue());
					}
				} catch (Exception e) {
					// TODO: handle exception
				}

			}

			initial.setPaths(paths);
			initial.setDefinitions(definitions);
			Gson gson = new Gson();
			String json = gson.toJson(initial);

			try {
				// write converted json data to a file named "file.json"
				FileWriter writer = new FileWriter("swagger.json");
				writer.write(json);
				writer.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private static void getCount(String dirPath) {
		File f = new File(dirPath);
		File[] files = f.listFiles();

		if (files != null)
			for (int i = 0; i < files.length; i++) {
				swaggerCount++;
				File file = files[i];

				if (file.isDirectory()) {
					getCount(file.getAbsolutePath());
				}
			}
	}
}
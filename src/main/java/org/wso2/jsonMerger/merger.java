package org.wso2.jsonMerger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.wordnik.swagger.models.Model;
import com.wordnik.swagger.models.Path;
import com.wordnik.swagger.models.Swagger;

import io.swagger.parser.SwaggerParser;

public class merger {
	public static void merge(String basePath, int swaggerCount) {
		Swagger initial = new SwaggerParser().read(basePath + "0.json");
		Map<String, Path> paths = null;
		Map<String, Path> tempPaths;
		Map<String, Model> definitions = null;
		Map<String, Model> tempDefinitions;
		
		for(int i=1;i<swaggerCount;i++){
			Swagger temp = new SwaggerParser().read(basePath+i+".json");

			paths = initial.getPaths();
			tempPaths = temp.getPaths();
			for (Entry<String, Path> entryPath : tempPaths.entrySet()) {
				paths.put(entryPath.getKey(), entryPath.getValue());
			}

			definitions = initial.getDefinitions();
			tempDefinitions = temp.getDefinitions();
			for (Entry<String, Model> entryDef : tempDefinitions.entrySet()) {
				definitions.put(entryDef.getKey(), entryDef.getValue());
			}
		}
		
		initial.setPaths(paths);
		initial.setDefinitions(definitions);
		Gson gson = new Gson();
		String json = gson.toJson(initial);

		try {
			// write converted json data to a file named "file.json"
			FileWriter writer = new FileWriter("file.json");
			writer.write(json);
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

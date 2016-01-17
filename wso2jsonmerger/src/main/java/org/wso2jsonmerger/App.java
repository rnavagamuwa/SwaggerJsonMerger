package org.wso2jsonmerger;

import com.google.gson.Gson;
import io.swagger.models.Swagger;
import io.swagger.parser.SwaggerParser;
public class App 
{
    public static void main( String[] args )
    {
        merger.merge();
//    	Swagger initial = new SwaggerParser().read("inputSwagger/0.json");
//    	System.out.print(initial.getDefinitions().get("Pet"));
    }
}

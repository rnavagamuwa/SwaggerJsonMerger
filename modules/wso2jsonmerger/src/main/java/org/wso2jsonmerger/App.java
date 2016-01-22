package org.wso2jsonmerger;

import com.sun.media.sound.SimpleSoundbank;
import io.swagger.models.Swagger;
import io.swagger.parser.SwaggerParser;

import java.io.File;

public class App
{
    public static void main( String[] args )
    {

        merger.merge();
//        Swagger initial = new SwaggerParser().read(Constants.INPUT_PATH + File.separator + "0.json");
//        System.out.println(initial.getDefinitions().get("User").getProperties().get("id").getTitle());
    }
}

package org.wso2jsonmerger;

import java.io.File;

/**
 * Created by randika on 1/19/16.
 */
public final class Constants {
    public static final String BASE_PATH =new File("").toURI().getPath();
    public static final String INPUT_PATH=BASE_PATH +"modules"+ File.separator + "wso2jsonmerger"+File.separator+"inputSwagger";
    public static final String OUTPUT_PATH=BASE_PATH + "distribution";
}

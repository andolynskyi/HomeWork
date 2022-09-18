package utilities;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReaderTXTFile {

//    private static Properties properties = new Properties();
//
//    public static String readText(String fileName) {
//
//        String path = "src/test/resources/bodies/" + fileName;
//
//        try {
//
//            FileInputStream file = new FileInputStream(path);
//            properties.load(file);
//            file.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("File not found");
//        }
//
//        return properties.toString();
//
//    }



    private static String filePath;
    static FileReader fileReader;
    static BufferedReader bufferedReader;

    public static String readTXT(String fileName) {
        filePath = fileName;

        String body = "";

        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.ready()) {
                body += bufferedReader.readLine();
            }
        } catch (Exception e) {
        }
        return body;
    }


}

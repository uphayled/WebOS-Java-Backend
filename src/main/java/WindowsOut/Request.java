package WindowsOut;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Request implements Serializable {


    private String   name;
    private String   location;
    private String   results;
    public String   basecase="error";

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    private Gson gson = new Gson();

    public Request( String loc) {
        this.name=(loc.split("/"))[loc.split("/").length-1];
        this.location=loc;
    }

    public String returnRequest(){
        return results;
    }
    public String getFile(){
        return gson.toJson(new File(this.location));
    }

    public String getDir(){
        List<File> lf = new ArrayList<File>(Arrays.asList(new File(location).listFiles()));
        System.out.println(lf);

       /* try (Stream<Path> paths = Files.walk(Paths.get("C:/Users/Alex/Desktop"))) {
            paths.forEach(System.out::println);
                    //.filter(Files::isRegularFile)
                   // .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return gson.toJson(lf);
    }

    /**//**//**//**//**//**//**//**//**//**//**//**//**//**//**/
    /**//*    Getters & Setters
    /**//*
    /**//**//**//**//**//**//**//**//**//**//**//**//**//**//**/


    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    private void setLocation(String location) {
        this.location = location;
    }
}

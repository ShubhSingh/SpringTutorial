package tutorial7.autowirebytype.annotationbased.beans;

import org.springframework.stereotype.Component;

import tutorial7.autowirebytype.annotationbased.interfaces.LogWriter;

@Component
public class FileWriter implements LogWriter {

    public void write(String text) {
        System.out.println("Write to a file: " + text);
    }
}

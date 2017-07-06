package tutorial7.autowirebytype.annotationbased.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Logger {

    private ConsoleWriter consoleWriter;
    private FileWriter fileWriter;

    @Autowired
    public void setConsoleWriter(ConsoleWriter consoleWriter) {
        this.consoleWriter = consoleWriter;
    }

    @Autowired
    public void setFileWriter(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    public void writeConsole(String text) {
        if(consoleWriter != null) {
            consoleWriter.write(text);
        }
    }

    public void writeFile(String text) {
        fileWriter.write(text);
    }

    @PostConstruct
    public void init() {
        System.out.println("After initializing logger");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Before destroying logger");
    }
}

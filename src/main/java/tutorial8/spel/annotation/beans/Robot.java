package tutorial8.spel.annotation.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Robot {

    @Value("#{randomText.getText()?.length()}")
    private String id;
    @Value("#{randomText.getText()}")
    private String speech;
    @Value("#{new java.util.Date().toString()}")
    private String textDate;
    @Value("#{new java.util.Date()}")
    private Date date;
    @Value("#{T(Math).PI}")
    private String numberPI;
    @Value("#{T(Math).sin(90)}")
    private double sinFunction;
    @Value("#{T(Math).sin(T(Math).PI/4)^2 lt 0.8}")
    boolean result;

    public void setId(String id) {
        this.id = id;
    }

    public void setSpeech(String speech) {
        this.speech = speech;
    }

    public void speak() {
        System.out.println(date + " -- " + id + ": " + speech);
    }

    public void talk() {
        System.out.println("Static field : " + numberPI + "\nStatic method : " + sinFunction +"\n" + result);
    }
}

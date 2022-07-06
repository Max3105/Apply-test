package sample.objects;

import javafx.beans.property.SimpleStringProperty;

import java.sql.Date;
import java.time.LocalDate;

public class Human {
    private String name;
    private String age;
    private Date birthday;

    public Human(String name3, String s, LocalDate date) {

    }


    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getAge(){
        return age;
    }
    public void setAge(String age){
        this.age = age;
    }
    public Date getBirthday(){
        return birthday;
    }
    public void setBirthday(Date birthday){
        this.birthday = birthday;
    }

}

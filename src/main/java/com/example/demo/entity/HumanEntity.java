package com.example.demo.entity;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "human", schema = "humans")
public class
HumanEntity {
    private int humanId;
    private String name;
    private Integer age;
    private Date birthdate;

    @Id
    @Column(name = "human_id", nullable = false)
    public int getHumanId() {
        return humanId;
    }

    public void setHumanId(int humanId) {
        this.humanId = humanId;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "birthdate", nullable = true)
    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setBirthdate(String birthdate) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.birthdate = formatter.parse(birthdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Basic
    @Column(name = "age", nullable = true)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HumanEntity that = (HumanEntity) o;
        return humanId == that.humanId &&
                Objects.equals(name, that.name) &&
                Objects.equals(birthdate, that.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(humanId, name, birthdate);
    }

    @Override
    public String toString() {
        return "HumanEntity{" +
                "humanId=" + humanId +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }

    public HumanEntity() {
    }

    public HumanEntity(Human human) {
        this.name = human.getName();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        this.age = human.getAge();
        this.birthdate = human.getBirthday();
    }
}

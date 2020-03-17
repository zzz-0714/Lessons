package org.zzz.lesson.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.zzz.lesson.core.enums.Sex;

import java.io.Serializable;

@Getter
@Setter
public class Hello implements Serializable {

    private String name;

    private int age;

    private Sex sex;

    @Override
    public String toString() {
        return Hello.class.getSimpleName() +
                "[" +
                "name=" + name + "," +
                "age=" + age + "," +
                "sex=" + sex +
                "]";
    }
}

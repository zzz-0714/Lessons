package org.zzz.lesson.s.b.properties.autoconfigure;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutoCommunicationClient {

    private String name;

    private int age;

    public String sayHello() {
        return "This is " + name + ", I'm " + age + " old";
    }

}

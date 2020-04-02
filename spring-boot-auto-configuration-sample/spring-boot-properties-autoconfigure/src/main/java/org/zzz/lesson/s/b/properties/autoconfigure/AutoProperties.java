package org.zzz.lesson.s.b.properties.autoconfigure;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

@Getter
@Setter
@ConfigurationProperties(prefix = "auto.p")
public class AutoProperties implements Serializable {

    private static final long serialVersionUID = -1L;

    private String name;

    private int age;

}

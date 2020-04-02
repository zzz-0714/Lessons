package org.zzz.lesson.s.b.properties.autoconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(AutoProperties.class)
public class PropertiesAutoConfiguration {


    @Configuration
    public static class CommunicationClientConfiguration {

        @Autowired
        private AutoProperties autoProperties;

        @Bean
        @ConditionalOnMissingBean
        public AutoCommunicationClient autoCommunicationClient() {
            AutoCommunicationClient client = new AutoCommunicationClient();
            client.setName(autoProperties.getName());
            client.setAge(autoProperties.getAge());
            return client;
        }
    }
}

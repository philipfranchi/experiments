package com.philipfranchi.springConfigurationProperties;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties
public class TestConfig {

    @Bean
    public CloudFormationBeanFactoryPostProcessor cloudFormationBeanFactoryPostProcessor() {
        return new CloudFormationBeanFactoryPostProcessor();
    }

    @Bean
    public S3BeanFactoryPostProcessor s3BeanFactoryPostProcessor() {
        return new S3BeanFactoryPostProcessor();
    }

    @Bean
    public S3Properties s3Properties() {
        return new S3Properties();
    }
}

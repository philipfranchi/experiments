package com.philipfranchi.springConfigurationProperties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

public class CloudFormationBeanFactoryPostProcessor implements
        PriorityOrdered, EnvironmentAware, BeanFactoryPostProcessor {

    private Environment environment;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        if(!(environment instanceof ConfigurableEnvironment)) {
            return;
        }

        ConfigurableEnvironment configurableEnvironment = (ConfigurableEnvironment)environment;

        Map<String,Object> props = new HashMap<>();
        props.put("stackName", "HELLO WORLD");
        configurableEnvironment.getPropertySources().addFirst(new MapPropertySource("CF", props));
    }


    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE ;
    }
}

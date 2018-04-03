package com.philipfranchi.springconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubContentConfig {

    @Autowired
    private AppProps props;

    @Bean
    public SubContentModule module(AppProps props) {
        return new SubContentModule(props.getBar());
    }
}

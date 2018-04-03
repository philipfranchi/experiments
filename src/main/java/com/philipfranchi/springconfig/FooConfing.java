package com.philipfranchi.springconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(SubContentConfig.class)
public class FooConfing {

    @Bean
    public Foo foo(SubContentModule subContentModule) {
        return new Foo(subContentModule);
    }

    @Bean
    public AppProps appProps() {
        AppProps props = new AppProps();
        props.setBar("TEST");
        return props;
    }
}

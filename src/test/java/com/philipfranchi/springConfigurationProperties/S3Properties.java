package com.philipfranchi.springConfigurationProperties;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("testS3")
@NoArgsConstructor
@Data
public class S3Properties {
    private String dummy;
}

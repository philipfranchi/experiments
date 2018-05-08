package com.philipfranchi.springConfigurationProperties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@Import(TestConfig.class)
public class TestConfigTest {

    @Autowired
    private S3Properties s3Properties;

    @Test
    public void s3PropertiesWasSuccessfullyPopulated() {
        assertEquals("HELLO WORLD!", s3Properties.getDummy());
    }

}

package com.philipfranchi.pebble;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.error.PebbleException;
import com.mitchellbosecke.pebble.lexer.Syntax;
import com.mitchellbosecke.pebble.loader.StringLoader;
import com.mitchellbosecke.pebble.template.PebbleTemplate;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class PebbleTest {
    private static Logger LOGGER = LoggerFactory.getLogger(PebbleTest.class);

    @Test
    public void PebbleTest() throws PebbleException, IOException {
        Syntax.Builder syntaxBuilder = new Syntax.Builder();
        syntaxBuilder.setPrintOpenDelimiter("{{{");
        syntaxBuilder.setPrintCloseDelimiter("}}}");

        PebbleEngine pebbleEngine = new PebbleEngine.Builder()
                .loader(new StringLoader())
                .newLineTrimming(false)
                .autoEscaping(true)
                .defaultEscapingStrategy("js")
                .syntax(syntaxBuilder.build())
                .build();

        PebbleTemplate template = pebbleEngine.getTemplate("{{{test}}}");
        StringWriter writer = new StringWriter();
        Map<String, Object> context = new HashMap<>();
        context.put("test", "Hello world!");
        template.evaluate(writer, context);
        assertEquals("Hello world!", writer.toString());
    }
}

// ********RoostGPT********
/*
Test generated by RoostGPT for test pomXmlTest using AI Type Open AI and AI Model gpt-4

1. Scenario: Test if the method successfully retrieves a configuration property when a valid key is provided.
   - Given a valid key that exists in the configuration properties file
   - When the method `produceConfigProperty` is called with this key
   - Then the method should return the corresponding value from the configuration properties file.

2. Scenario: Test if the method returns null when an invalid key is provided.
   - Given an invalid key that does not exist in the configuration properties file
   - When the method `produceConfigProperty` is called with this key
   - Then the method should return null.

3. Scenario: Test if the method handles a null key properly.
   - Given a null key
   - When the method `produceConfigProperty` is called with this key
   - Then the method should return null or throw an appropriate exception, depending on the business logic.

4. Scenario: Test if the method handles an empty key properly.
   - Given an empty key
   - When the method `produceConfigProperty` is called with this key
   - Then the method should return null or throw an appropriate exception, depending on the business logic.

5. Scenario: Test if the method handles keys with leading and trailing whitespaces properly.
   - Given a key with leading and/or trailing whitespaces that exists in the configuration properties file
   - When the method `produceConfigProperty` is called with this key
   - Then the method should return the corresponding value from the configuration properties file.

6. Scenario: Test if the method handles case-sensitive keys properly.
   - Given a key in a different case that exists in the configuration properties file
   - When the method `produceConfigProperty` is called with this key
   - Then the method should return the corresponding value from the configuration properties file if the properties file is not case-sensitive, or null if it is case-sensitive.

7. Scenario: Test if the method behaves correctly when the properties file is unavailable or unable to be read.
   - Given a valid key
   - When the properties file is unavailable or unable to be read, and the method `produceConfigProperty` is called with this key
   - Then the method should return null or throw an appropriate exception, depending on the business logic.
*/

// ********RoostGPT********
package org.agoncal.application.petstore.util;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.enterprise.inject.spi.InjectionPoint;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

public class ConfigPropertyProducer_produceConfigProperty_5b9fee6055_Test {

    @InjectMocks
    private ConfigPropertyProducer configPropertyProducer;

    @Mock
    private InjectionPoint ip;

    @Mock
    private static Properties props;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testProduceConfigProperty_ValidKey() {
        when(ip.getAnnotated().getAnnotation(ConfigProperty.class).value()).thenReturn("validKey");
        when(props.getProperty("validKey")).thenReturn("validValue");
        String value = configPropertyProducer.produceConfigProperty(ip);
        assertEquals("validValue", value);
    }

    @Test
    public void testProduceConfigProperty_InvalidKey() {
        when(ip.getAnnotated().getAnnotation(ConfigProperty.class).value()).thenReturn("invalidKey");
        when(props.getProperty("invalidKey")).thenReturn(null);
        String value = configPropertyProducer.produceConfigProperty(ip);
        assertNull(value);
    }

    @Test
    public void testProduceConfigProperty_NullKey() {
        when(ip.getAnnotated().getAnnotation(ConfigProperty.class).value()).thenReturn(null);
        String value = configPropertyProducer.produceConfigProperty(ip);
        assertNull(value);
    }

    @Test
    public void testProduceConfigProperty_EmptyKey() {
        when(ip.getAnnotated().getAnnotation(ConfigProperty.class).value()).thenReturn("");
        String value = configPropertyProducer.produceConfigProperty(ip);
        assertNull(value);
    }

    @Test
    public void testProduceConfigProperty_WhitespaceKey() {
        when(ip.getAnnotated().getAnnotation(ConfigProperty.class).value()).thenReturn(" whitespaceKey ");
        when(props.getProperty(" whitespaceKey ")).thenReturn("whitespaceValue");
        String value = configPropertyProducer.produceConfigProperty(ip);
        assertEquals("whitespaceValue", value);
    }

    @Test
    public void testProduceConfigProperty_CaseSensitiveKey() {
        when(ip.getAnnotated().getAnnotation(ConfigProperty.class).value()).thenReturn("caseSensitiveKey");
        when(props.getProperty("caseSensitiveKey")).thenReturn("caseSensitiveValue");
        String value = configPropertyProducer.produceConfigProperty(ip);
        assertEquals("caseSensitiveValue", value);
    }

    @Test(expected = IOException.class)
    public void testProduceConfigProperty_FileUnavailable() throws IOException {
        when(ip.getAnnotated().getAnnotation(ConfigProperty.class).value()).thenReturn("validKey");
        when(props.getProperty("validKey")).thenThrow(new IOException());
        configPropertyProducer.produceConfigProperty(ip);
    }
}

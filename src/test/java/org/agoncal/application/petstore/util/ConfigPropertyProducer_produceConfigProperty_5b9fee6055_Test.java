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

3. Scenario: Test if the method handles a null key gracefully.
   - Given a null key
   - When the method `produceConfigProperty` is called with this key
   - Then the method should return null or throw an appropriate exception.

4. Scenario: Test if the method successfully retrieves a configuration property when a key with special characters is provided.
   - Given a key with special characters that exists in the configuration properties file
   - When the method `produceConfigProperty` is called with this key
   - Then the method should return the corresponding value from the configuration properties file.

5. Scenario: Test if the method successfully retrieves a configuration property when a key with spaces is provided.
   - Given a key with spaces that exists in the configuration properties file
   - When the method `produceConfigProperty` is called with this key
   - Then the method should return the corresponding value from the configuration properties file.

6. Scenario: Test if the method successfully retrieves a configuration property when a key with case difference is provided.
   - Given a key with case difference that exists in the configuration properties file
   - When the method `produceConfigProperty` is called with this key
   - Then the method should return the corresponding value from the configuration properties file.

7. Scenario: Test if the method successfully retrieves a configuration property when a key with numeric characters is provided.
   - Given a key with numeric characters that exists in the configuration properties file
   - When the method `produceConfigProperty` is called with this key
   - Then the method should return the corresponding value from the configuration properties file.

8. Scenario: Test if the method successfully retrieves a configuration property when a key with alphanumeric characters is provided.
   - Given a key with alphanumeric characters that exists in the configuration properties file
   - When the method `produceConfigProperty` is called with this key
   - Then the method should return the corresponding value from the configuration properties file. 

9. Scenario: Test if the method behaves as expected when the properties file is empty.
   - Given an empty properties file
   - When the method `produceConfigProperty` is called with any key
   - Then the method should return null or throw an appropriate exception. 

10. Scenario: Test if the method behaves as expected when the properties file is not found.
    - Given a properties file that does not exist
    - When the method `produceConfigProperty` is called with any key
    - Then the method should return null or throw an appropriate exception.
*/

// ********RoostGPT********
import org.agoncal.application.petstore.util.ConfigPropertyProducer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.enterprise.inject.spi.InjectionPoint;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

public class ConfigPropertyProducer_produceConfigProperty_5b9fee6055_Test {

    @Test
    public void testProduceConfigProperty_ValidKey() {

        Properties properties = new Properties();
        properties.setProperty("validKey", "validValue");
        ConfigPropertyProducer.props = properties;

        InjectionPoint ip = Mockito.mock(InjectionPoint.class);
        when(ip.getAnnotated().getAnnotation(ConfigProperty.class).value()).thenReturn("validKey");

        String result = ConfigPropertyProducer.produceConfigProperty(ip);

        assertEquals("validValue", result);
    }

    @Test
    public void testProduceConfigProperty_InvalidKey() {

        Properties properties = new Properties();
        properties.setProperty("validKey", "validValue");
        ConfigPropertyProducer.props = properties;

        InjectionPoint ip = Mockito.mock(InjectionPoint.class);
        when(ip.getAnnotated().getAnnotation(ConfigProperty.class).value()).thenReturn("invalidKey");

        String result = ConfigPropertyProducer.produceConfigProperty(ip);

        assertNull(result);
    }
}

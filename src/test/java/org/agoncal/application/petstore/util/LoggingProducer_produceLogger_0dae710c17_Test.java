// ********RoostGPT********
/*
Test generated by RoostGPT for test pomXmlTest using AI Type Open AI and AI Model gpt-4

1. Scenario: Verify if the Logger instance is correctly produced when a valid InjectionPoint is provided
   - Given a valid InjectionPoint instance
   - When the produceLogger method is called with this instance
   - Then the method should return a Logger instance with the name set as the declaring class of the InjectionPoint's member

2. Scenario: Check if the Logger instance is null when a null InjectionPoint is provided
   - Given a null InjectionPoint instance
   - When the produceLogger method is called with this instance
   - Then the method should throw a NullPointerException

3. Scenario: Verify if the Logger instance is correctly produced when an InjectionPoint with a member from an anonymous class is provided
   - Given an InjectionPoint instance whose member is from an anonymous class
   - When the produceLogger method is called with this instance
   - Then the method should return a Logger instance with the name set as the anonymous class's name

4. Scenario: Verify if the Logger instance is correctly produced when an InjectionPoint with a member from a nested class is provided
   - Given an InjectionPoint instance whose member is from a nested class
   - When the produceLogger method is called with this instance
   - Then the method should return a Logger instance with the name set as the nested class's name

5. Scenario: Verify if the Logger instance is correctly produced when an InjectionPoint with a member from a default package class is provided
   - Given an InjectionPoint instance whose member is from a class in the default package
   - When the produceLogger method is called with this instance
   - Then the method should return a Logger instance with the name set as the class's name

6. Scenario: Verify if the Logger instance is correctly produced when an InjectionPoint with a member from a class in a named package is provided
   - Given an InjectionPoint instance whose member is from a class in a named package
   - When the produceLogger method is called with this instance
   - Then the method should return a Logger instance with the name set as the fully qualified class name

7. Scenario: Check if the Logger instance is unique for each distinct InjectionPoint
   - Given two distinct InjectionPoint instances
   - When the produceLogger method is called with each instance separately
   - Then the method should return two different Logger instances
*/

// ********RoostGPT********
package org.agoncal.application.petstore.util;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.enterprise.inject.spi.InjectionPoint;
import java.lang.reflect.Member;
import java.util.logging.Logger;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class LoggingProducer_produceLogger_0dae710c17_Test {
    @Mock private InjectionPoint mockInjectionPoint;
    @Mock private Member mockMember;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testProduceLogger_ValidInjectionPoint() {
        when(mockInjectionPoint.getMember()).thenReturn(mockMember);
        when(mockMember.getDeclaringClass()).thenReturn(LoggingProducer.class);

        LoggingProducer producer = new LoggingProducer();
        Logger logger = producer.produceLogger(mockInjectionPoint);

        assertNotNull(logger);
        assertEquals(LoggingProducer.class.getName(), logger.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testProduceLogger_NullInjectionPoint() {
        LoggingProducer producer = new LoggingProducer();
        producer.produceLogger(null);
    }

    @Test
    public void testProduceLogger_AnonymousClass() {
        when(mockInjectionPoint.getMember()).thenReturn(mockMember);
        when(mockMember.getDeclaringClass()).thenReturn(new Object() {}.getClass());

        LoggingProducer producer = new LoggingProducer();
        Logger logger = producer.produceLogger(mockInjectionPoint);

        assertNotNull(logger);
    }

    @Test
    public void testProduceLogger_NestedClass() {
        class NestedClass { }

        when(mockInjectionPoint.getMember()).thenReturn(mockMember);
        when(mockMember.getDeclaringClass()).thenReturn(NestedClass.class);

        LoggingProducer producer = new LoggingProducer();
        Logger logger = producer.produceLogger(mockInjectionPoint);

        assertNotNull(logger);
        assertEquals(NestedClass.class.getName(), logger.getName());
    }

    @Test
    public void testProduceLogger_DefaultPackageClass() {
        when(mockInjectionPoint.getMember()).thenReturn(mockMember);
        when(mockMember.getDeclaringClass()).thenReturn(String.class);

        LoggingProducer producer = new LoggingProducer();
        Logger logger = producer.produceLogger(mockInjectionPoint);

        assertNotNull(logger);
        assertEquals(String.class.getName(), logger.getName());
    }

    @Test
    public void testProduceLogger_NamedPackageClass() {
        when(mockInjectionPoint.getMember()).thenReturn(mockMember);
        when(mockMember.getDeclaringClass()).thenReturn(LoggingProducer.class);

        LoggingProducer producer = new LoggingProducer();
        Logger logger = producer.produceLogger(mockInjectionPoint);

        assertNotNull(logger);
        assertEquals(LoggingProducer.class.getName(), logger.getName());
    }

    @Test
    public void testProduceLogger_UniqueLoggerInstances() {
        when(mockInjectionPoint.getMember()).thenReturn(mockMember);
        when(mockMember.getDeclaringClass()).thenReturn(LoggingProducer.class);

        LoggingProducer producer = new LoggingProducer();
        Logger logger1 = producer.produceLogger(mockInjectionPoint);
        Logger logger2 = producer.produceLogger(mockInjectionPoint);

        assertNotSame(logger1, logger2);
    }
}

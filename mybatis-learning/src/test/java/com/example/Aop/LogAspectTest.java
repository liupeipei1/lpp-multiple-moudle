package com.example.Aop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {LogAspect.class})
@ExtendWith(SpringExtension.class)
class LogAspectTest {
    @Autowired
    private LogAspect logAspect;

    /**
     * Method under test: {@link LogAspect#doBefore()}
     */
    @Test
    void testDoBefore() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   There are no fields that could be asserted on.

        this.logAspect.doBefore();
    }

    /**
     * Method under test: {@link LogAspect#doAfter()}
     */
    @Test
    void testDoAfter() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   There are no fields that could be asserted on.

        this.logAspect.doAfter();
    }

    /**
     * Method under test: {@link LogAspect#logArround(org.aspectj.lang.ProceedingJoinPoint)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLogArround() throws Throwable {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.Aop.LogAspect.logArround(LogAspect.java:43)
        //   In order to prevent logArround(ProceedingJoinPoint)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   logArround(ProceedingJoinPoint).
        //   See https://diff.blue/R013 to resolve this issue.

        this.logAspect.logArround(null);
    }

    /**
     * Method under test: {@link LogAspect#logArround(ProceedingJoinPoint)}
     */
    @Test
    void testLogArround2() throws Throwable {
        ProceedingJoinPoint proceedingJoinPoint = mock(ProceedingJoinPoint.class);
        when(proceedingJoinPoint.proceed()).thenReturn("Proceed");
        when(proceedingJoinPoint.getSignature()).thenReturn(null);
        when(proceedingJoinPoint.getArgs()).thenReturn(new Object[]{"Args"});
        assertEquals("Proceed", this.logAspect.logArround(proceedingJoinPoint));
        verify(proceedingJoinPoint).proceed();
        verify(proceedingJoinPoint).getArgs();
        verify(proceedingJoinPoint).getSignature();
    }

    /**
     * Method under test: {@link LogAspect#logArround(ProceedingJoinPoint)}
     */
    @Test
    void testLogArround3() throws Throwable {
        ProceedingJoinPoint proceedingJoinPoint = mock(ProceedingJoinPoint.class);
        when(proceedingJoinPoint.proceed()).thenThrow(new Throwable());
        when(proceedingJoinPoint.getSignature()).thenReturn(null);
        when(proceedingJoinPoint.getArgs()).thenReturn(new Object[]{"Args"});
        assertThrows(Throwable.class, () -> this.logAspect.logArround(proceedingJoinPoint));
        verify(proceedingJoinPoint).proceed();
        verify(proceedingJoinPoint).getArgs();
        verify(proceedingJoinPoint).getSignature();
    }

    /**
     * Method under test: {@link LogAspect#logArround(ProceedingJoinPoint)}
     */
    @Test
    void testLogArround4() throws Throwable {
        ProceedingJoinPoint proceedingJoinPoint = mock(ProceedingJoinPoint.class);
        when(proceedingJoinPoint.proceed()).thenReturn("环绕后");
        when(proceedingJoinPoint.getSignature()).thenReturn(null);
        when(proceedingJoinPoint.getArgs()).thenReturn(new Object[]{"Args"});
        assertEquals("环绕后", this.logAspect.logArround(proceedingJoinPoint));
        verify(proceedingJoinPoint).proceed();
        verify(proceedingJoinPoint).getArgs();
        verify(proceedingJoinPoint).getSignature();
    }

    /**
     * Method under test: {@link LogAspect#logArround(ProceedingJoinPoint)}
     */
    @Test
    void testLogArround5() throws Throwable {
        ProceedingJoinPoint proceedingJoinPoint = mock(ProceedingJoinPoint.class);
        when(proceedingJoinPoint.proceed()).thenReturn(42);
        when(proceedingJoinPoint.getSignature()).thenReturn(null);
        when(proceedingJoinPoint.getArgs()).thenReturn(new Object[]{"Args"});
        this.logAspect.logArround(proceedingJoinPoint);
        verify(proceedingJoinPoint).proceed();
        verify(proceedingJoinPoint).getArgs();
        verify(proceedingJoinPoint).getSignature();
    }

    /**
     * Method under test: {@link LogAspect#logArround(ProceedingJoinPoint)}
     */
    @Test
    void testLogArround6() throws Throwable {
        ProceedingJoinPoint proceedingJoinPoint = mock(ProceedingJoinPoint.class);
        when(proceedingJoinPoint.proceed()).thenReturn(-1);
        when(proceedingJoinPoint.getSignature()).thenReturn(null);
        when(proceedingJoinPoint.getArgs()).thenReturn(new Object[]{"Args"});
        this.logAspect.logArround(proceedingJoinPoint);
        verify(proceedingJoinPoint).proceed();
        verify(proceedingJoinPoint).getArgs();
        verify(proceedingJoinPoint).getSignature();
    }

    /**
     * Method under test: {@link LogAspect#logArround(ProceedingJoinPoint)}
     */
    @Test
    void testLogArround7() throws Throwable {
        ProceedingJoinPoint proceedingJoinPoint = mock(ProceedingJoinPoint.class);
        when(proceedingJoinPoint.proceed()).thenReturn(Integer.MIN_VALUE);
        when(proceedingJoinPoint.getSignature()).thenReturn(null);
        when(proceedingJoinPoint.getArgs()).thenReturn(new Object[]{"Args"});
        this.logAspect.logArround(proceedingJoinPoint);
        verify(proceedingJoinPoint).proceed();
        verify(proceedingJoinPoint).getArgs();
        verify(proceedingJoinPoint).getSignature();
    }

    /**
     * Method under test: {@link LogAspect#logArround(ProceedingJoinPoint)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLogArround8() throws Throwable {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
        //       at com.example.Aop.LogAspect.logArround(LogAspect.java:44)
        //   In order to prevent logArround(ProceedingJoinPoint)
        //   from throwing ArrayIndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   logArround(ProceedingJoinPoint).
        //   See https://diff.blue/R013 to resolve this issue.

        ProceedingJoinPoint proceedingJoinPoint = mock(ProceedingJoinPoint.class);
        when(proceedingJoinPoint.proceed()).thenReturn("Proceed");
        when(proceedingJoinPoint.getSignature()).thenReturn(null);
        when(proceedingJoinPoint.getArgs()).thenReturn(new Object[]{});
        this.logAspect.logArround(proceedingJoinPoint);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link LogAspect}
     *   <li>{@link LogAspect#apilog()}
     * </ul>
     */
    @Test
    void testConstructor() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   There are no fields that could be asserted on.

        (new LogAspect()).apilog();
    }
}


package org.yaoyao.statsd.proxy;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.yaoyao.statsd.client.StatsdClient;

import java.io.IOException;

public class Test {
    @Rule
    public final ContiPerfRule rule = new ContiPerfRule();
    private StatsdClient proxy;
    @Before
    public void init() throws IOException {
        proxy = ClientProxy.create(new StatsdClient("localhost", 8125), new Class[] {String.class, Integer.TYPE}, new Object[] {"localhost", 8125});
    }

    @org.junit.Test
    @PerfTest(invocations = 1000)
    public void test() {
        proxy.increment("bat.test", 1, 0.1);
    }
}

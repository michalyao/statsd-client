package org.yaoyao.statsd.client;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;

import java.io.IOException;

public class Test {
    @Rule
    public final ContiPerfRule rule = new ContiPerfRule();

    private StatsdClient client;

    @Before
    public void init() throws IOException {
        client = new StatsdClient("localhost", 8125);
    }

    @org.junit.Test
    @PerfTest(invocations = 1000)
    public void invoke() {
        client.increment("bat.test", 1, 0.1);

    }
}
